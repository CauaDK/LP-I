package org.example.dao;

import org.example.conexao.Conexao;
import org.example.model.Estrela;
import org.example.services.Alert;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class EstrelaDAO {
    Alert alert = new Alert();

    public void createTableIfNotExists() {
        try (Connection c = Conexao.conectar(); Statement state = c.createStatement()) {
            state.execute("CREATE TABLE IF NOT EXISTS estrela (id INTEGER PRIMARY KEY AUTOINCREMENT, temperatura REAL, massa REAL, idade INTEGER); ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Estrela estrela) {
        String sql = "INSERT INTO estrela (temperatura, massa, idade) VALUES (?, ?, ?)";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, estrela.getTemperatura());
            ps.setDouble(2, estrela.getMassa());
            ps.setInt(3, estrela.getIdade());
            ps.executeUpdate();
            alert.sucessoAlert("Estrela adicionado!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao conectar!!" + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM estrela WHERE id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            alert.sucessoAlert("Estrela deletada!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao deletar!! " + e.getMessage());
        }
    }

    public void atualizar(Estrela estrela, int id) {
        String sql = "UPDATE estrela SET temperatura = ?, massa = ?, idade = ? WHERE id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, estrela.getTemperatura());
            ps.setDouble(2, estrela.getMassa());
            ps.setInt(3, estrela.getIdade());
            ps.setInt(4, id);
            ps.executeUpdate();
            alert.sucessoAlert("Estrela atualizada!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao atualizar!! " + e.getMessage());
        }
    }

    public List<String> listar() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM estrela";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(
                        "ID: " + rs.getInt("id")
                                + " | Temp: " + rs.getDouble("temperatura")
                                + " | Massa: " + rs.getDouble("massa")
                                + " | Idade: " + rs.getInt("idade")
                );
            }
        } catch (SQLException e) {
            alert.erroAlert("Erro ao mostrar!! " + e.getMessage());
        }
        return lista;
    }
}

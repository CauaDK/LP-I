package org.example.dao;

import org.example.conexao.Conexao;
import org.example.model.Minerio;
import org.example.services.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MinerioDAO {

    Alert alert = new Alert();

    public void createTableIfNotExists() {
        try (Connection c = Conexao.conectar();
             Statement state = c.createStatement()) {
            state.execute("CREATE TABLE IF NOT EXISTS minerio (id INTEGER PRIMARY KEY AUTOINCREMENT, dureza REAL, pureza REAL, raridade TEXT); ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Minerio minerio) {
        String sql = "INSERT INTO minerio (dureza, pureza, raridade) VALUES (?, ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, minerio.getDureza());
            ps.setDouble(2, minerio.getPureza());
            ps.setString(3, minerio.getRaridade());
            ps.executeUpdate();
            alert.sucessoAlert("Minerio adicionado!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao conectar!!" + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM minerio WHERE id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            alert.sucessoAlert("Minerio deletado!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao deletar!! " + e.getMessage());
        }
    }

    public void atualizar(Minerio minerio, int id) {
        String sql = "UPDATE minerio SET dureza = ?, pureza = ?, raridade = ? WHERE id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, minerio.getDureza());
            ps.setDouble(2, minerio.getPureza());
            ps.setString(3, minerio.getRaridade());
            ps.setInt(4, id);
            ps.executeUpdate();
            alert.sucessoAlert("Minerio atualizado!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao atualizar!! " + e.getMessage());
        }
    }

    public List<String> listar() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM minerio";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(
                        "ID: " + rs.getInt("id")
                                + " | Dureza: " + rs.getDouble("dureza")
                                + " | Pureza: " + rs.getDouble("pureza")
                                + " | Raridade: " + rs.getString("raridade")
                );
            }
        } catch (SQLException e) {
            alert.erroAlert("Erro ao mostrar!! " + e.getMessage());
        }
        return lista;
    }
}

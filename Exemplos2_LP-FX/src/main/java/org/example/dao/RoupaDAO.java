package org.example.dao;

import org.example.conexao.Conexao;
import org.example.model.Roupa;
import org.example.services.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoupaDAO {

    Alert alert = new Alert();

    public void createTableIfNotExists() {
        try (Connection c = Conexao.conectar();
             Statement state = c.createStatement()) {
            state.execute("CREATE TABLE IF NOT EXISTS roupa (id INTEGER PRIMARY KEY AUTOINCREMENT, tamanho REAL, cor TEXT, tecido TEXT); ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Roupa roupa) {
        String sql = "INSERT INTO roupa (tamanho, cor, tecido) VALUES (?, ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, roupa.getTamanho());
            ps.setString(2, roupa.getCor());
            ps.setString(3, roupa.getTecido());
            ps.executeUpdate();
            alert.sucessoAlert("Roupa adicionado!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao conectar!!" + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM estrela WHERE id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            alert.sucessoAlert("Roupa deletada!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao deletar!! " + e.getMessage());
        }
    }

    public void atualizar(Roupa roupa, int id) {
        String sql = "UPDATE roupa SET tamanho = ?, cor = ?, tecido = ? WHERE id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, roupa.getTamanho());
            ps.setString(2, roupa.getCor());
            ps.setString(3, roupa.getTecido());
            ps.setInt(4, id);
            ps.executeUpdate();
            alert.sucessoAlert("Roupa atualizada!!");
        } catch (SQLException e) {
            alert.erroAlert("Erro ao atualizar!! " + e.getMessage());
        }
    }

    public List<String> listar() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM roupa";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(
                        "ID: " + rs.getInt("id")
                                + " | Tamanho: " + rs.getDouble("tamanho")
                                + " | Cor: " + rs.getString("cor")
                                + " | Tecido: " + rs.getString("tecido")
                );
            }
        } catch (SQLException e) {
            alert.erroAlert("Erro ao mostrar!! " + e.getMessage());
        }
        return lista;
    }
}

package org.example.dao;

import org.example.conexao.Conexao;
import org.example.model.Roupa;
import org.example.services.Alert;

import java.sql.*;

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
            alert.sucessoAlert();
        } catch (SQLException e) {
            alert.erroAlert("Erro ao conectar!!" + e.getMessage());
        }
    }
}

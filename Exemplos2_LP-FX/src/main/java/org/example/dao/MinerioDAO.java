package org.example.dao;

import org.example.conexao.Conexao;
import org.example.model.Minerio;
import org.example.services.Alert;

import java.sql.*;

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
            alert.sucessoAlert();
        } catch (SQLException e) {
            alert.erroAlert("Erro ao conectar!!" + e.getMessage());
        }
    }
}

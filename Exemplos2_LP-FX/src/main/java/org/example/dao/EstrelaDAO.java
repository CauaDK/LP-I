package org.example.dao;

import org.example.conexao.Conexao;
import org.example.model.Estrela;
import org.example.services.Alert;

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
            alert.sucessoAlert();
        } catch (SQLException e) {
            alert.erroAlert("Erro ao conectar!!" + e.getMessage());
        }
    }
}

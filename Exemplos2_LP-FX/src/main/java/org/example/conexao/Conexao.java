package org.example.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String path = "src/main/resources/org/example/db/musica.db";
    private static final String url = "jdbc:sqlite:" + path;

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url);
    }
}


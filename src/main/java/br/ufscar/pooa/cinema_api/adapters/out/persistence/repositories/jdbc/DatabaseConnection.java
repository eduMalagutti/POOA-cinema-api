package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements AutoCloseable {
    private static DatabaseConnection instance = null;
    private Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/cinema-db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}

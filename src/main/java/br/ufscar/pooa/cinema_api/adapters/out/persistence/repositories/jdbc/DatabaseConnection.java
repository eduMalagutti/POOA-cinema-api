package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements AutoCloseable {
    private static volatile DatabaseConnection instance = null;
    private Connection connection;

    private final String url = "jdbc:postgresql://localhost:5432/cinema-db";
    private final String user = "root";
    private final String password = "root";

    private DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public synchronized static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}

package br.ufscar.pooa.cinema_api.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager implements AutoCloseable {
    private static DatabaseManager instance = null;
    private Connection connection;

    private String url = "jdbc:postgresql://localhost:5432/framework-db";
    private String user = "root";
    private String password = "root";

    public DatabaseManager(String url, String user, String password) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connection = DriverManager.getConnection(url, user, password);
    }

    private DatabaseManager() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public static synchronized DatabaseManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseManager();
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

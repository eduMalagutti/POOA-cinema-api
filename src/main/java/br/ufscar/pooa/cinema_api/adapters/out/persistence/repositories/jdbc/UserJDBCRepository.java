package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc;

import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import br.ufscar.pooa.cinema_api.domain.model.User;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.database.DatabaseManager;

import java.sql.*;
import java.util.Optional;

public class UserJDBCRepository implements IUserRepository {
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try {
            DatabaseManager conn = DatabaseManager.getInstance();
            PreparedStatement statement = conn.getConnection().prepareStatement(sql);

            statement.setString(1, email);
            User usuario = new User();

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getLong("id"));
                usuario.setName(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("senha"));
            }

            rs.close();
            statement.close();
            conn.getConnection().close();

            if (usuario.getId() == null)
                return Optional.empty();

            return Optional.of(usuario);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User save(User usuario) {
        String sql = """ 
                    INSERT INTO usuarios (nome, email, senha)
                    VALUES (?, ?, ?)
                """;

        try (DatabaseManager conn = DatabaseManager.getInstance();
             PreparedStatement statement = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, usuario.getName());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getPassword());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User usuario) {

    }
}

package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc;

import br.ufscar.pooa.cinema_api.application.ports.out.IUsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;

import java.sql.*;
import java.util.Optional;

public class UsuarioJDBCRepository implements IUsuarioRepository {
    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try {
            DatabaseConnection conn = DatabaseConnection.getInstance();
            PreparedStatement statement = conn.getConnection().prepareStatement(sql);

            statement.setString(1, email);
            Usuario usuario = new Usuario();

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
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
    public Usuario save(Usuario usuario) {
        String sql = """ 
                    INSERT INTO usuarios (nome, email, senha)
                    VALUES (?, ?, ?)
                """;

        try (DatabaseConnection conn = DatabaseConnection.getInstance();
             PreparedStatement statement = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
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
    public void delete(Usuario usuario) {

    }
}

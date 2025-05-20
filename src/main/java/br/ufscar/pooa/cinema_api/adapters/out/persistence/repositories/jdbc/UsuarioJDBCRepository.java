package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc;

import br.ufscar.pooa.cinema_api.application.ports.out.IUsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioJDBCRepository implements IUsuarioRepository {
    @Override
    public Optional<Usuario> findById(Long id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (DatabaseConnection conn = DatabaseConnection.getInstance();
             PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                return Optional.of(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por ID", e);
        }

        return Optional.empty();
    }

    @Override
    public ArrayList<Usuario> list() {
        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (DatabaseConnection conn = DatabaseConnection.getInstance();
             Statement stmt = conn.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários", e);
        }

        return usuarios;
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

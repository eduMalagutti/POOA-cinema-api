package br.ufscar.pooa.cinema_api.application.port.out;

import br.ufscar.pooa.cinema_api.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
    Usuario save(Usuario usuario);
    void delete(Usuario usuario);
}

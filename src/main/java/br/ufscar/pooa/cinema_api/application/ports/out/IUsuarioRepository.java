package br.ufscar.pooa.cinema_api.application.ports.out;

import br.ufscar.pooa.cinema_api.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> list();
    Usuario save(Usuario usuario);
    void delete(Usuario usuario);
}

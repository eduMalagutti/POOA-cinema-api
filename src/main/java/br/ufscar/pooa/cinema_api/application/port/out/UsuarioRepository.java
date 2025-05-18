package br.ufscar.pooa.cinema_api.application.port.out;

import br.ufscar.pooa.cinema_api.domain.model.Usuario;

public interface UsuarioRepository {
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void delete(Usuario usuario);
}

package br.ufscar.pooa.cinema_api.application.usecases;

import br.ufscar.pooa.cinema_api.application.port.out.UsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class RegisterUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public RegisterUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario execute(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}

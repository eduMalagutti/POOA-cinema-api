package br.ufscar.pooa.cinema_api.application.usecases;

import br.ufscar.pooa.cinema_api.application.exceptions.ResourceAlreadyExistsException;
import br.ufscar.pooa.cinema_api.application.port.out.UsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public RegisterUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario execute(Usuario usuario) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioEncontrado.isPresent()) {
            throw new ResourceAlreadyExistsException("Usuario", "email", usuario.getEmail());
        }

        return usuarioRepository.save(usuario);
    }
}

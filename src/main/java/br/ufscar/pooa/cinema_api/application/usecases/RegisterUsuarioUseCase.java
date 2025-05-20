package br.ufscar.pooa.cinema_api.application.usecases;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;
import br.ufscar.pooa.cinema_api.application.exceptions.ResourceAlreadyExistsException;
import br.ufscar.pooa.cinema_api.application.mapper.ObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUsuarioUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.IUsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUsuarioUseCase implements IRegisterUsuarioUseCase {
    private final IUsuarioRepository IUsuarioRepository;

    public RegisterUsuarioUseCase(IUsuarioRepository IUsuarioRepository) {
        this.IUsuarioRepository = IUsuarioRepository;
    }

    public UsuarioResponseDTO execute(RegisterUsuarioRequestDTO requestDTO) {
        Optional<Usuario> usuarioEncontrado = IUsuarioRepository.findByEmail(requestDTO.email());

        if (usuarioEncontrado.isPresent()) {
            throw new ResourceAlreadyExistsException("Usuario", "email", requestDTO.email());
        }

        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setSenha(requestDTO.senha());

        Usuario usuarioSalvo = IUsuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail(), usuarioSalvo.getSenha());
    }
}

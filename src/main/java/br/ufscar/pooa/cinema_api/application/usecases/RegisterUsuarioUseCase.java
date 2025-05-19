package br.ufscar.pooa.cinema_api.application.usecases;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;
import br.ufscar.pooa.cinema_api.application.exceptions.ResourceAlreadyExistsException;
import br.ufscar.pooa.cinema_api.application.mapper.ObjectMapper;
import br.ufscar.pooa.cinema_api.application.gateways.UsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public RegisterUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO execute(RegisterUsuarioRequestDTO requestDTO) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(requestDTO.email());

        if (usuarioEncontrado.isPresent()) {
            throw new ResourceAlreadyExistsException("Usuario", "email", requestDTO.email());
        }

        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setSenha(requestDTO.senha());

        Usuario response = usuarioRepository.save(usuario);

        return ObjectMapper.parseObject(response, UsuarioResponseDTO.class);
    }
}

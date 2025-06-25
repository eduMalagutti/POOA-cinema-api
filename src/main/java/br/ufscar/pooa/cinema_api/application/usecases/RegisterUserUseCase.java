package br.ufscar.pooa.cinema_api.application.usecases;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UserResponseDTO;
import br.ufscar.pooa.cinema_api.application.exceptions.ResourceAlreadyExistsException;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUserUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import br.ufscar.pooa.cinema_api.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUserUseCase implements IRegisterUserUseCase {
    private final IUserRepository userRepository;

    public RegisterUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO execute(RegisterUserRequestDTO requestDTO) {
        Optional<User> usuarioEncontrado = userRepository.findByEmail(requestDTO.email());

        if (usuarioEncontrado.isPresent()) {
            throw new ResourceAlreadyExistsException("User", "email", requestDTO.email());
        }

        User usuario = new User();
        usuario.setName(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setPassword(requestDTO.senha());
        usuario.setRole(requestDTO.role());

        User usuarioSalvo = userRepository.save(usuario);

        return new UserResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getName(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getPassword(),
                usuarioSalvo.getRole());
    }
}

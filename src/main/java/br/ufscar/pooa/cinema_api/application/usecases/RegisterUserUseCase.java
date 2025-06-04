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
    private final IUserRepository IUserRepository;

    public RegisterUserUseCase(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    public UserResponseDTO execute(RegisterUserRequestDTO requestDTO) {
        Optional<User> usuarioEncontrado = IUserRepository.findByEmail(requestDTO.email());

        if (usuarioEncontrado.isPresent()) {
            throw new ResourceAlreadyExistsException("User", "email", requestDTO.email());
        }

        User usuario = new User();
        usuario.setName(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setPassword(requestDTO.senha());

        User usuarioSalvo = IUserRepository.save(usuario);

        return new UserResponseDTO(usuarioSalvo.getId(), usuarioSalvo.getName(), usuarioSalvo.getEmail(), usuarioSalvo.getPassword());
    }
}

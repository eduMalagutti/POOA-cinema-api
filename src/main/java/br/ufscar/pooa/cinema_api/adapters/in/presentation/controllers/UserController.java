package br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UserResponseDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IRegisterUserUseCase registerUsuarioUseCase;

    public UserController(IRegisterUserUseCase registerUsuarioUseCase) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterUserRequestDTO registerRequestBody) {
        var responseDTO = registerUsuarioUseCase.execute(registerRequestBody);

        URI uri = URI.create("/users/" + responseDTO.id());

        return ResponseEntity.created(uri).body(responseDTO);
    }
}

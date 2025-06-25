package br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UserResponseDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IRegisterUserUseCase registerUserUseCase;

    public UserController(IRegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody RegisterUserRequestDTO registerRequestBody) {
        var responseDTO = registerUserUseCase.execute(registerRequestBody);

        URI uri = URI.create("/users/" + responseDTO.id());

        return ResponseEntity.created(uri).body(responseDTO);
    }
}

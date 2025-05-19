package br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;
import br.ufscar.pooa.cinema_api.application.usecases.RegisterUsuarioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final RegisterUsuarioUseCase registerUsuarioUseCase;

    public UsuarioController(RegisterUsuarioUseCase registerUsuarioUseCase) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody RegisterUsuarioRequestDTO registerRequestBody) {
        var responseDTO = registerUsuarioUseCase.execute(registerRequestBody);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDTO.id())
                .toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }
}

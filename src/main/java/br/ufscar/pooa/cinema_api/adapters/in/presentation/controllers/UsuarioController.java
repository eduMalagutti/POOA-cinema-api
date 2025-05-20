package br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUsuarioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final IRegisterUsuarioUseCase registerUsuarioUseCase;

    public UsuarioController(IRegisterUsuarioUseCase registerUsuarioUseCase) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody RegisterUsuarioRequestDTO registerRequestBody) {
        var responseDTO = registerUsuarioUseCase.execute(registerRequestBody);

        URI uri = URI.create("/usuarios/" + responseDTO.id());

        return ResponseEntity.created(uri).body(responseDTO);
    }
}

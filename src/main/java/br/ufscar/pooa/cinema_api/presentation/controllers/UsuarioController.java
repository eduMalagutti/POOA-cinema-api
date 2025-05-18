package br.ufscar.pooa.cinema_api.presentation.controllers;

import br.ufscar.pooa.cinema_api.application.usecases.RegisterUsuarioUseCase;
import br.ufscar.pooa.cinema_api.infrastructure.mapper.UsuarioMapper;
import br.ufscar.pooa.cinema_api.presentation.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.presentation.dtos.response.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final RegisterUsuarioUseCase registerUsuarioUseCase;
    private final UsuarioMapper mapper;

    public UsuarioController(RegisterUsuarioUseCase registerUsuarioUseCase, UsuarioMapper mapper) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody RegisterUsuarioRequestDTO registerRequestBody) {
        System.out.println(registerRequestBody.toString());

        var usuario = mapper.toDomain(registerRequestBody);
        var usuarioSalvo = registerUsuarioUseCase.execute(usuario);
        return ResponseEntity.ok(mapper.toResponseDTO(usuarioSalvo));
    }
}

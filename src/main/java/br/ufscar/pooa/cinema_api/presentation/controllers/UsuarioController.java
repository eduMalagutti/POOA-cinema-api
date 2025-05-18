package br.ufscar.pooa.cinema_api.presentation.controllers;

import br.ufscar.pooa.cinema_api.application.usecases.RegisterUsuarioUseCase;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import br.ufscar.pooa.cinema_api.presentation.mapper.UsuarioDtoMapper;
import br.ufscar.pooa.cinema_api.presentation.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.presentation.dtos.response.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final RegisterUsuarioUseCase registerUsuarioUseCase;
    private final UsuarioDtoMapper mapper;

    public UsuarioController(RegisterUsuarioUseCase registerUsuarioUseCase, UsuarioDtoMapper mapper) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody RegisterUsuarioRequestDTO registerRequestBody) {
        Usuario usuario = mapper.toDomain(registerRequestBody);
        Usuario usuarioSalvo = registerUsuarioUseCase.execute(usuario);
        return ResponseEntity.ok(mapper.toResponseDTO(usuarioSalvo));
    }
}

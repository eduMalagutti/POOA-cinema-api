package br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers;

import br.ufscar.pooa.cinema_api.application.dtos.request.FindByIdUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IListUsuarioUseCase;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUsuarioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final IRegisterUsuarioUseCase registerUsuarioUseCase;
    private final IListUsuarioUseCase listUsuarioUseCase;

    public UsuarioController(IRegisterUsuarioUseCase registerUsuarioUseCase, IListUsuarioUseCase listUsuarioUseCase) {
        this.registerUsuarioUseCase = registerUsuarioUseCase;
        this.listUsuarioUseCase = listUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody RegisterUsuarioRequestDTO registerRequestBody) {
        var responseDTO = registerUsuarioUseCase.execute(registerRequestBody);

        URI uri = URI.create("/usuarios/" + responseDTO.id());

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        List<UsuarioResponseDTO> responseDTOs = listUsuarioUseCase.list();
        return responseDTOs.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(responseDTOs);
    }

    @GetMapping
    public ResponseEntity<UsuarioResponseDTO> findById(@RequestParam FindByIdUsuarioRequestDTO listRequestBody){
        var respondeDTO = listUsuarioUseCase.findById(listRequestBody);
        return ResponseEntity.ok(respondeDTO);
    }

}

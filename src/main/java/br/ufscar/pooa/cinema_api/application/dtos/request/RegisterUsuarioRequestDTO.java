package br.ufscar.pooa.cinema_api.application.dtos.request;

import jakarta.validation.constraints.NotNull;

public record RegisterUsuarioRequestDTO(
        @NotNull
        String nome,
        @NotNull
        String email,
        @NotNull
        String senha
) {
}

package br.ufscar.pooa.cinema_api.application.dtos.request;

import jakarta.validation.constraints.NotNull;

public record FindByIdUsuarioRequestDTO (
    @NotNull
    Long id
)
{}


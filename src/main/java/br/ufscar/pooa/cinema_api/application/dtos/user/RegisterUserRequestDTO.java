package br.ufscar.pooa.cinema_api.application.dtos.user;

import br.ufscar.pooa.cinema_api.application.validation.ValueOfEnum;
import br.ufscar.pooa.cinema_api.domain.enums.Role;
import jakarta.validation.constraints.NotNull;

public record RegisterUserRequestDTO(
        @NotNull
        String nome,

        @NotNull
        String email,

        @NotNull
        String senha,

        @NotNull
        @ValueOfEnum(enumClass = Role.class)
        Role role
) {
}

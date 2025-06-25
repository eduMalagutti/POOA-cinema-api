package br.ufscar.pooa.cinema_api.application.dtos.response;

import br.ufscar.pooa.cinema_api.domain.enums.Role;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        String senha,
        Role role
) {
}

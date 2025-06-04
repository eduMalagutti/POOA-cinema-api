package br.ufscar.pooa.cinema_api.application.dtos.response;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        String senha
) {
}

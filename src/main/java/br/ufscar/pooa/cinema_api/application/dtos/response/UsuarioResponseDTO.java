package br.ufscar.pooa.cinema_api.application.dtos.response;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String senha
) {
}

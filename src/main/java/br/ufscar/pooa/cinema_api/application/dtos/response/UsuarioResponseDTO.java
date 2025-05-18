package br.ufscar.pooa.cinema_api.application.dtos.response;

public record UsuarioResponseDTO(
        String id,
        String nome,
        String email,
        String senha
) {
}

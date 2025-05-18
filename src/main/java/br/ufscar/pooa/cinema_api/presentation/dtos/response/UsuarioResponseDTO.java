package br.ufscar.pooa.cinema_api.presentation.dtos.response;

public record UsuarioResponseDTO(
        String nome,
        String email,
        String senha
) {
}

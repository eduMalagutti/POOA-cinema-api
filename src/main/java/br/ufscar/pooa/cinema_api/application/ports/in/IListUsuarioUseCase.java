package br.ufscar.pooa.cinema_api.application.ports.in;

import br.ufscar.pooa.cinema_api.application.dtos.request.FindByIdUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;

import java.util.List;

public interface IListUsuarioUseCase {
    List<UsuarioResponseDTO> list();
    UsuarioResponseDTO findById(FindByIdUsuarioRequestDTO requestDTO);
}

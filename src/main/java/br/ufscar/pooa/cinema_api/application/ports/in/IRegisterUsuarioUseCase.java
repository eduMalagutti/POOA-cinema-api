package br.ufscar.pooa.cinema_api.application.ports.in;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;

public interface IRegisterUsuarioUseCase {
    UsuarioResponseDTO execute(RegisterUsuarioRequestDTO requestDTO);
}

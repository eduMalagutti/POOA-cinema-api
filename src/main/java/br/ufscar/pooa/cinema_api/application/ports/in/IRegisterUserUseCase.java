package br.ufscar.pooa.cinema_api.application.ports.in;

import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UserResponseDTO;

public interface IRegisterUserUseCase {
    UserResponseDTO execute(RegisterUserRequestDTO requestDTO);
}

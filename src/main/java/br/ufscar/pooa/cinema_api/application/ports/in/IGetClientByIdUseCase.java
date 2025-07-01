package br.ufscar.pooa.cinema_api.application.ports.in;

import br.ufscar.pooa.cinema_api.application.dtos.client.ClientResponseDTO;

public interface IGetClientByIdUseCase {
    ClientResponseDTO execute(Long id);
}
package br.ufscar.pooa.cinema_api.application.ports.in;

import br.ufscar.pooa.cinema_api.application.dtos.client.ClientResponseDTO;
import br.ufscar.pooa.cinema_api.application.dtos.client.UpdateClientRequestDTO;

public interface IUpdateClientUseCase {
    ClientResponseDTO execute(Long id, UpdateClientRequestDTO updateClientRequestDTO);
}
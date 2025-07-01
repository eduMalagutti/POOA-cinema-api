package br.ufscar.pooa.cinema_api.application.ports.in;

import br.ufscar.pooa.cinema_api.application.dtos.client.ClientResponseDTO;

import java.util.List;

public interface IGetAllClientsUseCase {
    List<ClientResponseDTO> execute();
}
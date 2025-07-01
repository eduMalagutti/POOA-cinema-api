package br.ufscar.pooa.cinema_api.application.usecases.client;

import br.ufscar.pooa.cinema_api.application.dtos.client.ClientResponseDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IGetAllClientsUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllClientsUseCase implements IGetAllClientsUseCase {

    private final IClientRepository clientRepository;
    private final IObjectMapper objectMapper;

    public GetAllClientsUseCase(IClientRepository clientRepository, IObjectMapper objectMapper) {
        this.clientRepository = clientRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ClientResponseDTO> execute() {
        return clientRepository.findAll().stream()
                .map(client -> objectMapper.parseObject(client, ClientResponseDTO.class))
                .collect(Collectors.toList());
    }
}
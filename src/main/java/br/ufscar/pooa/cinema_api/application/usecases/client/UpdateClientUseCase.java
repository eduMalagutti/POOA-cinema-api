package br.ufscar.pooa.cinema_api.application.usecases.client;

import br.ufscar.pooa.cinema_api.application.dtos.client.ClientResponseDTO;
import br.ufscar.pooa.cinema_api.application.dtos.client.UpdateClientRequestDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IUpdateClientUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IClientRepository;
import br.ufscar.pooa.cinema_api.domain.Client;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateClientUseCase implements IUpdateClientUseCase {

    private final IClientRepository clientRepository;
    private final IObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    public UpdateClientUseCase(IClientRepository clientRepository, IObjectMapper objectMapper, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ClientResponseDTO execute(Long id, UpdateClientRequestDTO updateClientRequestDTO) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                        "Client not found with id: " + id));

        existingClient.setName(updateClientRequestDTO.getName());
        existingClient.setEmail(updateClientRequestDTO.getEmail());
        existingClient.setRole(updateClientRequestDTO.getRole());
        existingClient.setCpf(updateClientRequestDTO.getCpf());
        existingClient.setGender(updateClientRequestDTO.getGender());
        existingClient.setBirthDate(updateClientRequestDTO.getBirthDate());

        if (updateClientRequestDTO.getPassword() != null && !updateClientRequestDTO.getPassword().isEmpty()) {
            existingClient.setPassword(passwordEncoder.encode(updateClientRequestDTO.getPassword()));
        }

        Client updatedClient = clientRepository.save(existingClient);

        return objectMapper.parseObject(updatedClient, ClientResponseDTO.class);
    }
}
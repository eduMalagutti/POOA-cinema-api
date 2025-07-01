package br.ufscar.pooa.cinema_api.application.usecases.client;

import br.ufscar.pooa.cinema_api.application.ports.in.IDeleteClientUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IClientRepository;
import br.ufscar.pooa.cinema_api.domain.Client;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteClientUseCase implements IDeleteClientUseCase {

    private final IClientRepository clientRepository;

    public DeleteClientUseCase(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void execute(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                        "Client not found with id: " + id));
        
        clientRepository.delete(client);
    }
}
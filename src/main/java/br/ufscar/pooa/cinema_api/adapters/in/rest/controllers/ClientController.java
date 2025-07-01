package br.ufscar.pooa.cinema_api.adapters.in.rest.controllers;

import br.ufscar.pooa.cinema_api.application.dtos.client.ClientResponseDTO;
import br.ufscar.pooa.cinema_api.application.dtos.client.RegisterClientRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.client.UpdateClientRequestDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final IRegisterClientUseCase registerClientUseCase;
    private final IGetAllClientsUseCase getAllClientsUseCase;
    private final IGetClientByIdUseCase getClientByIdUseCase;
    private final IUpdateClientUseCase updateClientUseCase;
    private final IDeleteClientUseCase deleteClientUseCase;

    public ClientController(
            IRegisterClientUseCase registerClientUseCase,
            IGetAllClientsUseCase getAllClientsUseCase,
            IGetClientByIdUseCase getClientByIdUseCase,
            IUpdateClientUseCase updateClientUseCase,
            IDeleteClientUseCase deleteClientUseCase) {
        this.registerClientUseCase = registerClientUseCase;
        this.getAllClientsUseCase = getAllClientsUseCase;
        this.getClientByIdUseCase = getClientByIdUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> register(@RequestBody RegisterClientRequestDTO registerRequestBody) {
        var responseDTO = registerClientUseCase.execute(registerRequestBody);

        URI uri = URI.create("/clients/" + responseDTO.getId());

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> clients = getAllClientsUseCase.execute();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        ClientResponseDTO client = getClientByIdUseCase.execute(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(
            @PathVariable Long id,
            @RequestBody UpdateClientRequestDTO updateClientRequestDTO) {

        ClientResponseDTO updatedClient = updateClientUseCase.execute(id, updateClientRequestDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        deleteClientUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}

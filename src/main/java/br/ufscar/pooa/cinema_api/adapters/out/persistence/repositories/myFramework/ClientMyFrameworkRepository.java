package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.myFramework;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.ClientEntity;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IClientRepository;
import br.ufscar.pooa.cinema_api.domain.Client;
import framework.FrameworkClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Profile("myFramework")
@Repository
public class ClientMyFrameworkRepository implements IClientRepository {
    private final FrameworkClass frameworkClass;
    private final IObjectMapper objectMapper;

    public ClientMyFrameworkRepository(FrameworkClass frameworkClass, IObjectMapper objectMapper) {
        this.frameworkClass = frameworkClass;
        this.objectMapper = objectMapper;
    }

    @Override
    public Client save(Client client) {
        ClientEntity entity = objectMapper.parseObject(client, ClientEntity.class);
        Long originalId = entity.getId();

        frameworkClass.save(entity);
        if (entity.getId() == null && originalId == null) {
            throw new RuntimeException("Failed to save client - no ID was generated");
        }

        client.setId(entity.getId());
        return client;
    }

    @Override
    public Optional<Client> findById(Long id) {
        ClientEntity entitySearched = new ClientEntity();
        entitySearched.setId(id);
        boolean found = frameworkClass.findById(entitySearched);

        if (!found) {
            return Optional.empty();
        }

        return Optional.of(objectMapper.parseObject(entitySearched, Client.class));
    }

    @Override
    public Optional<Client> findByCpf(String cpf) {
        ClientEntity entitySearched = new ClientEntity();
        frameworkClass.find("cpf", cpf, entitySearched);

        if (entitySearched.getId() == null) {
            return Optional.empty();
        }

        return Optional.of(objectMapper.parseObject(entitySearched, Client.class));
    }

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

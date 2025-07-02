package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.myFramework;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.ManagerEntity;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IManagerRepository;
import br.ufscar.pooa.cinema_api.domain.Manager;
import framework.FrameworkClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile("myFramework")
@Repository
public class ManagerMyFrameworkRepository implements IManagerRepository {
    private final FrameworkClass frameworkClass;
    private final IObjectMapper objectMapper;

    public ManagerMyFrameworkRepository(FrameworkClass frameworkClass, IObjectMapper objectMapper) {
        this.frameworkClass = frameworkClass;
        this.objectMapper = objectMapper;
    }

    @Override
    public Manager save(Manager manager) {
        ManagerEntity entity = objectMapper.parseObject(manager, ManagerEntity.class);
        Long originalId = entity.getId();

        frameworkClass.save(entity);
        if (entity.getId() == null && originalId == null) {
            throw new RuntimeException("Failed to save manager - no ID was generated");
        }

        manager.setId(entity.getId());
        return manager;
    }

    @Override
    public Optional<Manager> findById(Long id) {
        ManagerEntity entitySearched = new ManagerEntity();
        entitySearched.setId(id);
        boolean found = frameworkClass.findById(entitySearched);

        if (!found) {
            return Optional.empty();
        }

        return Optional.of(objectMapper.parseObject(entitySearched, Manager.class));
    }

    @Override
    public Optional<Manager> findByCpf(String cpf) {
        ManagerEntity entitySearched = new ManagerEntity();
        frameworkClass.find("cpf", cpf, entitySearched);

        if (entitySearched.getId() == null) {
            return Optional.empty();
        }

        return Optional.of(objectMapper.parseObject(entitySearched, Manager.class));
    }

    @Override
    public void delete(Manager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

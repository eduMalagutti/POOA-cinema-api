package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.theater;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.TheaterEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UserEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.user.UserJpaRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.ITheaterRepository;
import br.ufscar.pooa.cinema_api.domain.Theater;
import br.ufscar.pooa.cinema_api.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class TheaterRepositoryAdapter implements ITheaterRepository {
    private final TheaterJpaRepository theaterJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final IObjectMapper objectMapper;

    public TheaterRepositoryAdapter(TheaterJpaRepository theaterJpaRepository,
                                    UserJpaRepository userJpaRepository,
                                    IObjectMapper objectMapper) {
        this.theaterJpaRepository = theaterJpaRepository;
        this.userJpaRepository = userJpaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Theater save(Theater theater) {
        TheaterEntity theaterEntity = objectMapper.parseObject(theater, TheaterEntity.class);
        if (theater.getManagers() != null && !theater.getManagers().isEmpty()) {
            Set<Long> managerIds = theater.getManagers().stream()
                    .map(User::getId)
                    .collect(Collectors.toSet());

            Set<UserEntity> managedManagers = new HashSet<>(userJpaRepository.findAllById(managerIds));
            theaterEntity.setManagers(managedManagers);
            for (UserEntity manager : managedManagers) {
                manager.setTheater(theaterEntity);
            }
        }
        TheaterEntity savedEntity = theaterJpaRepository.save(theaterEntity);
        return objectMapper.parseObject(savedEntity, Theater.class);
    }

    @Override
    public Optional<Theater> findById(Long id) {
        Optional<TheaterEntity> entityOptional = theaterJpaRepository.findById(id);
        return entityOptional.map(entity -> objectMapper.parseObject(entity, Theater.class));
    }

    @Override
    public Optional<Theater> findByName(String name) {
        Optional<TheaterEntity> entityOptional = theaterJpaRepository.findByName(name);
        return entityOptional.map(entity -> objectMapper.parseObject(entity, Theater.class));
    }

    @Override
    public void delete(Theater theater) {
        TheaterEntity entity = objectMapper.parseObject(theater, TheaterEntity.class);
        theaterJpaRepository.delete(entity);
    }
}
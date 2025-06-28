package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.theater;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.TheaterEntity;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.ITheaterRepository;
import br.ufscar.pooa.cinema_api.domain.Theater;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TheaterAdapterRepository implements ITheaterRepository {
    private final TheaterJpaRepository theaterJpaRepository;
    private final IObjectMapper objectMapper;

    public TheaterAdapterRepository(TheaterJpaRepository theaterJpaRepository, IObjectMapper objectMapper) {
        this.theaterJpaRepository = theaterJpaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Theater save(Theater theater) {
        if (theater == null) {
            throw new IllegalArgumentException("Theater cannot be null");
        }
        if (theater.getId() != null) {
            throw new IllegalArgumentException("Theater ID must be null for a new theater");
        }

        TheaterEntity entityToSave = objectMapper.parseObject(theater, TheaterEntity.class);
        TheaterEntity savedEntity = theaterJpaRepository.save(entityToSave);
        return objectMapper.parseObject(savedEntity, Theater.class);
    }

    @Override
    public Optional<Theater> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return theaterJpaRepository.findById(id)
                .map(entity -> objectMapper.parseObject(entity, Theater.class));
    }

    @Override
    public void delete(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        theaterJpaRepository.deleteById(id);

    }

    @Override
    public Long count() {
        return theaterJpaRepository.count();
    }
}

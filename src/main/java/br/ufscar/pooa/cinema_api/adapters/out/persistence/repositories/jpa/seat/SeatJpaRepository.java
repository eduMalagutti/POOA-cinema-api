package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.seat;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatJpaRepository extends JpaRepository<SeatEntity, Long> {
    Optional<SeatEntity> findById(Long id);

}

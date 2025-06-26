package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.theater;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterJpaRepository extends JpaRepository<TheaterEntity, Long> {
}
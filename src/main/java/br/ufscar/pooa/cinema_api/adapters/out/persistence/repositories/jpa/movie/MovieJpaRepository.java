package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.movie;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
}
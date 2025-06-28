package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.session;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.SessionEntity;
import br.ufscar.pooa.cinema_api.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionJpaRepository extends JpaRepository<SessionEntity, Long> {
}
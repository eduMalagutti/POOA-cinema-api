package br.ufscar.pooa.cinema_api.application.ports.out.repository;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.SessionEntity;
import br.ufscar.pooa.cinema_api.domain.Session;

import java.util.Optional;

public interface ISessionRepository {
    Session save(Session session);

    Optional<Session> findById(Long id);

    void delete(Long id);
}

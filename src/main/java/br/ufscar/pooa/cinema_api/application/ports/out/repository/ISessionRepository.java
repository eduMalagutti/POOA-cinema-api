package br.ufscar.pooa.cinema_api.application.ports.out.repository;

import br.ufscar.pooa.cinema_api.domain.Session;

import java.util.Optional;

public interface ISessionRepository {
    Optional<Session> findById(Long id);

    Session save(Session session);

    void delete(Session session);
}

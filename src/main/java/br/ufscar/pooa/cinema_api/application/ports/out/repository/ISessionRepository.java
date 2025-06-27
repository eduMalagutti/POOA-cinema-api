package br.ufscar.pooa.cinema_api.application.ports.out.repository;

import br.ufscar.pooa.cinema_api.domain.Session;

import java.util.Optional;

public interface ISessionRepository {
    Session save(Session session);

    Optional<Session> findById(Long id);

    void delete(Session session);
}

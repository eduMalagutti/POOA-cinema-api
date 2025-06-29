package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.session;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.SessionEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface SessionJpaRepository extends JpaRepository<SessionEntity, Long> {
    @Override
    @EntityGraph(attributePaths = {"room", "room.rows", "room.rows.seats" , "tickets"})
    Optional<SessionEntity> findById(@NonNull Long id);
}
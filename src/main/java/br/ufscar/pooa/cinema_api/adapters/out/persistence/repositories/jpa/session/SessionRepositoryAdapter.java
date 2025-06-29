package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.session;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.SessionEntity;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.ISessionRepository;
import br.ufscar.pooa.cinema_api.domain.Session;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SessionRepositoryAdapter implements ISessionRepository {
    private final SessionJpaRepository sessionJpaRepository;
    private final IObjectMapper objectMapper;

    public SessionRepositoryAdapter(SessionJpaRepository sessionJpaRepository, IObjectMapper objectMapper) {
        this.sessionJpaRepository = sessionJpaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Session save(Session session) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null");
        }
        if (session.getId() != null) {
            throw new IllegalArgumentException("Session ID must be null for a new session");
        }

        SessionEntity sessionEntity = objectMapper.parseObject(session, SessionEntity.class);
        SessionEntity savedEntity = sessionJpaRepository.save(sessionEntity);
        return objectMapper.parseObject(savedEntity, Session.class);
    }

    @Override
    public Optional<Session> findById(Long id) {
        Optional<SessionEntity> entityOptional = sessionJpaRepository.findById(id);

        return entityOptional.map(sessionEntity -> {
            System.out.println(sessionEntity.getRoom());
            System.out.println(sessionEntity.getRoom().getRows());
            System.out.println(sessionEntity.getRoom().getRows().getFirst().getSeats());
            System.out.println(sessionEntity.getTickets());
            var session = objectMapper.parseObject(sessionEntity, Session.class);
            System.out.println();
            System.out.println(session.getRoom());
            System.out.println(session.getRoom().getRows());
            System.out.println(session.getRoom().getRows().getFirst().getSeats());
            System.out.println(session.getTickets());
            return session;
        });
    }

    @Override
    public void delete(Long id) {
        sessionJpaRepository.deleteById(id);
    }
}
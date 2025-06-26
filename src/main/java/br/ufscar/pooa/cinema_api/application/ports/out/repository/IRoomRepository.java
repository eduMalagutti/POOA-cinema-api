package br.ufscar.pooa.cinema_api.application.ports.out.repository;

import br.ufscar.pooa.cinema_api.domain.Room;

import java.util.Optional;

public interface IRoomRepository {
    Optional<Room> findById(Long id);

    Room save(Room room);

    void delete(Room room);
}

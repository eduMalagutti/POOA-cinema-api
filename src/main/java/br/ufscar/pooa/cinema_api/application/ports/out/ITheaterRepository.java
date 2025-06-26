package br.ufscar.pooa.cinema_api.application.ports.out;

import br.ufscar.pooa.cinema_api.domain.Theater;

import java.util.Optional;

public interface ITheaterRepository {
    Optional<Theater> findById(Long id);

    Optional<Theater> findByName(String email);

    Theater save(Theater theater);

    void delete(Theater theater);
}

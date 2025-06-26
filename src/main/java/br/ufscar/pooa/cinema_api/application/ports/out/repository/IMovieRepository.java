package br.ufscar.pooa.cinema_api.application.ports.out.repository;

import br.ufscar.pooa.cinema_api.domain.Movie;

import java.util.Optional;

public interface IMovieRepository {
    Optional<Movie> findById(Long id);

    Movie save(Movie movie);

    void delete(Movie movie);
}

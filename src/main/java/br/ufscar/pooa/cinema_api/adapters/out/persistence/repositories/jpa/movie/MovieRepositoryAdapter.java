package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.movie;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.GenreEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.MovieEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.genre.GenreJpaRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IMovieRepository;
import br.ufscar.pooa.cinema_api.domain.Movie;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryAdapter implements IMovieRepository {
    private final MovieJpaRepository movieJpaRepository;
    private final GenreJpaRepository genreJpaRepository;
    private final IObjectMapper objectMapper;

    public MovieRepositoryAdapter(MovieJpaRepository movieJpaRepository, GenreJpaRepository genreJpaRepository, IObjectMapper objectMapper) {
        this.movieJpaRepository = movieJpaRepository;
        this.genreJpaRepository = genreJpaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Movie save(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null");
        }
        if (movie.getId() != null) {
            throw new IllegalArgumentException("Movie ID must be null for a new movie");
        }

        MovieEntity entityToSave = objectMapper.parseObject(movie, MovieEntity.class);

        // Re-hydrate the genres to ensure they are managed entities
        if (entityToSave.getGenres() != null && !entityToSave.getGenres().isEmpty()) {
            Set<GenreEntity> managedGenres = entityToSave.getGenres().stream()
                    .map(genre -> genreJpaRepository.findById(genre.getId())
                            .orElseThrow(() -> new EntityNotFoundException("Genre not found with id: " + genre.getId())))
                    .collect(Collectors.toSet());
            entityToSave.setGenres(managedGenres);
        }

        MovieEntity savedEntity = movieJpaRepository.save(entityToSave);
        return objectMapper.parseObject(savedEntity, Movie.class);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return movieJpaRepository.findById(id)
                .map(entity -> objectMapper.parseObject(entity, Movie.class));
    }

    @Override
    public void delete(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        movieJpaRepository.deleteById(id);
    }
}

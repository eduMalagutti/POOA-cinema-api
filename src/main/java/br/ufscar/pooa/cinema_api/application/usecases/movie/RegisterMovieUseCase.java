package br.ufscar.pooa.cinema_api.application.usecases.movie;

import br.ufscar.pooa.cinema_api.application.dtos.movie.RegisterMovieRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.movie.MovieResponseDTO;
import br.ufscar.pooa.cinema_api.application.exceptions.ResourceAlreadyExistsException;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterMovieUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IMovieRepository;
import br.ufscar.pooa.cinema_api.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterMovieUseCase implements IRegisterMovieUseCase {

    private final IMovieRepository movieRepository;
    private final IObjectMapper objectMapper;

    public RegisterMovieUseCase(IMovieRepository movieRepository, IObjectMapper objectMapper) {
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
    }

    public MovieResponseDTO execute(RegisterMovieRequestDTO requestDTO) {
        Optional<Movie> movieFound = movieRepository.findByTitle(requestDTO.getTitle());

        if (movieFound.isPresent()) {
            throw new ResourceAlreadyExistsException("Movie", "title", requestDTO.getTitle());
        }

        Movie newMovie = objectMapper.parseObject(requestDTO, Movie.class);
        Movie savedMovie = movieRepository.save(newMovie);

        return objectMapper.parseObject(savedMovie, MovieResponseDTO.class);
    }
}

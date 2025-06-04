package br.ufscar.pooa.cinema_api.domain.model;

import java.util.List;
import java.util.Objects;

public class MovieGenre {
	private Integer id;
	private String name;
	private List<Movie> movies;

	public MovieGenre(Integer id, String name, List<Movie> movies) {
		this.id = id;
		this.name = name;
		this.movies = movies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		MovieGenre movieGenre = (MovieGenre) o;
		return Objects.equals(id, movieGenre.id) && Objects.equals(name, movieGenre.name) && Objects.equals(movies, movieGenre.movies);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, movies);
	}
}
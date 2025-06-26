package br.ufscar.pooa.cinema_api.domain;

import java.util.Set;
import java.util.Objects;

public class Genre {
	private Integer id;
	private String name;
	private Set<Movie> movies;

	public Genre(Integer id, String name, Set<Movie> movies) {
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

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Genre genre = (Genre) o;
		return Objects.equals(id, genre.id) && Objects.equals(name, genre.name) && Objects.equals(movies, genre.movies);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, movies);
	}
}
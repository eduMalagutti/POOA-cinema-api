package br.ufscar.pooa.cinema_api.domain;

import java.util.Collection;
import java.util.Objects;

public class Genero {
	public Genero(Integer id, String name, Collection<Filme> filmes) {
		this.id = id;
		this.name = name;
		this.filmes = filmes;
	}

	private Integer id;

	private String name;

	private Collection<Filme> filmes;

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

	public Collection<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Collection<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Genero genero = (Genero) o;
		return Objects.equals(id, genero.id) && Objects.equals(name, genero.name) && Objects.equals(filmes, genero.filmes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, filmes);
	}
}

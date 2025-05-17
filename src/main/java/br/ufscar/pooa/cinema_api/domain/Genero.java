package br.ufscar.pooa.cinema_api.domain;

import java.util.List;
import java.util.Objects;

public class Genero {
	private Integer id;
	private String name;
	private List<Filme> filmes;

	public Genero(Integer id, String name, List<Filme> filmes) {
		this.id = id;
		this.name = name;
		this.filmes = filmes;
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

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
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

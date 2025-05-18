package br.ufscar.pooa.cinema_api.domain.model;

import java.util.List;
import java.util.Objects;

public class GeneroFilme {
	private Integer id;
	private String name;
	private List<Filme> filmes;

	public GeneroFilme(Integer id, String name, List<Filme> filmes) {
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
		GeneroFilme generoFilme = (GeneroFilme) o;
		return Objects.equals(id, generoFilme.id) && Objects.equals(name, generoFilme.name) && Objects.equals(filmes, generoFilme.filmes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, filmes);
	}
}

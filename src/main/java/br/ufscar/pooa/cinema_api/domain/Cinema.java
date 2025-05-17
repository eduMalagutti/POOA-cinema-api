package br.ufscar.pooa.cinema_api.domain;

import java.util.Collection;
import java.util.Objects;

public class Cinema {
	public Cinema(String nome, String logo, Collection<Sala> salas, Papel papel, Endereco endereco, Collection<Usuario> gerentes, Collection<Filme> filmes) {
		this.nome = nome;
		this.logo = logo;
		this.salas = salas;
		this.papel = papel;
		this.endereco = endereco;
		this.gerentes = gerentes;
		this.filmes = filmes;
	}

	private String nome;

	private String logo;

	private Collection<Sala> salas;

	private Papel papel;

	private Endereco endereco;

	private Collection<Usuario> gerentes;

	private Collection<Filme> filmes;

	public Filme[] getCatalogo() {
		return null;
	}

	public Sessao[] getProgramacao() {
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Collection<Sala> getSalas() {
		return salas;
	}

	public void setSalas(Collection<Sala> salas) {
		this.salas = salas;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Collection<Usuario> getGerentes() {
		return gerentes;
	}

	public void setGerentes(Collection<Usuario> gerentes) {
		this.gerentes = gerentes;
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
		Cinema cinema = (Cinema) o;
		return Objects.equals(nome, cinema.nome) && Objects.equals(logo, cinema.logo) && Objects.equals(salas, cinema.salas) && papel == cinema.papel && Objects.equals(endereco, cinema.endereco) && Objects.equals(gerentes, cinema.gerentes) && Objects.equals(filmes, cinema.filmes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, logo, salas, papel, endereco, gerentes, filmes);
	}
}

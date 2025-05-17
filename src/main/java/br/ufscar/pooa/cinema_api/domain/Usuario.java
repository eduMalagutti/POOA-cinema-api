package br.ufscar.pooa.cinema_api.domain;

import java.util.Objects;

public class Usuario {
	public Usuario(String nome, String email, String senha, Cinema cinema) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cinema = cinema;
	}

	private String nome;

	private String email;

	private String senha;

	private Cinema cinema;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && Objects.equals(cinema, usuario.cinema);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, email, senha, cinema);
	}
}

package br.ufscar.pooa.cinema_api.domain;

import java.util.Collection;
import java.util.Objects;

public class Sala {
	public Sala(Collection<Sessao> sessoes, Collection<Fileira> fileiras, TipoSala tipoSala, Cinema cinema, String nome) {
		this.sessoes = sessoes;
		this.fileiras = fileiras;
		this.tipoSala = tipoSala;
		this.cinema = cinema;
		this.nome = nome;
	}

	private String nome;

	private Cinema cinema;

	private TipoSala tipoSala;

	private Collection<Fileira> fileiras;

	private Collection<Sessao> sessoes;

	public Sessao[] getSessoes() {
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public TipoSala getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(TipoSala tipoSala) {
		this.tipoSala = tipoSala;
	}

	public Collection<Fileira> getFileiras() {
		return fileiras;
	}

	public void setFileiras(Collection<Fileira> fileiras) {
		this.fileiras = fileiras;
	}

	public void setSessoes(Collection<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Sala sala = (Sala) o;
		return Objects.equals(nome, sala.nome) && Objects.equals(cinema, sala.cinema) && tipoSala == sala.tipoSala && Objects.equals(fileiras, sala.fileiras) && Objects.equals(sessoes, sala.sessoes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, cinema, tipoSala, fileiras, sessoes);
	}
}

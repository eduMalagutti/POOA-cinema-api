package br.ufscar.pooa.cinema_api.domain.model;

import java.util.List;
import java.util.Objects;

public class Fileira {
	private Character letra;
	private Sala sala;
	private List<Assento> assentos;

	public Fileira(Character letra, Sala sala, List<Assento> assentos) {
		this.letra = letra;
		this.sala = sala;
		this.assentos = assentos;
	}

	public Character getLetra() {
		return letra;
	}

	public void setLetra(Character letra) {
		this.letra = letra;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Fileira fileira = (Fileira) o;
		return Objects.equals(letra, fileira.letra) && Objects.equals(sala, fileira.sala) && Objects.equals(assentos, fileira.assentos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(letra, sala, assentos);
	}
}

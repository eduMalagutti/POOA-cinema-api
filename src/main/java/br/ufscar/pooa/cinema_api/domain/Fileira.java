package br.ufscar.pooa.cinema_api.domain;

import java.util.Collection;
import java.util.Objects;

public class Fileira {
	public Fileira(Character letra, Sala sala, Collection<Assento> assentos) {
		this.letra = letra;
		this.sala = sala;
		this.assentos = assentos;
	}

	private Character letra;

	private Sala sala;

	private Collection<Assento> assentos;

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

	public Collection<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(Collection<Assento> assentos) {
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

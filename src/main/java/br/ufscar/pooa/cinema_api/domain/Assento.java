package br.ufscar.pooa.cinema_api.domain;

import java.util.Collection;
import java.util.Objects;

public class Assento {
	public Assento(Character numero, Fileira fileira, Collection<Ingresso> ingressos, TipoAssento tipoAssento) {
		this.numero = numero;
		this.fileira = fileira;
		this.ingressos = ingressos;
		this.tipoAssento = tipoAssento;
	}

	private Character numero;

	private Fileira fileira;

	private Collection<Ingresso> ingressos;

	private TipoAssento tipoAssento;

	public Character getNumero() {
		return numero;
	}

	public void setNumero(Character numero) {
		this.numero = numero;
	}

	public Fileira getFileira() {
		return fileira;
	}

	public void setFileira(Fileira fileira) {
		this.fileira = fileira;
	}

	public Collection<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Collection<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public TipoAssento getTipoAssento() {
		return tipoAssento;
	}

	public void setTipoAssento(TipoAssento tipoAssento) {
		this.tipoAssento = tipoAssento;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Assento assento = (Assento) o;
		return Objects.equals(numero, assento.numero) && Objects.equals(fileira, assento.fileira) && Objects.equals(ingressos, assento.ingressos) && tipoAssento == assento.tipoAssento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, fileira, ingressos, tipoAssento);
	}
}

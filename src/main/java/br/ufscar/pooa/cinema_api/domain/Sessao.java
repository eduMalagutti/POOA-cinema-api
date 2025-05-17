package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.Formato;
import br.ufscar.pooa.cinema_api.domain.enums.Legenda;

import java.util.Collection;
import java.util.Objects;

public class Sessao {
	private Long id;
	private Formato formato;
	private Integer data;
	private Legenda legenda;
	private Integer precoEmCentavos;
	private Sala sala;
	private Filme filme;
	private Collection<Ingresso> ingressos;

	public Sessao(Formato formato, Integer data, Legenda legenda, Integer precoEmCentavos, Sala sala, Filme filme, Collection<Ingresso> ingressos) {
		this.formato = formato;
		this.data = data;
		this.legenda = legenda;
		this.precoEmCentavos = precoEmCentavos;
		this.sala = sala;
		this.filme = filme;
		this.ingressos = ingressos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Assento[] getAssentosDisponiveis() {
		return null;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Legenda getLegenda() {
		return legenda;
	}

	public void setLegenda(Legenda legenda) {
		this.legenda = legenda;
	}

	public Integer getPrecoEmCentavos() {
		return precoEmCentavos;
	}

	public void setPrecoEmCentavos(Integer precoEmCentavos) {
		this.precoEmCentavos = precoEmCentavos;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Collection<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Collection<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Sessao sessao = (Sessao) o;
		return formato == sessao.formato && Objects.equals(data, sessao.data) && legenda == sessao.legenda && Objects.equals(precoEmCentavos, sessao.precoEmCentavos) && Objects.equals(sala, sessao.sala) && Objects.equals(filme, sessao.filme) && Objects.equals(ingressos, sessao.ingressos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(formato, data, legenda, precoEmCentavos, sala, filme, ingressos);
	}
}

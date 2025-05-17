package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.MetodoPagamento;

import java.util.List;
import java.util.Objects;

public class Ingresso {
	private Long id;
	private Integer dataPagamento;
	private Integer precoEmCentavos;
	private Sessao sessao;
	private Cliente cliente;
	private Assento assento;
	private List<MetodoPagamento> metodoPagamentos;

	public Ingresso(Integer dataPagamento, Integer precoEmCentavos, Sessao sessao, Cliente cliente, Assento assento, List<MetodoPagamento> metodoPagamentos) {
		this.dataPagamento = dataPagamento;
		this.precoEmCentavos = precoEmCentavos;
		this.sessao = sessao;
		this.cliente = cliente;
		this.assento = assento;
		this.metodoPagamentos = metodoPagamentos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Integer dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Integer getPrecoEmCentavos() {
		return precoEmCentavos;
	}

	public void setPrecoEmCentavos(Integer precoEmCentavos) {
		this.precoEmCentavos = precoEmCentavos;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public List<MetodoPagamento> getMetodoPagamentos() {
		return metodoPagamentos;
	}

	public void setMetodoPagamentos(List<MetodoPagamento> metodoPagamentos) {
		this.metodoPagamentos = metodoPagamentos;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Ingresso ingresso = (Ingresso) o;
		return Objects.equals(dataPagamento, ingresso.dataPagamento) && Objects.equals(precoEmCentavos, ingresso.precoEmCentavos) && Objects.equals(sessao, ingresso.sessao) && Objects.equals(cliente, ingresso.cliente) && Objects.equals(assento, ingresso.assento) && Objects.equals(metodoPagamentos, ingresso.metodoPagamentos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataPagamento, precoEmCentavos, sessao, cliente, assento, metodoPagamentos);
	}
}

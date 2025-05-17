package domain;

import java.util.Collection;

public class Ingresso {

	private Integer dataPagamento;

	private Integer precoEmCentavos;

	private Sessao sessao;

	private Cliente cliente;

	private Assento assento;

	private Collection<MetodoPagamento> metodoPagamentos;

}

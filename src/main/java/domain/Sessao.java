package domain;

import java.util.Collection;

public class Sessao {

	private Formato formato;

	private Integer data;

	private Legenda legenda;

	private Integer precoEmCentavos;

	private Sala sala;

	private Filme filme;

	private Collection<Ingresso> ingressos;

	public Assento[] montarMapaDeAssentos() {
		return null;
	}

	public Assento[] getAssentosDisponiveis() {
		return null;
	}

}

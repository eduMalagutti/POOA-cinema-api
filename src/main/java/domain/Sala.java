package domain;

import java.util.Collection;

public class Sala {

	private String nome;

	private Cinema cinema;

	private TipoSala tipoSala;

	private Collection<Fileira> fileiras;

	private Collection<Sessao> sessoes;

	public Sessao[] getSessoes() {
		return null;
	}

}

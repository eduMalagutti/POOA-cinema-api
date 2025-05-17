package domain;

import java.util.Collection;

public class Cinema {

	private String nome;

	private String logo;

	private Collection<Sala> salas;

	private Papel papel;

	private Endereco endereco;

	private Collection<Usuario> gerentes;

	private Collection<Filme> filmes;

	public Filme[] getCatalogo() {
		return null;
	}

	public Sessao[] getProgramacao() {
		return null;
	}

}

package domain;

import java.util.Collection;

public class Filme {

	private String titulo;

	private String sinopse;

	private String capaUrl;

	private String trailerUrl;

	private Integer duracaoEmSegundos;

	private Collection<Sessao> sessoes;

	private Cinema cinema;

	private Collection<Genero> generos;

	private ClassificacaoIndicativa classificacaoIndicativa;

	public Sessao[] getSessoesDisponiveis() {
		return null;
	}

}

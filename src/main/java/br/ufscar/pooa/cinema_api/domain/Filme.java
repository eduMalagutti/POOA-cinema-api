package br.ufscar.pooa.cinema_api.domain;

import java.util.Collection;
import java.util.Objects;

public class Filme {
	public Filme(ClassificacaoIndicativa classificacaoIndicativa, Collection<Genero> generos, Cinema cinema, Collection<Sessao> sessoes, Integer duracaoEmSegundos, String trailerUrl, String capaUrl, String sinopse, String titulo) {
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.generos = generos;
		this.cinema = cinema;
		this.sessoes = sessoes;
		this.duracaoEmSegundos = duracaoEmSegundos;
		this.trailerUrl = trailerUrl;
		this.capaUrl = capaUrl;
		this.sinopse = sinopse;
		this.titulo = titulo;
	}

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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getCapaUrl() {
		return capaUrl;
	}

	public void setCapaUrl(String capaUrl) {
		this.capaUrl = capaUrl;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public Integer getDuracaoEmSegundos() {
		return duracaoEmSegundos;
	}

	public void setDuracaoEmSegundos(Integer duracaoEmSegundos) {
		this.duracaoEmSegundos = duracaoEmSegundos;
	}

	public Collection<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(Collection<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Collection<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Collection<Genero> generos) {
		this.generos = generos;
	}

	public ClassificacaoIndicativa getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Filme filme = (Filme) o;
		return Objects.equals(titulo, filme.titulo) && Objects.equals(sinopse, filme.sinopse) && Objects.equals(capaUrl, filme.capaUrl) && Objects.equals(trailerUrl, filme.trailerUrl) && Objects.equals(duracaoEmSegundos, filme.duracaoEmSegundos) && Objects.equals(sessoes, filme.sessoes) && Objects.equals(cinema, filme.cinema) && Objects.equals(generos, filme.generos) && classificacaoIndicativa == filme.classificacaoIndicativa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo, sinopse, capaUrl, trailerUrl, duracaoEmSegundos, sessoes, cinema, generos, classificacaoIndicativa);
	}
}

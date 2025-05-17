package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.ClassificacaoIndicativa;

import java.util.List;
import java.util.Objects;

public class Filme {
	private Long id;
	private String titulo;
	private String sinopse;
	private String capaUrl;
	private String trailerUrl;
	private Integer duracaoEmSegundos;
	private Cinema cinema;
	private List<Sessao> sessoes;
	private List<Genero> generos;
	private ClassificacaoIndicativa classificacaoIndicativa;

	public Filme(ClassificacaoIndicativa classificacaoIndicativa, List<Genero> generos, Cinema cinema, List<Sessao> sessoes, Integer duracaoEmSegundos, String trailerUrl, String capaUrl, String sinopse, String titulo) {
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

	public Sessao[] getSessoesDisponiveis() {
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
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
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Filme filme = (Filme) o;
		return Objects.equals(id, filme.id) && Objects.equals(getTitulo(), filme.getTitulo()) && Objects.equals(getSinopse(), filme.getSinopse()) && Objects.equals(getCapaUrl(), filme.getCapaUrl()) && Objects.equals(getTrailerUrl(), filme.getTrailerUrl()) && Objects.equals(getDuracaoEmSegundos(), filme.getDuracaoEmSegundos()) && Objects.equals(getCinema(), filme.getCinema()) && Objects.equals(getSessoes(), filme.getSessoes()) && Objects.equals(getGeneros(), filme.getGeneros()) && getClassificacaoIndicativa() == filme.getClassificacaoIndicativa();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, getTitulo(), getSinopse(), getCapaUrl(), getTrailerUrl(), getDuracaoEmSegundos(), getCinema(), getSessoes(), getGeneros(), getClassificacaoIndicativa());
	}
}

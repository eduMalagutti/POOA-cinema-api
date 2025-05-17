package br.ufscar.pooa.cinema_api.domain;

import java.util.List;
import java.util.Objects;

public class Cinema {
    private Long id;
    private String nome;
    private String logoUrl;
    private Endereco endereco;
    private List<Sala> salas;
    private List<Usuario> gerentes;
    private List<Filme> filmes;

    public Cinema(String nome, String logoUrl, List<Sala> salas, Endereco endereco, List<Usuario> gerentes, List<Filme> filmes) {
        this.nome = nome;
        this.logoUrl = logoUrl;
        this.salas = salas;
        this.endereco = endereco;
        this.gerentes = gerentes;
        this.filmes = filmes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Usuario> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Usuario> gerentes) {
        this.gerentes = gerentes;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(getId(), cinema.getId()) && Objects.equals(getNome(), cinema.getNome()) && Objects.equals(getLogoUrl(), cinema.getLogoUrl()) && Objects.equals(getEndereco(), cinema.getEndereco()) && Objects.equals(getSalas(), cinema.getSalas()) && Objects.equals(getGerentes(), cinema.getGerentes()) && Objects.equals(getFilmes(), cinema.getFilmes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getLogoUrl(), getEndereco(), getSalas(), getGerentes(), getFilmes());
    }
}

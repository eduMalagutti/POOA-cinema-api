package br.ufscar.pooa.cinema_api.domain.model;

import br.ufscar.pooa.cinema_api.domain.enums.TipoSala;

import java.util.List;
import java.util.Objects;

public class Sala {
    private String nome;
    private TipoSala tipoSala;
    private Cinema cinema;
    private List<Fileira> fileiras;
    private List<Sessao> sessoes;

    public Sala(List<Sessao> sessoes, List<Fileira> fileiras, TipoSala tipoSala, Cinema cinema, String nome) {
        this.sessoes = sessoes;
        this.fileiras = fileiras;
        this.tipoSala = tipoSala;
        this.cinema = cinema;
        this.nome = nome;
    }

    public Sessao[] getSessoes() {
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public List<Fileira> getFileiras() {
        return fileiras;
    }

    public void setFileiras(List<Fileira> fileiras) {
        this.fileiras = fileiras;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return Objects.equals(nome, sala.nome) && Objects.equals(cinema, sala.cinema) && tipoSala == sala.tipoSala && Objects.equals(fileiras, sala.fileiras) && Objects.equals(sessoes, sala.sessoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cinema, tipoSala, fileiras, sessoes);
    }
}

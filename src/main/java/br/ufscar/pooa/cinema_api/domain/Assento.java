package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.TipoAssento;

import java.util.List;
import java.util.Objects;

public class Assento {
    private Character numero;
    private TipoAssento tipoAssento;
    private Fileira fileira;
    private List<Ingresso> ingressos;

    public Assento(Character numero, Fileira fileira, List<Ingresso> ingressos, TipoAssento tipoAssento) {
        this.numero = numero;
        this.fileira = fileira;
        this.ingressos = ingressos;
        this.tipoAssento = tipoAssento;
    }

    public Character getNumero() {
        return numero;
    }

    public void setNumero(Character numero) {
        this.numero = numero;
    }

    public Fileira getFileira() {
        return fileira;
    }

    public void setFileira(Fileira fileira) {
        this.fileira = fileira;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }

    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Assento assento = (Assento) o;
        return Objects.equals(numero, assento.numero) && Objects.equals(fileira, assento.fileira) && Objects.equals(ingressos, assento.ingressos) && tipoAssento == assento.tipoAssento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, fileira, ingressos, tipoAssento);
    }
}

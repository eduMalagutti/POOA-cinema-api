package br.ufscar.pooa.cinema_api.domain.model;

import br.ufscar.pooa.cinema_api.domain.enums.Papel;
import br.ufscar.pooa.cinema_api.domain.enums.Genero;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cliente extends Usuario {
    private String cpf;
    private Genero genero;
    private LocalDateTime dataNascimento;
    private List<Ingresso> ingressos;

    public Cliente(String nome,
                   String email,
                   String senha,
                   Cinema cinema,
                   String cpf,
                   Genero genero,
                   LocalDateTime dataNascimento,
                   List<Ingresso> ingressos,
                   Set<Papel> papeis) {
        super(nome, email, senha, cinema, papeis);
        this.cpf = cpf;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.ingressos = ingressos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf) && Objects.equals(genero, cliente.genero) && Objects.equals(dataNascimento, cliente.dataNascimento) && Objects.equals(ingressos, cliente.ingressos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, genero, dataNascimento, ingressos);
    }
}

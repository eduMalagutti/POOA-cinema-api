package br.ufscar.pooa.cinema_api.domain.model;

import br.ufscar.pooa.cinema_api.domain.enums.Papel;

import java.util.Objects;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Cinema cinema;
    private Papel papel;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Cinema cinema, Papel papel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cinema = cinema;
        this.papel = papel;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cinema=" + cinema +
                ", papeis=" + papel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getSenha(), usuario.getSenha()) && Objects.equals(getCinema(), usuario.getCinema()) && Objects.equals(getPapel(), usuario.getPapel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getEmail(), getSenha(), getCinema(), getPapel());
    }
}

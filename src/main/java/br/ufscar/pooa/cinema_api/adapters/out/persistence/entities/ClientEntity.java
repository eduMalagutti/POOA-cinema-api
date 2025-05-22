package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.Genero;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ClientEntity extends UsuarioEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column
    private String cpf;

    @Column
    @Enumerated(EnumType.STRING)
    private Genero gender;

    @Column
    private LocalDate birthDate;

    public ClientEntity() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getGender() {
        return gender;
    }

    public void setGender(Genero genero) {
        this.gender = genero;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate dataNascimento) {
        this.birthDate = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(getCpf(), that.getCpf()) && getGender() == that.getGender() && Objects.equals(getBirthDate(), that.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCpf(), getGender(), getBirthDate());
    }
}

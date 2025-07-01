package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.Gender;
import br.ufscar.pooa.cinema_api.domain.enums.Role;

import java.time.LocalDateTime;
import java.util.Objects;

public class Manager extends User{
    private String cpf;
    private Gender gender;
    private LocalDateTime birthDate;
    private Theater theater;

    public Manager(String name,
                   String email,
                   String password,
                   String cpf,
                   Gender gender,
                   LocalDateTime birthDate,
                   Theater theater,
                   Role role) {
        super(name, email, password, role);
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
        this.theater = theater;
    }

    public Manager(){
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(cpf, manager.cpf) && gender == manager.gender && Objects.equals(birthDate, manager.birthDate) && Objects.equals(theater, manager.theater);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, gender, birthDate, theater);
    }
}

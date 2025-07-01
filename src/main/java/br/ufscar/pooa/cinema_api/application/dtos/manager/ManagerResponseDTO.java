package br.ufscar.pooa.cinema_api.application.dtos.manager;

import br.ufscar.pooa.cinema_api.application.dtos.user.UserResponseDTO;
import br.ufscar.pooa.cinema_api.domain.Theater;
import br.ufscar.pooa.cinema_api.domain.enums.Gender;
import br.ufscar.pooa.cinema_api.domain.enums.Role;

import java.time.LocalDateTime;

public class ManagerResponseDTO extends UserResponseDTO {

    private String cpf;
    private Gender gender;
    private LocalDateTime birthDate;
    private Theater theater;

    public ManagerResponseDTO() {
        super();
    }

    public ManagerResponseDTO(Long id, String name, String email, String password, Role role, String cpf, Gender gender, LocalDateTime birthDate, Theater theater) {
        super(id, name, email, password, role);
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
        this.theater = theater;
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
}

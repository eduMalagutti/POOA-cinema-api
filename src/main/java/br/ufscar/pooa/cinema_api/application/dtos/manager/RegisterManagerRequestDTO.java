package br.ufscar.pooa.cinema_api.application.dtos.manager;

import br.ufscar.pooa.cinema_api.application.dtos.user.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.domain.enums.Gender;
import br.ufscar.pooa.cinema_api.domain.enums.Role;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RegisterManagerRequestDTO extends RegisterUserRequestDTO {

    @NotNull
    private String cpf;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    private Long theaterId;

    public RegisterManagerRequestDTO() { super(); }

    public RegisterManagerRequestDTO(String name, String email, String password, Role role, String cpf, Gender gender, LocalDateTime birthDate, Long theaterId) {
        super(name, email, password, role);
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
        this.theaterId = theaterId;
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

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }
}

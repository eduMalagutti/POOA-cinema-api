package br.ufscar.pooa.cinema_api.application.dtos.client;

import br.ufscar.pooa.cinema_api.application.dtos.user.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.domain.enums.Gender;
import br.ufscar.pooa.cinema_api.domain.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterClientRequestDTO extends RegisterUserRequestDTO {

    @NotNull
    private String cpf;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDate birthDate;

    public RegisterClientRequestDTO() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

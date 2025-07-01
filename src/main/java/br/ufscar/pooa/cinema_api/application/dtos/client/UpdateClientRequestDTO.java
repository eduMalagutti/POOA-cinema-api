package br.ufscar.pooa.cinema_api.application.dtos.client;

import br.ufscar.pooa.cinema_api.application.validation.ValueOfEnum;
import br.ufscar.pooa.cinema_api.domain.enums.Gender;
import br.ufscar.pooa.cinema_api.domain.enums.Role;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UpdateClientRequestDTO {

    @NotNull
    private String name;

    @NotNull
    private String email;

    private String password;

    @NotNull
    @ValueOfEnum(enumClass = Role.class)
    private Role role;

    @NotNull
    private String cpf;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDateTime birthDate;

    public UpdateClientRequestDTO() {
    }

    public UpdateClientRequestDTO(String name, String email, String password, Role role, String cpf, Gender gender, LocalDateTime birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}
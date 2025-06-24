package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.Role;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.PFColumn;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.PFEntity;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.PFId;
import jakarta.persistence.*;

import java.util.Objects;

@PFEntity(tableName = "users")
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {
    @PFId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PFColumn(name = "name")
    @Column(nullable = false)
    private String name;

    @PFColumn(name = "email")
    @Column(nullable = false, unique = true)
    private String email;

    @PFColumn(name = "password")
    @Column(nullable = false)
    private String password;

    @PFColumn(name = "role")
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private TheaterEntity theater;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String nome) {
        this.name = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String senha) {
        this.password = senha;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserEntity setRole(Role role) {
        this.role = role;
        return this;
    }

    public TheaterEntity getTheater() {
        return theater;
    }

    public UserEntity setTheater(TheaterEntity theater) {
        this.theater = theater;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && getRole() == that.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword(), getRole());
    }
}

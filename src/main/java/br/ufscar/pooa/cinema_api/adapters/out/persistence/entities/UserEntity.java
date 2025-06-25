
package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.Role;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.Enumerated;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.Column;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.Entity;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.Id;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(tableName = "users")
@jakarta.persistence.Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {
    @Id
    @Column(name = "id")
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @jakarta.persistence.Column(nullable = false)
    private String name;

    @Column(name = "email")
    @jakarta.persistence.Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    @jakarta.persistence.Column(nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated
    @jakarta.persistence.Column(nullable = false)
    @jakarta.persistence.Enumerated(EnumType.ORDINAL)
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                getRole() == that.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
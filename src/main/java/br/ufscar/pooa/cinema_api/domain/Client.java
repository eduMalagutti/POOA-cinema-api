package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.Role;
import br.ufscar.pooa.cinema_api.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Client extends User {
    private String cpf;
    private Gender gender;
    private LocalDateTime birthDate;
    private List<Ticket> tickets;

    public Client(String name,
                   String email,
                   String password,
                   Theater theater,
                   String cpf,
                   Gender gender,
                   LocalDateTime birthDate,
                   List<Ticket> tickets,
                   Role role) {
        super(name, email, password, theater, role);
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
        this.tickets = tickets;
    }

    public Client(){
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(cpf, client.cpf) && Objects.equals(gender, client.gender) && Objects.equals(birthDate, client.birthDate) && Objects.equals(tickets, client.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, gender, birthDate, tickets);
    }
}

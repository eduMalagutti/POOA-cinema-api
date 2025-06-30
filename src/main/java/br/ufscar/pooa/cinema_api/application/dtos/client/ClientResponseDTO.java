package br.ufscar.pooa.cinema_api.application.dtos.client;

import br.ufscar.pooa.cinema_api.application.dtos.ticket.TicketResponseDTO;
import br.ufscar.pooa.cinema_api.application.dtos.user.UserResponseDTO;
import br.ufscar.pooa.cinema_api.domain.enums.Gender;
import br.ufscar.pooa.cinema_api.domain.enums.Role;

import java.time.LocalDateTime;
import java.util.List;

public class ClientResponseDTO extends UserResponseDTO {

    private String cpf;
    private Gender gender;
    private LocalDateTime birthDate;
    private List<TicketResponseDTO> tickets;

    public ClientResponseDTO() {
        super();
    }

    public ClientResponseDTO(Long id, String name, String email, String password, Role role, String cpf, Gender gender, LocalDateTime birthDate, List<TicketResponseDTO> tickets) {
        super(id, name, email, password, role);
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
        this.tickets = tickets;
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

    public List<TicketResponseDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketResponseDTO> tickets) {
        this.tickets = tickets;
    }
}
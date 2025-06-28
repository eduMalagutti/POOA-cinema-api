package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.SeatType;

import java.util.List;
import java.util.Objects;

public class Seat {
    private Long id;
    private Character number;
    private SeatType seatType;
    private Row row;
    private List<Ticket> tickets;

    public Seat() {
    }

    public Seat(Character number, Row row, List<Ticket> tickets, SeatType seatType) {
        this.number = number;
        this.row = row;
        this.tickets = tickets;
        this.seatType = seatType;
    }

    public Character getNumber() {
        return number;
    }

    public void setNumber(Character number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }
    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(number, seat.number) && Objects.equals(row, seat.row) && Objects.equals(tickets, seat.tickets) && seatType == seat.seatType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, row, tickets, seatType);
    }

    public void setId(Long id) {
        this.id = id;
    }
}

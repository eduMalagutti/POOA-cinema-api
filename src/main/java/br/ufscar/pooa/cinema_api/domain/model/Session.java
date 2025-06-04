package br.ufscar.pooa.cinema_api.domain.model;

import br.ufscar.pooa.cinema_api.domain.enums.Format;
import br.ufscar.pooa.cinema_api.domain.enums.Subtitle;

import java.util.Collection;
import java.util.Objects;

public class Session {
    private Long id;
    private Format format;
    private Integer date;
    private Subtitle subtitle;
    private Integer priceInCents;
    private Room room;
    private Movie movie;
    private Collection<Ticket> tickets;

    public Session(Format format, Integer date, Subtitle subtitle, Integer priceInCents, Room room, Movie movie, Collection<Ticket> tickets) {
        this.format = format;
        this.date = date;
        this.subtitle = subtitle;
        this.priceInCents = priceInCents;
        this.room = room;
        this.movie = movie;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seat[] getAvailableSeats() {
        return null;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return format == session.format && Objects.equals(date, session.date) && subtitle == session.subtitle && Objects.equals(priceInCents, session.priceInCents) && Objects.equals(room, session.room) && Objects.equals(movie, session.movie) && Objects.equals(tickets, session.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format, date, subtitle, priceInCents, room, movie, tickets);
    }
}

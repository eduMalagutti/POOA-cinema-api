package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.Format;
import br.ufscar.pooa.cinema_api.domain.enums.Subtitle;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sessions")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer date;

    @Column
    private Integer priceInCents;

    @Column
    private Format format;

    @Column
    private Subtitle subtitle;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;

    public SessionEntity() {
    }

    public Long getId() {
        return id;
    }

    public SessionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Format getFormat() {
        return format;
    }

    public SessionEntity setFormat(Format format) {
        this.format = format;
        return this;
    }

    public Integer getDate() {
        return date;
    }

    public SessionEntity setDate(Integer date) {
        this.date = date;
        return this;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public SessionEntity setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public SessionEntity setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
        return this;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public SessionEntity setRoom(RoomEntity room) {
        this.room = room;
        return this;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public SessionEntity setMovie(MovieEntity movie) {
        this.movie = movie;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity that = (SessionEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getPriceInCents(), that.getPriceInCents()) && getFormat() == that.getFormat() && getSubtitle() == that.getSubtitle() && Objects.equals(getRoom(), that.getRoom()) && Objects.equals(getMovie(), that.getMovie()) && Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getPriceInCents(), getFormat(), getSubtitle(), getRoom(), getMovie(), tickets);
    }
}

package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.Format;
import br.ufscar.pooa.cinema_api.domain.enums.Subtitle;
import jakarta.persistence.*;

@Entity
@Table(name = "sessions")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Format format;

    @Column
    private Integer date;

    @Column
    private Subtitle subtitle;

    @Column
    private Integer priceInCents;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

//    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<TicketEntity> tickets;

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
}

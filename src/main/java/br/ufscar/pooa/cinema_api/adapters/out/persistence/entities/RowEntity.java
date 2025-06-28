package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rows")
public class RowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Character letter;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatEntity> seats = new ArrayList<>();

    public RowEntity() {
    }

    public Long getId() {
        return id;
    }

    public RowEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Character getLetter() {
        return letter;
    }

    public RowEntity setLetter(Character letter) {
        this.letter = letter;
        return this;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public RowEntity setRoom(RoomEntity room) {
        this.room = room;
        return this;
    }

    public List<SeatEntity> getSeats() {
        return seats;
    }

    public RowEntity setSeats(List<SeatEntity> seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowEntity that = (RowEntity) o;
        return this.id != null && Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL)
    private List<SeatEntity> seats;

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
        if (o == null || getClass() != o.getClass()) return false;
        RowEntity rowEntity = (RowEntity) o;
        return Objects.equals(getId(), rowEntity.getId()) && Objects.equals(getLetter(), rowEntity.getLetter()) && Objects.equals(getRoom(), rowEntity.getRoom()) && Objects.equals(getSeats(), rowEntity.getSeats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLetter(), getRoom(), getSeats());
    }
}

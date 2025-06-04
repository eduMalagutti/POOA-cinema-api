package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.RoomType;
import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private TheaterEntity theater;

    public RoomEntity() {
    }

    public Long getId() {
        return id;
    }

    public RoomEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoomEntity setName(String name) {
        this.name = name;
        return this;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomEntity setRoomType(RoomType roomType) {
        this.roomType = roomType;
        return this;
    }

    public TheaterEntity getTheater() {
        return theater;
    }

    public RoomEntity setTheater(TheaterEntity theater) {
        this.theater = theater;
        return this;
    }
}

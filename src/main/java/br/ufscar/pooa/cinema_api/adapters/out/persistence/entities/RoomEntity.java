package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.RoomType;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private TheaterEntity theater;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RowEntity> rows;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<SessionEntity> sessions;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return this.id != null && Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

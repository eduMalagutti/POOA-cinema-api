package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.SeatType;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seats")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Character number;

    @Column
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "row_id", nullable = false)
    private RowEntity row;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;

    public SeatEntity() {
    }

    public Long getId() {
        return id;
    }

    public SeatEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public RowEntity getRow() {
        return row;
    }

    public void setRow(RowEntity row) {
        this.row = row;
    }

    public Character getNumber() {
        return number;
    }

    public SeatEntity setNumber(Character number) {
        this.number = number;
        return this;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public SeatEntity setSeatType(SeatType seatType) {
        this.seatType = seatType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatEntity that = (SeatEntity) o;
        return this.id != null && Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

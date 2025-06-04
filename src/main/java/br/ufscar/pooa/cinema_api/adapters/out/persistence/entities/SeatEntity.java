package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.SeatType;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class SeatEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Character number;

    @Column
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

//    @ManyToOne
//    @JoinColumn(name = "row_id", nullable = false)
//    private RowEntity row;

//    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Ticket> tickets;

    public SeatEntity() {
    }

    public Long getId() {
        return id;
    }

    public SeatEntity setId(Long id) {
        this.id = id;
        return this;
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
}

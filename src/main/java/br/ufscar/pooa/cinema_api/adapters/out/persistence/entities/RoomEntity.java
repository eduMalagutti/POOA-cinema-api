package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.RoomType;
import br.ufscar.pooa.cinema_api.domain.model.Theater;
import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {
//     private String name;
//    private RoomType roomType;
//    private Theater theater;
//    private List<Row> rows;
//    private List<Session> sessions;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type",  nullable = false)
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private TheaterEntity theater;
}

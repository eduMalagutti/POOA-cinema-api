package br.ufscar.pooa.cinema_api.application.dtos.room;

import br.ufscar.pooa.cinema_api.application.dtos.row.RowDTO;

import java.util.List;

public class RoomResponseDTO {
    private Long id;
    private String name;
    private String roomType;
    private List<RowDTO> rows;
    private Long theaterId;

    public RoomResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public List<RowDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowDTO> rows) {
        this.rows = rows;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }
}

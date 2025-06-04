package br.ufscar.pooa.cinema_api.domain.model;

import br.ufscar.pooa.cinema_api.domain.enums.RoomType;

import java.util.List;
import java.util.Objects;

public class Room {
    private String name;
    private RoomType roomType;
    private Theater theater;
    private List<Row> rows;
    private List<Session> sessions;

    public Room(List<Session> sessions, List<Row> rows, RoomType roomType, Theater theater, String name) {
        this.sessions = sessions;
        this.rows = rows;
        this.roomType = roomType;
        this.theater = theater;
        this.name = name;
    }

    public Session[] getSessions() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) && Objects.equals(theater, room.theater) && roomType == room.roomType && Objects.equals(rows, room.rows) && Objects.equals(sessions, room.sessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, theater, roomType, rows, sessions);
    }
}
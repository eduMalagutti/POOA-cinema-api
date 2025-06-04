package br.ufscar.pooa.cinema_api.domain.model;

import java.util.List;
import java.util.Objects;

public class Row {
	private Character letter;
	private Room room;
	private List<Seat> seats;

	public Row(Character letter, Room room, List<Seat> seats) {
		this.letter = letter;
		this.room = room;
		this.seats = seats;
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Row row = (Row) o;
		return Objects.equals(letter, row.letter) && Objects.equals(room, row.room) && Objects.equals(seats, row.seats);
	}

	@Override
	public int hashCode() {
		return Objects.hash(letter, room, seats);
	}
}
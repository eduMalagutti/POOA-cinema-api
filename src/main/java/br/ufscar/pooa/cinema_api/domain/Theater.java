package br.ufscar.pooa.cinema_api.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Theater {
    private Long id;
    private String name;
    private String logoUrl;
    private Address address;
    private List<Room> rooms;
    private List<User> managers = new ArrayList<>();
    private List<Movie> movies;

    public Theater() {}

    public Theater(String name, String logoUrl, List<Room> rooms, Address address, List<User> managers, List<Movie> movies) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.rooms = rooms;
        this.address = address;
        this.managers = managers;
        this.movies = movies;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<User> getManagers() {
        return managers;
    }

    public void setManagers(List<User> managers) {
        this.managers = managers;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theater theater = (Theater) o;
        return Objects.equals(getId(), theater.getId()) && Objects.equals(getName(), theater.getName()) && Objects.equals(getLogoUrl(), theater.getLogoUrl()) && Objects.equals(getAddress(), theater.getAddress()) && Objects.equals(getRooms(), theater.getRooms()) && Objects.equals(getManagers(), theater.getManagers()) && Objects.equals(getMovies(), theater.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLogoUrl(), getAddress(), getRooms(), getManagers(), getMovies());
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", address=" + address +
                ", rooms=" + rooms +
                ", managers=" + managers +
                ", movies=" + movies +
                '}';
    }
}
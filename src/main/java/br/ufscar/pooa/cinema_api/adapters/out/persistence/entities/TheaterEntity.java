package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "theaters")
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String logoUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique = true)
    private AddressEntity address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private Set<RoomEntity> rooms;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private Set<UserEntity> managers;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private Set<MovieEntity> movies;

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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Set<RoomEntity> getRooms() {
        return rooms;
    }

    public TheaterEntity setRooms(Set<RoomEntity> rooms) {
        this.rooms = rooms;
        return this;
    }

    public Set<UserEntity> getManagers() {
        return managers;
    }

    public TheaterEntity setManagers(Set<UserEntity> managers) {
        this.managers = managers;
        return this;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public TheaterEntity setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TheaterEntity that = (TheaterEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getLogoUrl(), that.getLogoUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLogoUrl());
    }
}

package br.ufscar.pooa.cinema_api.application.dtos.theater;

import java.util.List;

public class TheaterResponseDTO {

    private Long id;
    private String name;
    private String logoUrl;
    private AddressDTO address;
    private List<Long> roomIds;
    private List<Long> managerIds;
    private List<Long> movieIds;

    public TheaterResponseDTO() {
    }

    public TheaterResponseDTO(Long id, String name, String logoUrl, AddressDTO address, List<Long> roomIds, List<Long> managerIds, List<Long> movieIds) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
        this.address = address;
        this.roomIds = roomIds;
        this.managerIds = managerIds;
        this.movieIds = movieIds;
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }

    public List<Long> getManagerIds() {
        return managerIds;
    }

    public void setManagerIds(List<Long> managerIds) {
        this.managerIds = managerIds;
    }

    public List<Long> getMovieIds() {
        return movieIds;
    }

    public void setMovieIds(List<Long> movieIds) {
        this.movieIds = movieIds;
    }
}

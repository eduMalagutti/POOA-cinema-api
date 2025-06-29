package br.ufscar.pooa.cinema_api.domain;

import br.ufscar.pooa.cinema_api.domain.enums.AgeRating;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie {
    private Long id;
    private String title;
    private String synopsis;
    private String coverUrl;
    private String trailerUrl;
    private Integer durationInSeconds;
    private Theater theater;
    private List<Session> sessions = new ArrayList<>();
    private List<Genre> genres;
    private AgeRating ageRating;

    public Movie(AgeRating ageRating, List<Genre> genres, Theater theater, List<Session> sessions, Integer durationInSeconds, String trailerUrl, String coverUrl, String synopsis, String title) {
        this.ageRating = ageRating;
        this.genres = genres;
        this.theater = theater;
        this.sessions = sessions;
        this.durationInSeconds = durationInSeconds;
        this.trailerUrl = trailerUrl;
        this.coverUrl = coverUrl;
        this.synopsis = synopsis;
        this.title = title;
    }

    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getId(), movie.getId()) && Objects.equals(getTitle(), movie.getTitle()) && Objects.equals(getSynopsis(), movie.getSynopsis()) && Objects.equals(getCoverUrl(), movie.getCoverUrl()) && Objects.equals(getTrailerUrl(), movie.getTrailerUrl()) && Objects.equals(getDurationInSeconds(), movie.getDurationInSeconds()) && getAgeRating() == movie.getAgeRating();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSynopsis(), getCoverUrl(), getTrailerUrl(), getDurationInSeconds(), getAgeRating());
    }
}

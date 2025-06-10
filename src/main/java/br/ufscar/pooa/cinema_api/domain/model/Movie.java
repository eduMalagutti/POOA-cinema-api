package br.ufscar.pooa.cinema_api.domain.model;

import br.ufscar.pooa.cinema_api.domain.enums.AgeRating;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Movie {
    private Long id;
    private String title;
    private String synopsis;
    private String coverUrl;
    private String trailerUrl;
    private Integer durationInSeconds;
    private Theater theater;
    private List<Session> sessions;
    private Set<Genre> genres;
    private AgeRating ageRating;

    public Movie(AgeRating ageRating, Set<Genre> genres, Theater theater, List<Session> sessions, Integer durationInSeconds, String trailerUrl, String coverUrl, String synopsis, String title) {
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

    public Session[] getAvailableSessions() {
        return null;
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

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater cinema) {
        this.theater = cinema;
    }

    public Set<Genre> getMovieGenres() {
        return genres;
    }

    public void setMovieGenres(Set<Genre> genres) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(getTitle(), movie.getTitle()) && Objects.equals(getSynopsis(), movie.getSynopsis()) && Objects.equals(getCoverUrl(), movie.getCoverUrl()) && Objects.equals(getTrailerUrl(), movie.getTrailerUrl()) && Objects.equals(getDurationInSeconds(), movie.getDurationInSeconds()) && Objects.equals(getTheater(), movie.getTheater()) && Objects.equals(getSessions(), movie.getSessions()) && Objects.equals(getMovieGenres(), movie.getMovieGenres()) && getAgeRating() == movie.getAgeRating();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getTitle(), getSynopsis(), getCoverUrl(), getTrailerUrl(), getDurationInSeconds(), getTheater(), getSessions(), getMovieGenres(), getAgeRating());
    }
}

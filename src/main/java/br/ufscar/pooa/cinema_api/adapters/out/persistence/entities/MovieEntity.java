package br.ufscar.pooa.cinema_api.adapters.out.persistence.entities;

import br.ufscar.pooa.cinema_api.domain.enums.AgeRating;
import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String synopsis;

    @Column
    private String coverUrl;

    @Column
    private String trailerUrl;

    @Column
    private Integer durationInSeconds;

    @Column
    private AgeRating ageRating;

    @ManyToOne
    private TheaterEntity theater;

//    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<SessionEntity> sessions;

//    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<MovieGenreEntity> movieGenres;

    public MovieEntity() {
    }

    public Long getId() {
        return id;
    }

    public MovieEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public MovieEntity setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public MovieEntity setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
        return this;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public MovieEntity setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
        return this;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public MovieEntity setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
        return this;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public MovieEntity setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
        return this;
    }

    public TheaterEntity getTheater() {
        return theater;
    }

    public MovieEntity setTheater(TheaterEntity theater) {
        this.theater = theater;
        return this;
    }
}

package com.movies.bookmyshow.movies.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Column(name = "movie_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(name = "movie_name")
    private String movieName;

    @OneToMany
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private List<ShowEntity> shows;

    public List<ShowEntity> getShows() {
        return shows;
    }

    public void setShows(List<ShowEntity> shows) {
        this.shows = shows;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}

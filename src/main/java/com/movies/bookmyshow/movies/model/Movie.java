package com.movies.bookmyshow.movies.model;

import java.util.List;

public class Movie {
    private String movieName;
    private Integer movieId;

    private List<Show> shows;



    public Movie() {

    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Movie(String movieName, Integer movieId) {
        this.movieName = movieName;
        this.movieId = movieId;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}

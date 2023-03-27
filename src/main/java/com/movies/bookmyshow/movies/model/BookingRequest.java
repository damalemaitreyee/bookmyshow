package com.movies.bookmyshow.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookingRequest {
    private Integer movieId;
    private Integer showId;
    private Integer userId;
    @JsonProperty("seatIds")
    private List<Integer> seats;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

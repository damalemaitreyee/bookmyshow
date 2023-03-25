package com.movies.bookmyshow.movies.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "show")
public class ShowEntity {

    @Column(name = "show_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "screen_id")
    private Integer screenId;

    @Column(name = "start_time")
    private String showStartTiming;

    @Column(name = "end_time")
    private String showEndTiming;

    @OneToMany
    @JoinColumn(name = "show_id", referencedColumnName = "show_id")
    List<SeatReservedEntity> seatsReserved;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getShowStartTiming() {
        return showStartTiming;
    }

    public void setShowStartTiming(String showStartTiming) {
        this.showStartTiming = showStartTiming;
    }

    @Override
    public String toString() {
        return "ShowEntity{" +
                "showId=" + showId +
                ", movieId=" + movieId +
                ", screenId=" + screenId +
                ", showStartTiming='" + showStartTiming + '\'' +
                ", showEndTiming='" + showEndTiming + '\'' +
                ", seatsReserved=" + seatsReserved +
                '}';
    }

    public String getShowEndTiming() {
        return showEndTiming;
    }

    public void setShowEndTiming(String showEndTiming) {
        this.showEndTiming = showEndTiming;
    }

    public List<SeatReservedEntity> getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(List<SeatReservedEntity> seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}

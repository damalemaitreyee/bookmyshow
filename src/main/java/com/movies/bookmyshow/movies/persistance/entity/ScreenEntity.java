package com.movies.bookmyshow.movies.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "screen")
public class ScreenEntity {
    @Column(name = "screen_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;

    @OneToMany
    @JoinColumn(name = "screen_id", referencedColumnName = "screen_id")
    private List<SeatEntity> seats;

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public List<SeatEntity> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatEntity> seats) {
        this.seats = seats;
    }
}

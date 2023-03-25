package com.movies.bookmyshow.movies.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seat")
public class SeatEntity {
    @Column(name = "seat_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @Column(name = "screen_id")
    private Integer screenId;

    @OneToMany
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    List<SeatReservedEntity> seatsReserved;

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public List<SeatReservedEntity> getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(List<SeatReservedEntity> seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}

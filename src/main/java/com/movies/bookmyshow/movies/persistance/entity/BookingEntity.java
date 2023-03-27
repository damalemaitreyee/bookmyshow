package com.movies.bookmyshow.movies.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "booking")
public class BookingEntity {

    @Column(name = "booking_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;

    @Column(name = "show_id")
    private Integer showId;

    @Column(name = "user_id")
    private Integer userId;

    @OneToMany
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    List<SeatReservedEntity> seatsReserved;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<SeatReservedEntity> getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(List<SeatReservedEntity> seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}

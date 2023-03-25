package com.movies.bookmyshow.movies.persistance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_reserved")
public class SeatReservedEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seat_id")
    private Integer seatId;

    @Column(name = "booking_id")
    private Integer bookingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "SeatReservedEntity{" +
                "id=" + id +
                ", seatId=" + seatId +
                ", bookingId=" + bookingId +
                '}';
    }
}

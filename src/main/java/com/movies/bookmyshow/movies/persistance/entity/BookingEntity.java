package com.movies.bookmyshow.movies.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "booking")
public class BookingEntity {

    @Column(name = "booking_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column(name = "show_id")
    private Integer showId;

    @Column(name = "user_id")
    private Integer userId;

    @OneToMany
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    List<SeatReservedEntity> seatsReserved;

}

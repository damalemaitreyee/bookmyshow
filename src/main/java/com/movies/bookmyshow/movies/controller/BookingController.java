package com.movies.bookmyshow.movies.controller;

import com.movies.bookmyshow.movies.model.BookingRequest;
import com.movies.bookmyshow.movies.model.BookingResponse;
import com.movies.bookmyshow.movies.persistance.entity.BookingEntity;
import com.movies.bookmyshow.movies.persistance.entity.SeatReservedEntity;
import com.movies.bookmyshow.movies.persistance.repo.BookingRepository;
import com.movies.bookmyshow.movies.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {



    @Autowired
    private BookingService bookingService;

    @PostMapping("book")
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest) {
        BookingResponse bookingResponse = new BookingResponse();
        BookingEntity entity = bookingService.createBooking(bookingRequest);
        bookingResponse.setSuccess(entity.getBookingId() == null ? false : true );
        return bookingResponse;
    }
}


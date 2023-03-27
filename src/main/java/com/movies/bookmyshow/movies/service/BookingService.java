package com.movies.bookmyshow.movies.service;

import com.movies.bookmyshow.movies.model.BookingRequest;
import com.movies.bookmyshow.movies.persistance.entity.BookingEntity;
import com.movies.bookmyshow.movies.persistance.entity.SeatReservedEntity;
import com.movies.bookmyshow.movies.persistance.repo.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public BookingEntity createBooking(BookingRequest bookingRequest){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setUserId(bookingRequest.getUserId());
        bookingEntity.setShowId(bookingRequest.getShowId());
        List<Integer> seats = bookingRequest.getSeats();
        List<SeatReservedEntity> seatReserved = new ArrayList<>();

        for (Integer seat:seats){
            SeatReservedEntity seatReservedEntity = new SeatReservedEntity();
            seatReservedEntity.setSeatId(seat);
            seatReserved.add(seatReservedEntity);

        }
        bookingEntity.setSeatsReserved(seatReserved);
        return save(bookingEntity);
    }

    @Transactional
    private BookingEntity save(BookingEntity bookingEntity){
        return bookingRepository.saveAndFlush(bookingEntity);
    }
}

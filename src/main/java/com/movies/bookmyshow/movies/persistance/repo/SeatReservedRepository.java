package com.movies.bookmyshow.movies.persistance.repo;

import com.movies.bookmyshow.movies.persistance.entity.BookingEntity;
import com.movies.bookmyshow.movies.persistance.entity.SeatReservedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatReservedRepository extends JpaRepository<SeatReservedEntity,Integer> {

}

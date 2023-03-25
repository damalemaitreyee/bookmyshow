package com.movies.bookmyshow.movies.controller;

import com.movies.bookmyshow.movies.model.Movie;
import com.movies.bookmyshow.movies.model.Show;
import com.movies.bookmyshow.movies.persistance.entity.*;
import com.movies.bookmyshow.movies.persistance.repo.MovieRepository;
import com.movies.bookmyshow.movies.persistance.repo.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable String movieId){
        MovieEntity movieEntity =
                movieRepository.findByMovieId(Integer.valueOf(movieId));
        return convertEntityToModel(movieEntity);

    }

    @GetMapping("/movies")
    public Movie getMovieByName(@RequestParam String movieName){
        MovieEntity movieEntity= movieRepository.findByMovieName(movieName);
        return convertEntityToModel(movieEntity);
    }

    private Movie convertEntityToModel(MovieEntity movieEntity) {
        Movie movie = new Movie();
        movie.setMovieId(movieEntity.getMovieId());
        movie.setMovieName(movieEntity.getMovieName());

        List<ShowEntity> shows = movieEntity.getShows();
        List<Show> showList = new ArrayList<>();

        for (ShowEntity showEntity: shows) {
            List<Integer> seatsInScreen = getSeatsInScreen(showEntity.getScreenId());
            List<Integer> seatsBookedInScreen = getBookedSeats(showEntity.getSeatsReserved());
            List<Integer> differences = new ArrayList<>(seatsInScreen);
            differences.removeAll(seatsBookedInScreen);
            Show s = new Show();
            s.setShowId(showEntity.getShowId());
            s.setScreenId(showEntity.getScreenId());
            s.setStart(showEntity.getShowStartTiming());
            s.setEnd(showEntity.getShowEndTiming());
            s.setBookedSeatIds(seatsBookedInScreen);
            s.setAvailableSeatIds(differences);
            showList.add(s);
        }
        movie.setShows(showList);

        return movie;
    }

    private  List<Integer> getSeatsInScreen(Integer screenId) {
        ScreenEntity screenEntity = screenRepository.findByScreenId(screenId);
        List<SeatEntity> seats = screenEntity.getSeats();
        List<Integer> allSeats = new ArrayList<>();
        for(SeatEntity seat : seats){
            allSeats.add(seat.getSeatId());
        }
        return allSeats;
    }

    private  List<Integer> getBookedSeats(List<SeatReservedEntity> seatsReserved){
        List<Integer> seats = new ArrayList<>();
        for(SeatReservedEntity e: seatsReserved){
            seats.add(e.getSeatId());
        }
        return seats;
    }
}

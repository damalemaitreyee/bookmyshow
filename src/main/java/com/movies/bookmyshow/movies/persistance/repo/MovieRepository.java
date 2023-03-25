package com.movies.bookmyshow.movies.persistance.repo;

import com.movies.bookmyshow.movies.persistance.entity.MovieEntity;
import com.movies.bookmyshow.users.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    @Query("select m from MovieEntity m where m.movieId = :movieId")
    MovieEntity findByMovieId(Integer movieId);
    @Query("select m from MovieEntity m where m.movieName = :movieName")
    MovieEntity findByMovieName(String movieName);
}

package com.movies.bookmyshow.movies.persistance.repo;

import com.movies.bookmyshow.movies.persistance.entity.MovieEntity;
import com.movies.bookmyshow.movies.persistance.entity.ScreenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity,Integer> {

    @Query("select m from ScreenEntity m where m.screenId = :screenId")
    ScreenEntity findByScreenId(Integer screenId);
}

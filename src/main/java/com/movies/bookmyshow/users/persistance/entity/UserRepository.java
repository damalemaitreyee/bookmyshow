package com.movies.bookmyshow.users.persistance.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
     @Query("select u from UserEntity u where u.userId = :userId")
     UserEntity findByUserId(Integer userId);

     @Query("select u from UserEntity u where u.userName = :username")
     UserEntity findByUserName(String username);

     @Query("select u from UserEntity u where u.userName = :username and u.password =:password")
     UserEntity findUser(String username, String password);
}

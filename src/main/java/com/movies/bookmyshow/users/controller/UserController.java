package com.movies.bookmyshow.users.controller;

import com.movies.bookmyshow.users.model.User;
import com.movies.bookmyshow.users.persistance.entity.UserEntity;
import com.movies.bookmyshow.users.persistance.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable String userId) {
       UserEntity userEntity =
               userRepository.findByUserId(Integer.valueOf(userId));
        return convertEntityToModel(userEntity);
    }

    @GetMapping("/users")
    public User getUserByName(@RequestParam String name) {
        UserEntity userEntity =
                userRepository.findByUserName(name);
        return convertEntityToModel(userEntity);
    }

    @GetMapping("/users/authenticate")
    public User authenticateUser(@RequestParam String userName, @RequestParam String password){
        UserEntity userEntity =
                userRepository.findUser(userName,password);
        return userEntity == null
                ? null : convertEntityToModel(userEntity);
    }

    private static User convertEntityToModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getUserId());
        user.setUsername(userEntity.getUserName());
        return user;
    }
}

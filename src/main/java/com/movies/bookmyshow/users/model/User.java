package com.movies.bookmyshow.users.model;

public class User {
    private String username;
    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String username, Integer id) {
        this.username = username;
        this.id = id;
    }

    public User(){

    }

}

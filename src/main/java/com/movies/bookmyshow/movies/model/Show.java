package com.movies.bookmyshow.movies.model;

import java.util.List;

public class Show {
    private Integer showId;
    private String start;
    private String end;
    private Integer screenId;

    private List<Integer> bookedSeatIds;

    private List<Integer> availableSeatIds;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public List<Integer> getAvailableSeatIds() {
        return availableSeatIds;
    }

    public void setAvailableSeatIds(List<Integer> availableSeatIds) {
        this.availableSeatIds = availableSeatIds;
    }
}

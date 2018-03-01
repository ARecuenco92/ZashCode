package com.google.zashcode.model;

import java.util.List;

public class Car {

    private Integer id;

    private Integer currentX;

    private Integer currentY;

    private List<Integer> rides;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentX() {
        return currentX;
    }

    public void setCurrentX(Integer currentX) {
        this.currentX = currentX;
    }

    public Integer getCurrentY() {
        return currentY;
    }

    public void setCurrentY(Integer currentY) {
        this.currentY = currentY;
    }

    public List<Integer> getRides() {
        return rides;
    }

    public void setRides(List<Integer> rides) {
        this.rides = rides;
    }
}

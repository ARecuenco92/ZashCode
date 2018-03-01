package com.google.zashcode.model;

import java.util.List;

public class Car {

    private Integer id;

    private Integer currentX;

    private Integer currentY;

    private List<Ride> rides;

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

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    @Override
    public String toString() {
        String line = rides.size()+"";
        for(Ride ride: rides){
            line += " "+ride.getId();
        }
        return line;
    }

}

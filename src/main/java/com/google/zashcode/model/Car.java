package com.google.zashcode.model;

import com.google.zashcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private Integer id;

    private Integer currentX;

    private Integer currentY;

    private List<Ride> rides;

    public Car() {
        currentX = 0;
        currentY = 0;
        rides = new ArrayList<Ride>();
    }

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

    public Integer getSteps(){
        int distance = 0;
        int startX = 0;
        int startY = 0;
        for(Ride ride : rides){
            distance += Utils.getDistance(0, 0, ride.getStartX(), ride.getStartY());
            distance += ride.getScore();
            startX = ride.getEndX();
            startY = ride.getEndY();
        }
        return distance;
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

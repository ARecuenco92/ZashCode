package com.google.zashcode.model;

import com.google.zashcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private Integer id;

    private List<Ride> rides;

    public Car() {
        rides = new ArrayList<Ride>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentX() {
        if(rides.size() > 0) {
            return rides.get(rides.size()-1).getEndX();
        }
        return 0;
    }

    public Integer getCurrentY() {
        if(rides.size() > 0) {
            return rides.get(rides.size()-1).getEndY();
        }
        return 0;
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
            distance += Utils.getDistance(startX, startY, ride.getStartX(), ride.getStartY());
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

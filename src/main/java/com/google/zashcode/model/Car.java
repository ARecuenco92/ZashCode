package com.google.zashcode.model;

import com.google.zashcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private Integer id;

    private List<Ride> rides;

    private Integer steps;

    public Car() {
        rides = new ArrayList<Ride>();
        steps = 0;
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

    public void addRide(Ride ride) {
        Integer distance = Utils.getDistance(getCurrentX(), getCurrentY(), ride.getStartX(), ride.getStartY());

        distance = Math.max(distance, ride.getStartTime() - steps);

        steps = distance + ride.getScore();

        rides.add(ride);
    }

    public Integer getSteps(){
        return steps;
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

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
<<<<<<< HEAD
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
=======
        return steps;
>>>>>>> 62150cf4e6f5e34d6c8290023fe6a2e7024aa28f
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

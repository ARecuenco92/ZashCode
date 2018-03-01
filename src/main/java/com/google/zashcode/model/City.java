package com.google.zashcode.model;

import com.google.zashcode.Utils;

import java.util.Collections;
import java.util.List;
import static java.util.Comparator.comparing;

public class City {

    private Integer columns;

    private Integer rows;

    private List<Car> cars;

    private List<Ride> rides;

    private Integer bonus;

    private Integer steps;

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    /**
     * Assign rides 1 to 1
     * @return
     */
    public List<Car> drive() {
        List<Ride> carRides;
        for(int i = 0; i < cars.size(); i++) {
            carRides = cars.get(i).getRides();
            carRides.add(rides.get(i));
            rides.remove(0);
        }

        for(int i = 0; i < cars.size(); i++) {
            carRides = cars.get(i).getRides();
            //for(int r = 0; r < rides.size(); r++) {
                if (cars.size()+i < rides.size() && Utils.couldTakeRide(cars.get(i), rides.get(cars.size()+i))) {
                    carRides.add(rides.get(cars.size()+i));

                }
            //}
        }

        return cars;
    }

    /**
     * Assign rides if possible
     * @return
     */
    public List<Car> drive2() {
        List<Ride> carRides;
        for(Car car: cars){
            Integer timeLeft = steps - car.getSteps();
            if(timeLeft > 0){
                for(Ride ride: rides){

                    int distanceToStart = Utils.getDistance(car.getCurrentX(), car.getCurrentY(), ride.getStartX(), ride.getStartY());
                    int rideDistance = ride.getScore();

                    if(distanceToStart + rideDistance < timeLeft){
                        car.getRides().add(ride);
                        rides.remove(ride);
                    }
                }
            }
        }

        return cars;
    }


    public List<Car> crazyDrive() {
        List<Ride> carRides;
        Collections.sort(rides, comparing(Ride::getStartTime));
        Collections.sort(cars, comparing(Car::getCurrentX));
        for(int i = 0; i < cars.size(); i++) {
            carRides = cars.get(i).getRides();
            carRides.add(rides.get(i));
        }

        return cars;
    }

}

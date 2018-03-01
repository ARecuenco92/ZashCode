package com.google.zashcode.model;

import com.google.zashcode.Utils;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Car> drive2() {
        List<Ride> carRides;
        for(int i = 0; i < cars.size(); i++) {
            carRides = cars.get(i).getRides();
            carRides.add(rides.get(i));
        }

        return cars;
    }

    /**
     * Assign rides if possible
     * @return
     */
    public List<Car> drive3() {
        List<Ride> carRides;
        for(Car car: cars){
            Integer timeLeft = steps - car.getSteps();
            if(timeLeft > 0){
                List<Ride> pendingRides = rides.stream().filter(r -> r.isDone() == false).collect(Collectors.<Ride>toList());
                Ride nextRide = pendingRides.get(0);
                int distanceToStart = Utils.getDistance(car.getCurrentX(), car.getCurrentY(), nextRide.getStartX(), nextRide.getStartY());
                int rideDistance = nextRide.getScore();

                if(distanceToStart + rideDistance < timeLeft){
                    car.getRides().add(nextRide);
                    nextRide.setDone(true);
                }
            }
        }

        return cars;
    }

    /**
     * Assign rides if possible
     * @return
     */
    public List<Car> drive4() {
        List<Ride> carRides;
        for(Ride nextRide: rides){
            for (Car car : cars) {
                Integer timeLeft = steps - car.getSteps();
                if (timeLeft > 0) {
                    int distanceToStart = Utils.getDistance(car.getCurrentX(), car.getCurrentY(), nextRide.getStartX(), nextRide.getStartY());
                    int rideDistance = nextRide.getScore();

                    if (distanceToStart + rideDistance < timeLeft) {
                        car.getRides().add(nextRide);
                        break;
                    }
                }
            }
        }

        return cars;
    }

}

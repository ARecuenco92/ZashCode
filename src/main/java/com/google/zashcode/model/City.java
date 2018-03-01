package com.google.zashcode.model;

import java.util.List;

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


    public List<Car> drive() {
        List<Ride> rides;
        for(int i = 0; i < cars.size(); i++) {
            rides = cars.get(i).getRides();
            rides.add(rides.get(i));
        }

        return cars;
    }

}

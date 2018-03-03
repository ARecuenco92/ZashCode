package com.google.zashcode.model;

import com.google.zashcode.Utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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

}

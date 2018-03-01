package com.google.zashcode.drive;

import com.google.zashcode.model.Car;
import com.google.zashcode.model.City;

import java.util.List;

public abstract class AbstractDrive {

    protected City city;

    public AbstractDrive(City city){
        this.city = city;
    }


    public abstract List<Car> drive();

    public City getCity(){
        return city;
    }
}

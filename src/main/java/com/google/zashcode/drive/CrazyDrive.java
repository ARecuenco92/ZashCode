package com.google.zashcode.drive;

import com.google.zashcode.drive.AbstractDrive;
import com.google.zashcode.model.Car;
import com.google.zashcode.model.City;
import com.google.zashcode.model.Ride;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class CrazyDrive extends AbstractDrive {


    public CrazyDrive(City city) {
        super(city);
    }

    @Override
    public List<Car> drive() {
        List<Ride> carRides;
        Collections.sort(city.getRides(), comparing(Ride::getStartTime));
        Collections.sort(city.getCars(), comparing(Car::getCurrentX));
        for(int i = 0; i < city.getCars().size(); i++) {
            carRides = city.getCars().get(i).getRides();
            carRides.add(city.getRides().get(i));
        }

        return city.getCars();
    }
}

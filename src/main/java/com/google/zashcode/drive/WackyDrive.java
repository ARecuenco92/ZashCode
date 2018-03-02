package com.google.zashcode.drive;

import com.google.zashcode.Utils;
import com.google.zashcode.drive.AbstractDrive;
import com.google.zashcode.model.Car;
import com.google.zashcode.model.City;
import com.google.zashcode.model.Ride;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class WackyDrive extends AbstractDrive {


    public WackyDrive(City city) {
        super(city);
    }

    @Override
    public List<Car> drive() {
        List<Ride> carRides;

        for(int s = 0; s < city.getRides().size(); s++){
            for (Car car : city.getCars()) {

                Collections.sort(city.getRides(), comparing(r -> {
                    return Utils.getDistance(car.getCurrentX(), car.getCurrentY(), r.getStartX(), r.getStartY())*3 + (Math.abs(r.getStartTime() - car.getSteps()));
                }));

                for(int i = 0; i < city.getRides().size(); i++){
                    if(Utils.couldTakeRide(car, city.getRides().get(i))){
                        car.addRide(city.getRides().get(i));
                        city.getRides().remove(i);
                        break;
                    }
                }

            }
        }

        return city.getCars();
    }
}

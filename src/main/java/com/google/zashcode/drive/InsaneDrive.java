package com.google.zashcode.drive;

import com.google.zashcode.Utils;
import com.google.zashcode.drive.AbstractDrive;
import com.google.zashcode.model.Car;
import com.google.zashcode.model.City;
import com.google.zashcode.model.Ride;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class InsaneDrive extends AbstractDrive {


    public InsaneDrive(City city) {
        super(city);
    }

    public List<Car> drive() {
        List<Ride> carRides;

        for(int s = 0; s < city.getRides().size(); s++){
            for (Car car : city.getCars()) {

                Collections.sort(city.getRides(), comparing(ride -> {
                    return getScore(car, ride, city.getBonus());
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

    private Integer getScore(Car car, Ride ride, Integer bonus){
        Integer distance = Utils.getDistance(car.getCurrentX(), car.getCurrentY(), ride.getStartX(), ride.getStartY());
        Integer multiplier = 3;
        Integer absStartDistance = Math.abs(ride.getStartTime() - car.getSteps());
        Integer bonusScore = Utils.couldTakeBonus(car, ride) ? bonus : 0;

        return distance * multiplier + absStartDistance - bonusScore;
    }
}

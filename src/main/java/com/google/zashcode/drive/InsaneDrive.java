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

    public List<Car> drive4() {
        List<Ride> carRides;
        Collections.sort(city.getRides(), comparing(r -> r.getScore()));
        int i = 0;
        //Collections.sort(city.getRides(), comparing(r -> r.getEndTime() * -1));
        for(Ride nextRide: city.getRides()){
            Collections.sort(city.getCars(), comparing(c -> nextRide.getScore() + Utils.getDistance(c.getCurrentX(), c.getCurrentY(), nextRide.getStartX(), nextRide.getStartY())));
            for (Car car : city.getCars()) {
                if(Utils.couldTakeRide(car, nextRide)){
                    car.getRides().add(nextRide);
                    break;
                }
            }
            /*i++;
            if(i%100 == 0){
                Collections.sort(city.getRides(), comparing(r -> r.getEndTime()));
            }*/
        }

        return city.getCars();
    }

    public List<Car> drive44() {
        List<Ride> carRides;
        int i = 0;
        Collections.sort(city.getRides(), comparing(r -> r.getScore()));
        for(Ride nextRide: city.getRides()){
            Collections.sort(city.getCars(), comparing(c -> Utils.getDistance(c.getCurrentX(), c.getCurrentY(), nextRide.getStartX(), nextRide.getStartY())));
            for (Car car : city.getCars()) {
                if(Utils.couldTakeRide(car, nextRide) && Utils.couldTakeBonus(car, nextRide)){
                    car.getRides().add(nextRide);
                    nextRide.setDone(true);
                    break;
                }
            }
        }

        Collections.sort(city.getRides(), comparing(r -> r.getScore()));
        //Collections.sort(city.getRides(), comparing(r -> r.getEndTime() * -1));
        for(Ride nextRide: city.getRides()){
            if(!nextRide.isDone())
            {
                Collections.sort(city.getCars(), comparing(c -> Utils.getDistance(c.getCurrentX(), c.getCurrentY(), nextRide.getStartX(), nextRide.getStartY())));
                for (Car car : city.getCars()) {
                    if(Utils.couldTakeRide(car, nextRide)){
                        car.getRides().add(nextRide);
                        break;
                    }
                }
            }
        }

        return city.getCars();
    }


    public List<Car> drive() {

        Collections.sort(city.getRides(), comparing(r -> r.getScore() - r.getStartTime() + r.getStartTime()));
        for(int i = 0; i < city.getSteps(); i++){

            for (Car car : city.getCars()) {
                if(car.getSteps() <= i){
                    if(i % 1000 == 0){
                        Collections.sort(city.getRides(), comparing(r -> {
                            return Utils.getDistance(car.getCurrentX(), car.getCurrentY(), r.getStartX(), r.getStartY())
                                    + r.getEndTime() - r.getStartTime() + r.getStartTime()
                                    - r.getScore();
                        }));
                    }

                    for(Ride nextRide : city.getRides()){
                        if(!nextRide.isDone() && Utils.couldTakeRide(car, nextRide)){
                            car.getRides().add(nextRide);
                            nextRide.setDone(true);
                            break;
                        }
                    }
                }
            }
        }

        return city.getCars();
    }
}

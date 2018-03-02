package com.google.zashcode;

import com.google.zashcode.model.Car;
import com.google.zashcode.model.Ride;

import java.util.List;

public class Utils {

    public static Integer getDistance(Integer startX, Integer startY, Integer endX, Integer endY){
        Integer score = Math.abs(endX - startX);
        score += Math.abs(endY - startY);

        return score;
    }

    public static boolean couldTakeRide(Car car, Ride ride) {
        Integer distance = Utils.getDistance(car.getCurrentX(), car.getCurrentY(), ride.getStartX(), ride.getStartY());

        distance = Math.max(distance, ride.getStartTime() - car.getSteps());

        Integer trip = ride.getScore();

        return (car.getSteps() + distance + trip) < ride.getEndTime();
    }

    public static void printScore(List<Car> cars, int bonus) {
        Integer score = 0;
        for(Car car : cars) {
            for(Ride ride : car.getRides()) {
                score += bonus;
                score +=  ride.getScore();
            }
        }

        System.out.println("Score: "+score);
    }
}

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

        Integer startStep = Math.max(distance + car.getSteps(), ride.getStartTime());
        
        Integer trip = ride.getScore();
        
        return (startStep + trip) < ride.getEndTime();
    }

    public static boolean couldTakeBonus(Car car, Ride ride) {
        Integer distance = Utils.getDistance(car.getCurrentX(), car.getCurrentY(), ride.getStartX(), ride.getStartY());

        return (distance + car.getSteps()) <= ride.getStartTime();
    }

    public static void printScore(List<Car> cars, int bonus) {
        Integer score = 0;
        for(Car car : cars) {
            Integer carSteps = 0;
            Integer startX = 0, startY = 0;
            for(Ride ride : car.getRides()) {

                // Get distance to rideStart
                Integer distance = Utils.getDistance(startX, startY, ride.getStartX(), ride.getStartY());

                // Bonus if start < distance + currentSteps
                if(ride.getStartTime() >= distance + carSteps)
                {
                    score += bonus;
                }

                score += ride.getScore();

                // Calculate current car step
                distance = Math.max(distance, ride.getStartTime() - carSteps);
                carSteps += distance + ride.getScore();
                startX = ride.getEndX();
                startY = ride.getEndY();
            }
        }

        System.out.println("Score: "+score);
    }
}

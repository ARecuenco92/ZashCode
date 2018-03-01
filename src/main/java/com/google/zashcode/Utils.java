package com.google.zashcode;

public class Utils {

    public static Integer getDistance(Integer startX, Integer startY, Integer endX, Integer endY){
        Integer score = Math.abs(endX - startX);
        score += Math.abs(endY - startY);

        return score;
    }
}

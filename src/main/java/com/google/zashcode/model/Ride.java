package com.google.zashcode.model;

public class Ride {

    private Integer id;

    private Integer startX;

    private Integer startY;

    private Integer endX;

    private Integer endY;

    private Integer startTime;

    private Integer endTime;

    private boolean done = false;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartX() {
        return startX;
    }

    public void setStartX(Integer startX) {
        this.startX = startX;
    }

    public Integer getStartY() {
        return startY;
    }

    public void setStartY(Integer startY) {
        this.startY = startY;
    }

    public Integer getEndX() {
        return endX;
    }

    public void setEndX(Integer endX) {
        this.endX = endX;
    }

    public Integer getEndY() {
        return endY;
    }

    public void setEndY(Integer endY) {
        this.endY = endY;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getScore() {
        Integer score = Math.abs(this.endX - this.startX);
        score += Math.abs(this.endY - this.startY);

        return score;
    }

    public Integer getMxTime() {
        return this.endTime - this.startTime;
    }
}

package com.bridgelabz;

public class Ride {
    private double distance;
    private int time;
    public RideCategories rideCategory;

    public Ride(RideCategories rideCategory, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.rideCategory = rideCategory;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public RideCategories getRideCategory() {
        return rideCategory;
    }

    public void setRideCategory(RideCategories rideCategory) {
        this.rideCategory = rideCategory;
    }
}

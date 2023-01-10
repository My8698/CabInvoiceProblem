package com.bridgelabz;
public class CabInvoiceGenerator {
    //Created variables
    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;
    public CabInvoiceGenerator() {

        this.rideRepository = new RideRepository();
    }
    private final RideRepository rideRepository;
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }
    /*
  Method to Calculate Fare for Multiple Rides
   */
    public double calculateFare(Ride ride) {
        return Math.max(ride.rideCategory.minFare,
                ride.getDistance() * ride.rideCategory.costPerKm + ride.getTime() * ride.rideCategory.costPerTime);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * create method to calculate total fare as per distance and time
     */

    /**
     * method created add Rides for Given a user id
     */
    public void addRides(String userId, Ride[] ride) {
        rideRepository.addRide(userId, ride);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}

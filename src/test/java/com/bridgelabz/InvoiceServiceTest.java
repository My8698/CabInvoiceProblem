package com.bridgelabz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceServiceTest {
    CabInvoiceGenerator invoiceGenerator;

    @Before
    public void init() {
        invoiceGenerator = new CabInvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;

        /**
         * Calculating the fair
         */
        double fare = invoiceGenerator.calculateFare(distance,time);
        assertEquals(25.0, fare,0.0);
    }
    /*
   Step 2 Test Case for minimum fare should give 5
   */
    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5.0, fare,0.0);
    }
    /*
   Step 3 Test Case For Mutiple rides
    */
    @Test
    public void givenMultipleRidesShouldReturnRideSummary() {
        Ride[] rides = { new Ride(RideCategories.NORMAL_RIDE, 2.0, 5), new Ride(RideCategories.NORMAL_RIDE, 0.1, 1) };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenUserIdShouldReturnTheInvoice() {
        String userId = "abc@123";
        Ride[] rides = { new Ride(RideCategories.NORMAL_RIDE, 2.0, 5),
                new Ride(RideCategories.NORMAL_RIDE, 0.1, 1) };
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
        assertEquals(summary, checkSummary);
    }

    @Test
    public void givenUserIdWithPremiumRideShouldReturnTheInvoice() {
        String userId = "dev@123";
        Ride[] rides = { new Ride(RideCategories.NORMAL_RIDE, 2.0, 5),
                new Ride(RideCategories.NORMAL_RIDE, 0.1, 1),
                new Ride(RideCategories.PREMIUM_RIDE, 0.1, 1) };
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary checkSummary = new InvoiceSummary(3, 50.0);
        assertEquals(summary, checkSummary);
    }
}
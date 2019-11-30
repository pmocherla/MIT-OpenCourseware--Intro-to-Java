/*
 * MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 2: FooCorporation
 * Calculates pay of FooCorp employees.
 * OOP
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

public class FooCorporation {

    public static void main(String[] arguments) {
        // init data
        double[] basePay = {1.0, 7.50, 8.20, 10.00};
        int[] hoursWorked = {50, 35, 47, 73};

        //Calculate total pay for each case
        int numEmployees = basePay.length;
        for (int i = 0; i < numEmployees; i++) {
            calculatePay(basePay[i], hoursWorked[i], i);
        }

    }

    public static void calculatePay(double basePay, int hoursWorked, int employee) {
        double totalPay = 0.0;

        //Check that hours is less than 60
        if (hoursWorked > 60) {
           System.out.println("More than 60 hours worked.");
           return;
        }

        //Check that paid more than minimum wage
        if (basePay < 8.00) {
            System.out.println("Paid less than minimum wage.");
            return;
        }

        //check amount of overtime pay
        if (hoursWorked > 40) {
            totalPay += basePay * 1.5 * (hoursWorked - 40);
        }

        //add base pay
        totalPay += basePay * 40;
        System.out.println("Employee " + employee + " total pay: " + totalPay);
    }
}
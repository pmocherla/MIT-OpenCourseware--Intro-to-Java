/*
 * MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 1: Gravity Calculator
 * Computes distance travelled by falling object dropped from a height
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

import java.util.Scanner;

public class GravityCalculator {
    public static void main(String[] arguments) {
        double gravity = -9.81; //earths gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;

        Scanner input = new Scanner(System.in);
        System.out.println("What is the falling time? ");
        fallingTime = input.nextDouble();
        finalPosition = 0.5 * gravity * fallingTime * fallingTime + initialVelocity * fallingTime + initialPosition;

        System.out.println("The object's position after " + fallingTime + " seconds is " + finalPosition + " m.");
    }

}
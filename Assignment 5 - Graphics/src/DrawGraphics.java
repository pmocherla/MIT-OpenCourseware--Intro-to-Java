/*
 * MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 5: Graphics
 * This file is a class that initializes this class for drawing multiple objects.
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class DrawGraphics {

    ArrayList<BouncingBall> boxList = new ArrayList<BouncingBall>();
    BouncingBall box;
    int numObjects = 5;
    Color colour;


    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Random rand = new Random();

        box = new BouncingBall(Color.BLACK);
        box.setRadius(0, 0);
        boxList.add(box);

        //Load the balls to be bounced and init a position and speed
        for (int j = 0; j < numObjects; j++) {
            colour = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            box = new BouncingBall(colour);
            box.setRadius(getRandInt(30, 290), getRandInt(30, 290));
            box.setTheta(getRandInt(0, 115));
            boxList.add(box);
        }

    }
    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        //Draw the balls
        for (int j = 0; j < numObjects; j++) {
            boxList.get(j).draw(surface);
        }
    }

    //generate a random number
    private static int getRandInt(double min, double max) {
        Random rand = new Random();
        double x = (rand.nextFloat() * ((max-min)+1)) + min;
        return (int) x;
    }
}
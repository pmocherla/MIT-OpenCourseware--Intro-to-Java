/*
 * MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 5: Graphics
 * This file is a class that initializes a new bouncing ball with its center located at (startX, startY), filled with startColor.
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;

public class BouncingBall {
    int x;
    int y;
    Color color;
    int xRadius;
    int yRadius;
    final int SIZE = 20;
    double theta = 0.0;

    /**
     * Initialize a new ball filled
     * with startColor.
     */
    public BouncingBall(Color startColor) {
        color = startColor;
    }
    /** Draws the ball at its current position on to surface. */
    public void draw(Graphics surface) {
// Draw the object
        surface.setColor(color);
        surface.fillOval(x , y , SIZE, SIZE);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x, y, SIZE, SIZE);

        //Move objects in a circular motion (adjust for center)
        x = (int) (xRadius* Math.sin(theta)) + 300;
        y = (int) (yRadius* Math.cos(theta)) + 300;

        //Reset at two radians (in degrees)
        if (theta > 114.5) {
            theta = 0;
        } else {
            theta += 0.05;
        }

    }
    //set radius method
    public void setRadius(int xDir, int yDir) {
        xRadius = xDir;
        yRadius = yDir;
    }

    //set starting point method
    public void setTheta(int startTheta) {
        theta = startTheta;

    }
}
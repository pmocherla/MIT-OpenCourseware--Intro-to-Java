/* MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 6: Graphics strikes back!
 * This file is a class that implements the Mover interface, to make objects move in an orbit.
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

import java.awt.Graphics;
import java.lang.Math;

public class OrbitMover implements Mover {
    private int radius;
    private int x;
    private int y;
    private double theta;
    private int xDirection;
    private int yDirection;
    private Sprite sprite;

    /** Create a Orbiter that positions sprite at radius. */
    public OrbitMover(int rad, Sprite sprite) {
        radius = rad;
        x = 150 - radius;
        y = 150;
        this.sprite = sprite;
        theta = 0;
    }
    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
    public void draw(Graphics graphics) {
        sprite.draw(graphics, x, y);
        // Move the center of the object each time we draw it
        x = (int) (radius * xDirection * Math.cos(theta)) + 150;
        y = (int) (radius * yDirection * Math.sin(theta)) + 150;

        if (theta > 360) {
            theta = 0;
        } else {
            theta += 0.1;
        }
    }
}
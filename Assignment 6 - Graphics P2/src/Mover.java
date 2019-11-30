/* MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 6: Graphics strikes back!
 * This file is a interface for the way an animated object can move.
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

import java.awt.Graphics;

public interface Mover {
    /**
     * Sets the movement vector of the sprite
     * in terms of x and y increments
     */
    void setMovementVector(int xIncrement, int yIncrement);
    /**
     * draw the mover in its path
     */
    void draw(Graphics surface);
}

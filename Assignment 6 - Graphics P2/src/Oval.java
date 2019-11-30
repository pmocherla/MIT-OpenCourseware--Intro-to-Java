/* MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 6: Graphics strikes back!
 * This file is a class that creates an oval object to be moved on screen.
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */

import java.awt.*;

public class Oval implements Sprite {
    private Color color;
    private int width;
    private int height;

    public Oval(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics surface, int leftX, int topY) {
        //Draw the shape of the oval
        surface.setColor(color);
        surface.fillOval(leftX, topY, width, height);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(leftX, topY, width, height);
    }

    public int getWidth() {
        //return width
        return width;
    }

    public int getHeight() {
        //return height
        return height;
    }
}

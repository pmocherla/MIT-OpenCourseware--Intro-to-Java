/* MIT Open Courseware
 * Intro to Programming in Java
 *
 * Assignment 6: Graphics strikes back!
 * This file is a class that initializes the class for drawing and draws contents of window on a surface.
 * Scripts written: Mover, DrawGraphics, Oval, OrbitMover
 * Polymorphism, Interfaces, Encapsulation
 *
 * Assignments can be found at the following link:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/index.htm
 */


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    private Rectangle box;
    private Oval circle;
    private ArrayList<Mover> movers;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        //bouncers = new ArrayList<Bouncer>();
        movers = new ArrayList<Mover>();

        //Draw two boxes that move in different ways
        box = new Rectangle(15, 20, Color.RED);
        movers.add(new Bouncer(100, 170, box));
        movers.get(0).setMovementVector(1, 2);
        movers.add(new OrbitMover(5, box));
        movers.get(1).setMovementVector(4, 1);

        //Draw two ovals that move in different ways
        circle = new Oval(20, 20, Color.cyan);
        movers.add(new Bouncer(10, 50, circle));
        movers.get(2).setMovementVector(-2, -3);
        movers.add(new OrbitMover(50, circle));
        movers.get(3).setMovementVector(1, 3);

    }
    /** Draw the contents of the window on surface. */
    //Draw each mover
    public void draw(Graphics surface) {
        for (int i = 0; i < movers.size(); i++) {
            movers.get(i).draw(surface);
        }

    }
} 
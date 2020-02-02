
/**
 * <h>Circle.java</h>
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O’Reilly) 
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Circle is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the
 * circle's bounding rectangle.
 */

public class Circle extends ClosedShape {
	// The diameter of the circle
	private int diameter;
	

	/**
	 * Creates a circle.
	 * 
	 * @param insertionTime	The time which you get displayed on the screen
	 * @param x        The display component's x position.
	 * @param y        The display component's y position.
	 * @param vx       The display component's x velocity.
	 * @param vy       The display component's y velocity.
	 * @param diameter The diameter of the circle.
	 * @param colour   The line colour or fill colour.
	 * @param isFilled True if the circle is filled with colour, false if opaque.
	 * @param isPulsing		True if the shape is pulsing, false otherwise
	 */
	public Circle(int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled, boolean isPulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.diameter = diameter;

	}

	/**
	 * Method to convert a circle to a string.
	 * <p>No parameters.</p>
	 * @return The processed information about the circle, read in from the specified text file
	 */
	public String toString() {
		String result = "This is a circle\n";
		result += super.toString();
		result += "Its diameter is " + this.diameter + "\n";
		return result;
	}

	/**
	 * Resets the diameter
	 * @param diameter the diameter of the shape .
	 * <p>Does not return anything.</p>
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	/**
	 * <p>No parameters </p>
	 * @return The diameter of the circle.
	 */
	public int getDiameter() {
		return diameter;
	}

	/**
	 * <p>No parameters </p>
	 * @return The width of the circle
	 */
	public int getWidth() {
		return diameter;
	}

	/**
	 * @return The height of the circle
	 */
	public int getHeight() {
		return diameter;
	}

	/**
	 * Draw the circle on the screen.
	 * @param g The graphics object of the scene component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		
		/* fills the circle only if it is specified to be filled, otherwise strokes it */
		if (isFilled) {
			g.fillOval(x, y, diameter, diameter);	/* fills in the circle */
		} else {
			g.strokeOval(x, y, diameter, diameter);	/* strokes the circle */
		}
	}
	
 	/**
 	 * Increase the size of the circle.
 	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
 	 */
	public void pulseUp () {
		/* if the shape is pulsing, enlarge the size of the circle back to the original */
		if(isPulsing) {
			this.diameter += 2;	/* increase the length of the diameter by 2 */
		}
	}
	
	/**
	 * Shrinks the shape back to original size of the circle.
	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
	 */
	public void pulseDown () {
		/* if the shape is pulsing, decrease the size of the circle back to the original */
		if(isPulsing) {		
			this.diameter -= 2;	/* decrement the diameter by 2 */
		}
	}
}

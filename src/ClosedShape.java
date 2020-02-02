
/**
 * <h>ClosedShape.java</h>
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * A ClosedShape is any shape that can be drawn without taking a pencil off a
 * piece of paper. It's representation on computer has a line colour and a
 * position on the drawable screen component. It can be filled in with colour or
 * opaque. This class is a super class for all shapes.
 */

public class ClosedShape {

	/**
	 * The x position of the Shape.
	 */
	protected int x;
	/**
	 * The y position of the Shape.
	 */
	protected int y;

	/**
	 * The x position of the Shape.
	 */
	protected int xVec;

	/**
	 * The y position of the Shape.
	 */
	protected int yVec;

	/**
	 * The line colour of the shape, or the filled in 
	 * colour if the Shape has fill.
	 */
	protected Color colour;

	/**
	 * Determines if the Shape has a fill colour or not.
	 */
	protected boolean isFilled;

	/**
	 * Encodes the insertion time into the scene
	 */
	private int insertionTime;
	
	/**
	 * Determines if the shape is pulsing or not
	 */
	protected boolean isPulsing;

	/**
	 * Creates a closed shape object.
	 * @param x        The x position.
	 * @param y        the y position.
	 * @param colour   The line or fill colour.
	 * @param isFilled True if the shape is filled, false if not.
	 */
	protected ClosedShape(int insertionTime, int x, int y, int vx, int vy, Color colour, boolean isFilled, boolean isPulsing) {
		this.x = x;
		this.y = y;
		this.xVec = vx;
		this.yVec = vy;
		this.colour = colour;
		this.isFilled = isFilled;
		this.insertionTime = insertionTime;
		this.isPulsing = isPulsing;
	}

	/**
	 * The method returns a string suitable for printing.
	 * <p>No parameters</p>
	 * @return string to print out shape.
	 */
	public String toString() {
		String result = "";
		result += "Its position is " + x + " " + y + "\n";
		result += "Its velocity is " + xVec + " " + yVec + "\n";
		result += "Its colour is " + colour + "\n";
		if (isFilled) {
			result += "It is filled" + "\n";
		} else {
			result += "It is not filled" + "\n";
		
		if (isPulsing) {
			result += "It is pulsing" + "\n";
		}
		else {
			result += "It is not pulsing" + "\n";
			result += "It should be inserted at " + insertionTime + "\n";
		}
		}
		return result;
	}

	/**
	 * Resets the x position. 
	 * @param x the starting x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Resets the y position.
	 * @param y the starting y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Resets the x vector
	 * @param x the starting x coordinate
	 */
	public void setVecX(int x) {
		this.xVec = x;
	}

	/**
	 * Resets the y vector.
	 * @param y the starting y coordinate
	 */
	public void setVecY(int y) {
		this.yVec = y;
	}

	/**
	 * Resets the colour.
	 * @param colour the colour of the shape
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}

	/**
	 * Sets the shape to filled.
	 */
	public void setFilled() {
		isFilled = true;
	}

	/**
	 * Sets the shape to unfilled.
	 */
	public void unsetFilled() {
		isFilled = false;
	}

	/**
	 * Sets the insertion time.
	 * @param time time at which the shape appears on the window
	 */
	public void setInsertionTime(int time) {
		insertionTime = time;
	}
	
	/**
	 * Sets the shape to be pulsing.
	 */
	public void setPulsing() {
		isPulsing = true;
	}

	/**
	 * Sets the shape to not pulsing.
	 */
	public void unsetPulsing() {
		isPulsing = false;
	}

	/**
	 * @return The x position value.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return The y position value.
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return The colour.
	 */
	public Color getColour() {
		return colour;
	}

	/**
	 * @return True if the shape is filled, false if not.
	 */
	public boolean isFilled() {
		return isFilled;
	}

	/**
	 * @return the insertion time.
	 */
	public int getInsertionTime() {
		return insertionTime;
	}

	/**
	 * @return True if the shape is pulsing, false if not.
	 */
	public boolean isPulsing() {
		return isPulsing;
	}
	
	/**
	 * Puts the shape back in bounds in X
	 * @param winX the width of the window
	 */ 
	public void putInBoundsX(double winX) {
		if (x < 0)
			x = 0;
		if (x + this.getWidth() > winX) {
			x = (int) (winX - Math.ceil(this.getWidth()));
		}
	}

	/**
	 * Puts the shape back in bounds
	 * @param winY the height of the window
	 */
	public void putInBoundsY(double winY) {
		if (y < 0)
			y = 0;
		if (y + this.getHeight() > winY) {
			y = (int) (winY - Math.ceil(this.getHeight()));
		}
	}

	/**
	 * Bounces the shape off a vertical wall
	 */
	public void bounceX() {
		xVec = -xVec;
	}

	/**
	 * Bounces the shape off a horizontal wall
	 */
	public void bounceY() {
		yVec = -yVec;
	}

	/**
	 * Returns true if the shapes have gone out of bounds in X
	 * @param winX the width of the window
	 * @return True if shape is out of bounds in X
	 */
	public boolean outOfBoundsX(double winX) {
		return (x + this.getWidth() > winX) || (x < 0);
	}

	/**
	 * Returns true if the shapes have gone out of bounds in Y
	 * @param winY the height of the window
	 * @return True if shape is out of bounds in Y
	 */
	public boolean outOfBoundsY(double winY) {
		return (y + this.getHeight() > winY) || (y < 0);
	}

	/**
	 * Takes in a direction and a velocity and moves the shape in that direction on
	 * unit
	 */
	public void move() {
		x += xVec;
		y += yVec;
	}

	/**
	 * Draws the object to the current component.
	 * @param g The graphics object associated with the drawing component.
	 * <p>Does not return anything.</p>
	 */
	public void draw(GraphicsContext g) {
		System.out.println("You forgot to override this method! (draw)");
		System.out.println("Don't modify this method.");
	}

	/**
	 * Get the width of the current component
	 * @return false
	 */
	public int getWidth() {
		System.out.println("You forgot to override this method! (getWidth)");
		System.out.println("Don't modify this method.");
		return 1;
	}

	/**
	 * Get the width of the current component
	 * @return false
	 */
	public int getHeight() {
		System.out.println("You forgot to override a method! (getHeight)");
		System.out.println("Don't modify this method.");
		return 1;
	}
	
	/**
	 * Defines the pulseUp, to later be overridden individually for each shape
	 */
	public void pulseUp () {
		
	}
	
	/**
	 * Defines the pulseUp, to later be overridden individually for each shape
	 */
	public void pulseDown () {
		
	}
	
}


/**
 * <h1>Square.java</h1>
 * The class Square constructs a rectangle by inheriting data from the class 
 * <p>No Copyright</p>
 * @version 1.1
 * <p> 1.0 - Draws a fully functioning square
 * <p> 1.1 - Step 5 completed - the shape constructed from reading data from a text file now pulses as it moves </p>
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Square is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the square.
 */
public class Square extends ClosedShape{

	// The length of the sides (height and width) of the square (both major and minor axis)
	private int side;
	
	/**
	 * Creates a square.
	 * @param insertionTime	The time which you get displayed on the screen
	 * @param x        		The display component's x position.
	 * @param y        		The display component's y position.
	 * @param vx       		The display component's x velocity.
	 * @param vy       		The display component's y velocity.
	 * @param side			The length of the sides of the square.
	 * @param colour   		The line colour or fill colour.
	 * @param isFilled 		True if the square is filled with colour, false if opaque.
	 * @param isPulsing		True if the shape is pulsing, false otherwise
	 * <p>Does not return anything.</p>
	 */
	public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean isPulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.side = side;
	}
	
	/**
	 * Method to convert a square to a string.
	 * <p>No parameters.</p>
	 * @return The processed information about the square, read in from the specified text file
	 */
	public String toString() {
		String result = "This is a square\n";
		result += super.toString();
		result += "Its side is " + this.side + "\n";
		return result;
	}

	/**
	 * Resets the side.
	 * @param side length of the sides
	 * <p>Does not return anything.</p>
	 */
	public void setSide(int side) {
		this.side = side;
	}

	/**
	 * <p>No parameters.</p>
	 * @return The side of the square.
	 */
	public int getSide() {
		return this.side;
	}
	
	/**
	 * <p>No parameters.</p>
	 * @return The height of the square.
	 */
	public int getHeight() {
		return this.side;
	}
	
	/**
	 * <p>No parameters.</p>
	 * @return The width of the square.
	 */
	public int getWidth() {
		return this.side;
	}
	
	/**
	 * Draw the square on the screen.
	 * @param g The graphics object of the scene component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		
		/* fills the oval only if it is specified to be filled, otherwise strokes it */
		if (isFilled) {
			g.fillRect(x, y, side, side); /* fills in the square */
		} else {
			g.strokeRect(x, y, side, side); /* strokes the square */
		}
	}
	
 	/**
 	 * Increase the size of the square.
 	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
 	 */
	public void pulseUp () {
		/* if the shape is pulsing, enlarge the size of the square back to the original */
		if(isPulsing) {
			this.side += 2;	/* increase the length of the sides by 2 */
		}
	}
	
	/**
	 * Shrinks the shape back to original size of the squaree.
	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
	 */
	public void pulseDown () {
		/* if the shape is pulsing, decrease the size of the rectangle back to the original */
		if(isPulsing) {
			this.side -= 2;	/* increase the length of the sides by 2 */
		}
	}
	
}


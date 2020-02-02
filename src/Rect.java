
/**
 * <h1>Rect.java</h1>
 * The class Rect constructs a rectangle by inheriting data from the class 
 * <p>ClosedShapeFile. This class also control how the shape pulses.</p>
 * @author Jumaira Miller, 983101
 * <p>No Copyright</p>
 * @version 1.1
 * <p> 1.0 - Draws a fully functioning rectangle
 * <p> 1.1 - Step 5 completed - the shape constructed from reading data from a text file now pulses as it moves </p>
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rectangle is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the 
 * rectangle.
 */
public class Rect extends ClosedShape {
	
	// The width and height of the oval (major and minor axis)
	private int width, height; 
	
	/**
	 * Creates a rectangle.
	 * 
	 * @param insertionTime	The time which you get displayed on the screen
	 * @param x        		The display component's x position.
	 * @param y        		The display component's y position.
	 * @param vx       		The display component's x velocity.
	 * @param vy       		The display component's y velocity.
	 * @param width    		The width of the rectangle (in pixels).
	 * @param height   		The height of the rectangle (in pixels).
	 * @param colour   		The line colour or fill colour.
	 * @param isFilled 		True if the rectangle is filled with colour, false if opaque.
	 * @param isPulsing		True if the shape is pulsing, false otherwise
	 * <p>Does not return anything.</p>
	 */
	public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean isPulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.width = width;
		this.height = height;
		
	}
	/**
     * Method to convert a rectangle to a string.
     * No parameters are required.
	 * @return The processed information about the rectangle, read in from the specified text file
     */
    public String toString () {
    	String result = "This is a rectangle\n";
    	result += super.toString ();
	result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }

	/**
	 * @param width Resets the width.
	 */
 	public void setWidth (int width) {
		this.width = width;
	}

 	/**
 	 * @param height Resets the height.
 	 */
 	public void setHeight (int height) {
		this.height = height;
	}

 	/**
 	 * 
 	 * @return The width of the rectangle.
 	 */
 	public int getWidth() {
		return this.width;
	}

 	/**
 	 * No parameters are required.
 	 * @return The height of the rectangle.
 	 */
 	public int getHeight() {
		return this.height;
	}
 	
 	/**
 	 * Draw the rectangle.
 	 * @param g The graphics object of the drawable component.
 	 * <p>Does not return anything.</p>
 	 */
 	public void draw (GraphicsContext g) {
		g.setFill (colour);
		g.setStroke( colour );
		
		/* fills the rectangle only if it is specified to be filled, otherwise strokes it */
		if (isFilled) {
			g.fillRect( x, y, width, height );		/* fills in the rectangle */
		} 
		else {
			g.strokeRect( x, y, width, height );	/* strokes the square */
		}
	}
 	
 	/**
 	 * Increase the size of the rectangle.
 	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
 	 */
	public void pulseUp () {
		/* if the shape is pulsing, enlarge the size of the rectangle back to the original */
		if(isPulsing) {
			this.height += 2;	/* increment the height by 2 */
			this.width += 2;	/* increment the width by 2 */
		}
	}
	
	/**
	 * Shrinks the shape back to the original size of the rectangle.
	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
	 */
	public void pulseDown () {
		/* if the shape is pulsing, decrease the size of the rectangle back to the original */
		if(isPulsing) {
			this.height -= 2;	/* decrement the height by 2 */
			this.width -= 2;	/* decrement the width by 2 */
		}
	}
}

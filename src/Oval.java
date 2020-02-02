
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * <h>Oval.java</h>
 * Oval is an oval shape that can be drawn to the screen, either filled with
 * colour or opaque. Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 * <p>No Copyright</p>
 * @version 1.1
 * <p> 1.0 - Draws a fully functioning oval
 * <p> 1.1 - Step 5 completed - the shape constructed from reading data from a text file now pulses as it moves </p>
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 */

/**
 * oval is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the 
 * bounding rectangle.
 */
public class Oval extends ClosedShape {
	// The width and height of the oval (major and minor axis)
	private int width, height;

	/**
	 * Creates an oval.
	 * @param x        		The display component's x position.
	 * @param y        		The display component's y position.
	 * @param vx       		The display component's x velocity.
	 * @param vy       		The display component's y velocity.
	 * @param width    		The width of the oval (in pixels).
	 * @param height   		The height of the oval (in pixels).
	 * @param colour   		The line colour or fill colour.
	 * @param insertionTime	The time which you get displayed on the screen
	 * @param isFilled 		True if the oval is filled with colour, false if opaque.
	 * @param isPulsing		True if the shape is pulsing, false otherwise
	 * <p>Does not return anything.</p>
	 */
	public Oval (int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean isPulsing) {
		super (insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.width = width;
		this.height = height;
	}

	/**
     * Method to convert an oval to a string.
     * <p>No parameters.</p>
     * @return The processed information about the oval, read in from the specified text file
     */
    public String toString () {
    	String result = "This is an oval\n";
    	result += super.toString ();
	result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }

	/**
	 * @param width Resets the width.
	 * <p>Does not return anything.</p>
	 */
 	public void setWidth (int width) {
		this.width = width;
	}

 	/**
 	 * @param height Resets the height.
 	 * <p>Does not return anything.</p>
 	 */
 	public void setHeight (int height) {
		this.height = height;
	}

 	/**
 	 * <p>No parameters </p>
 	 * @return The width of the oval.
 	 */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * <p>No parameters </p>
 	 * @return The height of the oval.
 	 */
 	public int getHeight() {
		return height;
	}

 	/**
 	 * Draw the oval.
 	 * @param g The graphics object of the drawable component.
 	 * <p>Does not return anything.</p>
 	 */
	public void draw (GraphicsContext g) {
		g.setFill (colour);
		g.setStroke( colour );

		/* fills the oval only if it is specified to be filled, otherwise strokes it */
		if (isFilled) {
			g.fillOval( x, y, width, height );		/* fills in the oval */
		} else {
			g.strokeOval( x, y, width, height );	/* strokes the oval */
		}
	}
	
 	/**
 	 * Increase the size of the oval.
 	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
 	 */
	public void pulseUp () {
		/* if the shape is pulsing, enlarge the size of the oval back to the original */
		if(isPulsing) {
			this.height += 2;	/* increment the height by 2 */
			this.width += 2;	/* increment the width by 2 */
		}
	}
	
	/**
	 * Shrinks the shape back to original size of the oval.
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

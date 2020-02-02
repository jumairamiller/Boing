
/**
 * <h1>Pent.java</h1>
 * The class Pent constructs a pentagon from a given point P(x,y) by inheriting
 * <p>data from the class ClosedShapeFile. This class also control how the shape pulses.</p>
 * @author Jumaira Miller, 983101
 * <p>No Copyright</p>
 * @version 1.1
 * <p> 1.0 - Fully satisfies step 4 of the assignment - a new shape is constructed and functions as specified </p>
 * <p> 1.1 - Step 5 completed - the shape constructed from reading data from a text file now pulses as it moves </p>
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Pentagon is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the 
 * pentagon's bounding rectangle.
 */
public class Pent extends ClosedShape {
	
	
	private int side;		/* length of each side */
	
	/**
	 * Creates Pentagon.
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
	public Pent(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean isPulsing) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, isPulsing);
		this.side = side;
	}

	/**
	 * Method to convert a pentagon to a string.
	 * <p>No parameters.</p>
	 * @return The processed information about the pentagon, read in from the specified text file
	 */
	public String toString() {
		String result = "This is an pentagon\n";
		result += super.toString();
		result += "Its side is " + this.side + "\n";
		return result;
	}

	/**
	 * Method to refer to width
	 * <p>No parameters.</p>
	 * @return The width of the pentagon.
	 */
	public int getWidth() {
		return this.side;
	}

	/**
	 * Method to refer to the height
	 * <p>No parameters.</p>
	 * @return The height of the pentagon.
	 */
	public int getHeight() {
		return this.side;
	}
	
	/**
	 * Draw the pentagon.
	 * @param g The graphics object of the drawable component.
	 * <p>Does not return anything</p>
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);						/* fills the path with the correct colour */
		g.setStroke(colour);					/* strokes the path with the correct colour */
		double h = g.getCanvas().getHeight();	/* height of pentagon to bound in a rectangle */
		double w = g.getCanvas().getWidth();	/* width of the pentagon to bound in a rectangle */
		
		//Puts the pentagon in a bounded frame
		putInBoundsX(w);
		putInBoundsY(h);
		
		/* array of formulas to calculate other x coordinates */
		double[] xPoints = {
				x + this.getWidth() / 2,
				x + this.getWidth(),
				x + 0.8 * this.getWidth(),
				x + this.getWidth() / 5,
				x
				};
		
		/* array of formulas to calculate other y coordinates */
		double[] yPoints = { 
				y, 
				y + this.getHeight() / 2, 
				y + this.getHeight(), 
				y + this.getHeight(), 
				y + this.getHeight() / 2};

		/* fills the pentagon only if it is specified to be filled, otherwise strokes the pentagon */
		if (isFilled) {
			g.fillPolygon(xPoints, yPoints, 5); 	/* fills the pentagon with the calculated points */
		} else {
			g.strokePolygon(xPoints, yPoints, 5);	/* strokes the pentagon with the calculated points */
		}
	}
	
	/**
	 * Increase the size of the pentagon.
	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
	 */
	public void pulseUp () {
		/* increases the size only if the shape is meant to be pulsing */
		if(isPulsing) {
			this.side += 2; /* increases length of sides */
		}
	}
	
	/**
	 * Shrinks the shape back to the original size of the pentagon.
	 * <p>No parameters.</p>
	 * <p>Does not return anything.</p>
	 */
	public void pulseDown () {
		/* decreases the size back to its original only if the shape is meant to be pulsing */
		if(isPulsing) {
			this.side -= 2; /* decreases length of sizes */
		}
	}
}

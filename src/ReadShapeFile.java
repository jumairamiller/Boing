/**
 * <h1>ReadSHapeFile.java</h1>
 * The class ReadShapeFile reads each line of a given text file and extracts information required to draw each 
 * <p>of these shapes, storing these bits of data in appropriate variables</p>
 * @author Jumaira Miller, 983101
 * <p>No Copyright</p>
 * @version 1.1
 * <p> 1.0 - methods for extracting information from lines to construct circles and ovals </p>
 * <p> 1.1 - methods for extracting information from lines to construct squares and rectangles </p>
 * <p> 1.1 - methods for extracting information from lines to construct pentagons </p>
 * @since 21/03/2019 
 * <p>Last Modified: 21/03/2019</p>
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/**
	 * Method to read text files to abstract information to construct a circle
	 * @param line	The scanner reads each line of the text file
	 * @return The processed information read from the text file
	 */
	public static Circle constructCircle(Scanner line) {
		int x = line.nextInt();					/* initial x coordinate */
		int y = line.nextInt();					/* initial y coordinate */
		int vx = line.nextInt();				/* velocity of circle on x plane */
		int vy = line.nextInt();				/* velocity of circle on y plane */
		boolean isFilled = line.nextBoolean();	/* whether the circle is filled, or not */
		int diameter = line.nextInt();			/* diameter of the circle */
		int r = line.nextInt();					/* amount of red in the circle */
		int g = line.nextInt();					/* amount of green in the circle */
		int b = line.nextInt();					/* amount of blue in the circle */
		Color colour = Color.rgb(r, g, b);		/* colour of circle */
		int insertionTime = line.nextInt();		/* time at which the circle appears in the window*/
		boolean isPulsing = false; 				/* whether the shape to pulse or not */
		 
		/*
		 * Updates the default value of 'isPulsing', if a boolean value is 
		 * provided for the shape in the lines from text file being read
		 */
		if(line.hasNextBoolean()) {
			isPulsing = line.nextBoolean(); /* Update the value of 'isPulsing' */
		}
		
		/* Creates a new instance of a circle for each line of information provided for circles */
		Circle c = new Circle(insertionTime, x, y, vx, vy, diameter, colour, isFilled, isPulsing); 
		System.out.println(c.toString());
		return c;
	}
	
	/**
	 * Method to read text files to abstract information to construct an oval
	 * @param line	The scanner reads each line of the text file
	 * @return The processed information read from the text file
	 */
	public static Oval constructOval(Scanner line) {
		int x = line.nextInt();					/* initial x coordinate of oval */
		int y = line.nextInt();					/* initial y coordinate of oval */
		int vx = line.nextInt();				/* velocity of oval on x plane */
		int vy = line.nextInt();				/* velocity of oval on y plane */
		boolean isFilled = line.nextBoolean();	/* whether the oval is filled, or not */
		int width = line.nextInt();				/* width of oval */
		int height = line.nextInt();			/* height of oval */
		int r = line.nextInt();					/* amount of red in the oval */
		int g = line.nextInt();					/* amount of green in the oval */
		int b = line.nextInt();					/* amount of blue in the circle */
		Color colour = Color.rgb(r, g, b);		/* colour of circle */
		int insertionTime = line.nextInt();		/* time at which oval appears in window */
		boolean isPulsing = false; 				/* whether the shape to pulse or not */
		
		/*
		 * Updates the default value of 'isPulsing', if a boolean value is 
		 * provided for the shape in the lines from text file being read
		 */
		if(line.hasNextBoolean()) {
			isPulsing = line.nextBoolean();	 	/* Update the value of 'isPulsing' */
		}
		
		/* Creates a new instance of an oval for each line of information provided for ovals */
		Oval o = new Oval(insertionTime, x, y, vx, vy, width, height, colour, isFilled, isPulsing);
		System.out.println(o.toString());
		return o;
	}
	
	/**
	 * Method to read text files to abstract information to construct a square
	 * @param line	The scanner reads each line of the text file
	 * @return The processed information read from the text file
	 */
	public static Square constructSquare(Scanner line) {
		int x = line.nextInt();					/* initial x coordinate of square */
		int y = line.nextInt();					/* initial y coordinate of square */
		int vx = line.nextInt();				/* velocity of square on x plane */
		int vy = line.nextInt();				/* velocity of square on y plane */
		boolean isFilled = line.nextBoolean();	/* whether the square is filled, or not */
		int side = line.nextInt();				/* length of sides of square*/
		int r = line.nextInt();					/* amount of red in the square */
		int g = line.nextInt();					/* amount of green in the square */
		int b = line.nextInt();					/* amount of blue in the square */
		Color colour = Color.rgb(r, g, b);		/* colour of square */
		int insertionTime = line.nextInt();		/* time at which square appears in window */
		boolean isPulsing = false; 				/* whether the shape to pulse or not */
		
		/*
		 * Updates the default value of 'isPulsing', if a boolean value is 
		 * provided for the shape in the lines from text file being read
		 */
		if(line.hasNextBoolean()) {
			isPulsing = line.nextBoolean();		/* Update the value of 'isPulsing' */
		}
		
		/* Creates a new instance of a square for each line of information provided for squares */
		Square s = new Square(insertionTime, x, y, vx, vy, side, colour, isFilled, isPulsing);
		System.out.println(s.toString());
		return s;
	}

	/**
	 * Method to read text files to abstract information to construct a rectangle
	 * @param line	The scanner reads each line of the text file
	 * @return The processed information read from the text file
	 */
	public static Rect constructRect(Scanner line) {
		int x = line.nextInt();					/* initial x coordinate of rectangle */
		int y = line.nextInt();					/* initial y coordinate of rectangle */
		int vx = line.nextInt();				/* velocity of rectangle on x plane */
		int vy = line.nextInt();				/* velocity of rectangle on y plane */
		boolean isFilled = line.nextBoolean();	/* whether the rectangle is filled, or not */
		int width = line.nextInt();				/* width of rectangle */
		int height = line.nextInt();			/* height of rectangle */
		int r = line.nextInt();					/* amount of red in the rectangle */
		int g = line.nextInt();					/* amount of green in the rectangle */
		int b = line.nextInt();					/* amount of blue in the rectangle */
		Color colour = Color.rgb(r, g, b);		/* colour of circle */
		int insertionTime = line.nextInt();		/* time at which rectangle appears in window */
		boolean isPulsing = false; 				/* whether the shape to pulse or not */
		
		/*
		 * Updates the default value of 'isPulsing', if a boolean value is 
		 * provided for the shape in the lines from the text file being read
		 */
		if(line.hasNextBoolean()) {
			isPulsing = line.nextBoolean();		/* Update the value of 'isPulsing' */
		}
		
		/* Creates a new instance of a rectangle for each line of information provided for rectangle */
		Rect rect = new Rect(insertionTime, x, y, vx, vy, width, height, colour, isFilled, isPulsing);
		System.out.println(rect.toString());
		return rect;
	}
	
	public static Pent constructPent(Scanner line) {
		int x = line.nextInt();					/* initial x coordinate of pentagon */
		int y = line.nextInt();					/* initial y coordinate of pentagon */
		int vx = line.nextInt();				/* velocity of pentagon on x plane */
		int vy = line.nextInt();				/* velocity of pentagon on y plane */
		boolean isFilled = line.nextBoolean();	/* whether the pentagon is filled, or not */
		int side = line.nextInt();				/* length of sides of pentagon */
		int r = line.nextInt();					/* amount of red in the pentagon */
		int g = line.nextInt();					/* amount of green in the pentagon */
		int b = line.nextInt();					/* amount of blue in the pentagon */
		Color colour = Color.rgb(r, g, b);		/* colour of pentagon */
		int insertionTime = line.nextInt();		/* time at which pentagon appears in window */
		boolean isPulsing = false; 				/* whether the shape to pulse or not */
		
		/*
		 * Updates the default value of 'isPulsing', if a boolean value is 
		 * provided for the shape in the lines from the text file being read
		 */
		if(line.hasNextBoolean()) {
			isPulsing = line.nextBoolean();		/* Update the value of 'isPulsing' */
		}
		
		/* Creates a new instance of a pentagon for each line of information provided for pentagons */
		Pent p = new Pent(insertionTime, x, y, vx, vy, side, colour, isFilled, isPulsing);
		System.out.println(p.toString());
		return p;
	}
	
	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
		
		/* Reads each line of the text file and depending on what the first string on the line 
		 * indicates, the shape to be drawn is determined by the loop */
		/* Terminates when the line being read does not contain a string as the next element */
		while (in.hasNextLine()) {
		 
			Scanner line = new Scanner (in.nextLine());
			String id = line.next();	/* identity of the shape specified on the line */
			
			/*only if the first string of the line specifies a 'circle', a circle is added to the ShapeQueue to be constructed */
			if(id.equals("circle")) {
				shapeQueue.enqueue(constructCircle(line));
			
			/*only if the first string of the line specifies an 'oval', an oval is added to the ShapeQueue to be constructed */	
			} else if (id.equals("oval")) {
				shapeQueue.enqueue(constructOval(line));
			
			/*only if the first string of the line specifies a 'square', a square is added to the ShapeQueue to be constructed */
			} else if (id.equals("square")) {
				shapeQueue.enqueue(constructSquare(line));
				
			/*only if the first string of the line specifies a 'rectangle', a rectangle is added to the ShapeQueue to be constructed */	
			} else if (id.equals("rect")){
				shapeQueue.enqueue(constructRect(line));
				
			/*only if the first string of the line specifies a 'pentagon', a circle is added to the ShapeQueue to be constructed */	
			} else if (id.equals("pent")){
				shapeQueue.enqueue(constructPent(line));
			}
			line.close();
		}
		in.close();
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		
		File inputFile = new File(filename);
		Scanner in = null;
		try {
			in = new Scanner(inputFile);
		}
		/* output an error message if filename is not found, instead of crashing */
		catch (FileNotFoundException e) {
			System.out.println("Cannot open " + filename);
			System.exit(0);
		}
		return ReadShapeFile.readDataFile(in);
	}
}

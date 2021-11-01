import java.io.*;
import java.util.*;

/**
 *  * Class: CMSC203 
 * Instructor: Dr. Grigoriy Grinberg
 * Description: This program creates a plot object
 * Due: 10/25/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * 
 * This is the plot class where all the plot information is stored. 
 * This is also where the plots are examined whether they are encompassed in the main plot
 * or they are overlapping, etc.
 * @author Matthew McNey
 *
 */

public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	/**
	 * This is a constructor that constructs a plot object, 
	 * symbolic of a ownerless plot of land with no set dimensions
	 */  
	
	public Plot() 
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	/**
	 * This constructor is a copy of the plot object
	 * @param p
	 */
	public Plot(Plot p) 
	{
		x = p.getX();
		y = p.getY();
		width = p.getWidth();
		depth = p.getDepth();
	}

	/**
	 * This constructor is parameterized; the purpose of this constructor
	 * is to assign specific values to the instance variables of different objects
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	
	public Plot(int x, int y, int width, int depth) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * A Plot parameter is passed into this method 
	 * the Plot object is compared to the currently created object.
	 * It's checking to see if there is overlap between the two objects
	 * returns true if there is overlap otherwise returns false.
	 * @param plot
	 * @return overlaps
	 */
	
	public boolean overlaps(Plot plot) 
	{
		// holds overlaps result
		boolean overlaps;
		int x1p1 = this.getX(); // starting x-coor, first plot obj
		int y1p1 = this.getY(); // starting y-coor, first plot obj
		int x2p1 = this.getX() + this.getWidth(); // farthest x-coor, first plot obj
		int y2p1 = this.getY() + this.getDepth(); // farthest y-coor, first plot obj
		
		int x1p2 = plot.getX(); // starting x-coor, second plot obj
		int y1p2 = plot.getY(); // starting y-coor, second plot obj
		int x2p2 = plot.getX() + plot.getWidth(); // farthest x-coor, second plot obj
		int y2p2 = plot.getY() + plot.getDepth(); // farthest y-coor, second plot obj
		
		// let's check to see if we got overlap
		if (x1p2 < x2p1 && x2p2 > x1p1 && y1p2 < y2p1 && y2p2 > y1p1)
			overlaps = true; 
		else
			overlaps = false;

		return overlaps;
	}

	/**
	 * 
	 * @param plot
	 * @return encompasses
	 */
	
	public boolean encompasses(Plot plot) 
	{
		boolean encompasses;
		
		int x1p1 = this.getX(); // starting x-coor, first plot obj
		int x2p1 = this.getX() + this.getWidth(); // farthest x-coor, first plot obj
		int y1p1 = this.getY(); // starting y-coor, first plot obj
		int y2p1 = this.getY() + this.getDepth(); // farthest y-coor, first plot obj
		
		int x1p2 = plot.getX(); // starting x-coor, second plot obj
		int x2p2 = plot.getX() + plot.getWidth(); // farthest x-coor, second plot obj
		int y1p2 = plot.getY(); // starting y-coor, second plot obj
		int y2p2 = plot.getY() + plot.getDepth(); // farthest y-coor, second plot obj
		
		// Let's check if the plot we want to add is within the main plot
		if (x1p1 <= x1p2 && y1p1 <= y1p2 && x2p1 >= x2p2 && y1p1 <= y2p2 && y2p1 >= y2p2)
			encompasses = true;
		else
			encompasses = false;

		return encompasses;
	}

	/**
	 * Getter for xcoordinate
	 * @return x
	 */
	
	public int getX() 
	{
		return x;
	}

	/**
	 * Setter for xcoordinate
	 * @param x
	 */
	
	public void setX(int x) 
	{
		this.x = x;
	}

	/**
	 * Getter for ycoordinate
	 * @return
	 */
	
	public int getY() 
	{
		return y;
	}
	
	/**
	 * Setter for ycoordinate
	 * @param y
	 */

	public void setY(int y) 
	{
		this.y = y;
	}
	
	/**
	 * Set the width of the plot
	 * @param width
	 */

	public void setWidth(int width) 
	{
		this.width = width;
	}
	
	/**
	 * Getter for the width of the plot
	 * @return width
	 */

	public int getWidth() 
	{
		return width;
	}

	/**
	 * Getter for the depth of the plot
	 * @return depth
	 */
	
	public int getDepth() 
	{
		return depth;
	}
	
	/**
	 * Setter for the depth of the plot
	 * @param depth
	 */

	public void setDepth(int depth) 
	{
		this.depth = depth;
	}

	/**
	 * This toString method returns the coordinates, width, depth of the plot object.
	 * 
	 * @return Upper left: (x, y); Width: ? Depth: ?
	 */
	
	public String toString() 
	{
		String plotString = "";
		
		plotString = "Upper left: (" + this.x + "," + this.y + "); Width: " + this.width + " Depth: " + this.depth;
		
		return plotString;
	}

}

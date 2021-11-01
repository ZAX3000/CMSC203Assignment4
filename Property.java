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
 * This is the property class where all the property information is stored.
 * @author Matthew McNey
 *
 */

public class Property {

	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;

	/**
	 * This is a constructor that will create a blank property object
	 */
	
	public Property() 
	{
		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
		plot = new Plot(0,0,1,1);
	}
	
	/**
	 * Another constructor with copies of values from plot and a new Plot object
	 * that stores the values of the passed through plot object
	 * @param p
	 */

	public Property(Property p) 
	{
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.rentAmount = p.rentAmount;
		this.owner = p.owner;
		this.plot = new Plot(p.getPlot());
	}
	
	/**
	 * This passes on the property name, city, rent amount and owner name from the method call elsewhere;
	 * creates a default Plot object with default values
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */

	public Property(String propertyName, String city, double rentAmount, String owner) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	/**
	 * 
	 * This constructor passes property name, city, rent amount, owner name,
	 * and even the x, y coordinates width and depth
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot (x, y, width, depth);
		
	}

	/**
	 * This method will get the property name as the return.
	 * @return propertyName
	 */
	
	public String getPropertyName() 
	{
		return propertyName;
	}

	/**
	 * This method will set the property name.
	 * @param propertyName
	 */
	
	public void setPropertyName(String propertyName) 
	{
		this.propertyName = propertyName;
	}

	/**
	 * This method is a getter for the city.
	 * @return city
	 */
	
	public String getCity() 
	{
		return city;
	}

	/**
	 * This is a method for getting the plot object.
	 * @return plot
	 */
	
	public Plot getPlot() 
	{
		return plot;
	}

	/**
	 * This method is supposed to pass parameter values into the Plot object.
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	
	public Plot setPlot(int x, int y, int width, int depth) 
	{
		return this.plot = new Plot (x, y, width, depth);
	}
	
	/**
	 * This method sets the city.
	 * @param city
	 */
	
	public void setCity(String city) 
	{
		this.city = city;
	}

	/**
	 * This method gets the rental amount.
	 * @return rentAmount
	 */
	
	public double getRentAmount() 
	{
		return rentAmount;
	}

	/**
	 * This method sets the rent amount.
	 * @param rentAmount
	 */
	
	public void setRentAmount(double rentAmount) 
	{
		this.rentAmount = rentAmount;
	}
	
	/**
	 * This method gets the owner name.
	 * @return owner
	 */

	public String getOwner() 
	{
		return owner;
	}

	/**
	 * This method will set the owner name.
	 * @param owner
	 */
	
	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	/**
	 * Here's the toString! This method will print out the name, city, owner name and rental amount for a property.
	 * @return str
	 */
	
	public String toString() 
	{
		String str = "";
		str += "\nProperty Name: " + this.propertyName;
		str += "\n Located in " + this.city;
		str += "\n Belonging to: " + this.owner;
		str += "\n Rent Amount: " + this.rentAmount;
		return str;
	}

}

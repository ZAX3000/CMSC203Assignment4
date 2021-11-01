import java.io.*;
import java.lang.reflect.Array;
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
 * This is the management company class. This is the data driver for the overall package.
 * @author Matthew McNey
 *
 */

public class ManagementCompany 
{

	// declare variables; 
	
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int propertyAccumulator = 0;

	/**
	 * The Management Company constructor; this creates a management company with a default main plot
	 * uses, the (0,0) origin and then expands from there using default width and depth
	 */
	
	public ManagementCompany() 
	{
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * This constructor passes three parameters that will create a new management company, 
	 *  a new property object with default plot settings
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */

	public ManagementCompany(String name, String taxID, double mgmFee) 
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * This constructor passes all the parameters needed to create a management company and property with defined plot values
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) 
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * This constructor creates a new management company object
	 * @param otherCompany
	 */

	public ManagementCompany(ManagementCompany otherCompany) 
	{
		ManagementCompany anotherCompany = new ManagementCompany(otherCompany);
	}
	
	/**
	 * This method returns the max properties for a properties array
	 * @return MAX_PROPERTY
	 */

	public int getMAX_PROPERTY() 
	{
		return MAX_PROPERTY;
	}
	
	/**
	 * This method gets the property plot
	 * @return plot
	 */
	
	public Plot getPlot() 
	{
		return plot;
	}
	
	/**
	 * This method gets the name of the property
	 * @return name
	 */
	
	public String getName()
	{
		return name;
	}
	
	public String getTaxID()
	{
		return taxID;
	}

	/**
	 * This method will examine the property you are adding, 
	 * then either return an int value if it doesn't pass the tests
	 * or adds the property to the properties array
	 * @param property
	 * @return -1 if more properties than max properties, -2 if property object is null, 
	 * -3 if the new plot is not within the main plot (or you can say the new plot is not encompassed by the main plot)
	 * -4 if any properties already in the array are overlapping the new plot
	 * if none of these are true then a new property object is created in the array
	 * and the propertyAccumulator is incremented
	 */
	
	public int addProperty(Property property) 
	{
		
		// checks to make sure the array is not full
		if (propertyAccumulator >= this.MAX_PROPERTY)
		{
			return -1;
		}
		
		// checks if the property object is null
		
		if (Objects.isNull(property))
		{
			return -2;
		}
		
		// Checks to see if the plot encompasses any other plots.
		
		if (!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		
		// still need to add OR the index in the array where the property was added successfully
		// Checks to see if the current plot overlaps any other plots.
		
		for (int index = 0; index < propertyAccumulator; index++)
		{
			if (properties[index].getPlot().overlaps(property.getPlot()))
			{
				return -4;
			}
		}
		// this stores a property object in each array element
		this.properties[propertyAccumulator] = new Property(property);
		
		return propertyAccumulator++;
	}

	/**
	 * This method uses several passed in values to create a new property
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return -1 if more properties than max properties, -2 if property object is null, 
	 * -3 if the new plot is not within the main plot (or you can say the new plot is not encompassed by the main plot)
	 * -4 if any properties already in the array are overlapping the new plot
	 * if none of these are true then a new property object is created in the array
	 * and the propertyAccumulator is incremented
	 */
	
	public int addProperty(String name, String city, double rent, String owner) 
	{	
		Property newProperty = new Property(name, city, rent, owner);
		
		// checks to make sure the array is not full
		if (propertyAccumulator >= this.MAX_PROPERTY)
		{
			return -1;
		}
		
		// checks if the property object is null
		
		if (Objects.isNull(newProperty))
		{
			return -2;
		}
		
		// Checks to see if the plot encompasses any other plots.
		
		if (!plot.encompasses(newProperty.getPlot()))
		{
			return -3;
		}
		
		// still need to add OR the index in the array where the property was added successfully
		// Checks to see if the current plot overlaps any other plots.
		
		for (int index = 0; index < propertyAccumulator; index++)
		{
			if (properties[index].getPlot().overlaps(newProperty.getPlot()))
			{
				return -4;
			}
		}
		
		// this stores a property object in each array element
		this.properties[propertyAccumulator] = newProperty;
		
		return propertyAccumulator++;
		
	}
	
	/**
	 * This method uses several passed in values to create a new property
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return -1 if more properties than max properties, -2 if property object is null, 
	 * -3 if the new plot is not within the main plot (or you can say the new plot is not encompassed by the main plot)
	 * -4 if any properties already in the array are overlapping the new plot
	 * if none of these are true then a new property object is created in the array
	 * and the propertyAccumulator is incremented
	 */

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		
		Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
		
		for (int index = 0; index < this.properties.length; index++)
		{
			// checks to make sure the array is not full
			if (propertyAccumulator >= this.MAX_PROPERTY)
			{
				return -1;
			}
			
			// checks if the property object is null
			
			if (Objects.isNull(newProperty))
			{
				return -2;
			}
			
			// Checks to see if the plot encompasses any other plots.
			
			if (!plot.encompasses(newProperty.getPlot()))
			{
				return -3;
			}
			
			// still need to add OR the index in the array where the property was added successfully
			// Checks to see if the current plot overlaps any other plots.
			
			for (index = 0; index < propertyAccumulator; index++)
			{
				if (properties[index].getPlot().overlaps(newProperty.getPlot()))
				{
					return -4;
				}
			}
			
		}
		
		// this stores a property object in each array element
		this.properties[propertyAccumulator] = newProperty;
		
		return propertyAccumulator++;
	}

	/**
	 * This method calculates the total rent of all the properties in the array and then they are summed together.
	 * @return totalRent
	 */
	
	public double totalRent() 
	{
		double totalRent = 0;
		
		for (int index = 0; index < this.properties.length; index++)
		{
			// check to make sure the array element is not empty
			if (this.properties[index] == null)
			{
				continue;
			}
			
			Property propGetter = this.properties[index];
			
			totalRent += propGetter.getRentAmount();
		}
		
		return totalRent;
	}

	/**
	 * This method gets the property from the properties array; 
	 * checks if it is null then if it is the highest rent stores it in highest variable
	 * @return highest rentAmount
	 */
	
	public double maxRentProp() 
	{
		
		double highest = 0;
		
		for (int index = 0; index < this.properties.length; index++)
		{
			Property propGetter = this.properties[index];
			
			if (propGetter == null)
			{
				continue;
			}
			if (propGetter.getRentAmount() > highest)
			{
				highest = propGetter.getRentAmount();
			}
		}
		
		// displayPropertyAtIndex(maxRentPropertyIndex());
		
		return highest;
	}

	/**
	 * This method will find the index for the property with the highest rental amount and save that int in highestIndex
	 * @return highestIndex
	 */
	
	private int maxRentPropertyIndex() 
	{
		if (properties == null || properties.length == 0) 
		{
			return -1;
		}
		
		int highestIndex = 0;
		
		for (int index = 1; index < this.properties.length; index++)
		{
			Property propGetter = this.properties[index];
			Property propGetter2 = this.properties[highestIndex];
			
			if (propGetter == null)
			{
				continue;
			}
			if (propGetter.getRentAmount() > (propGetter2.getRentAmount()))
			{
				highestIndex = index;
			}
		}
		
		return highestIndex;
	}
	
	/**
	 * This method is used to display the property that is at the index value.
	 * @param i
	 * @return str
	 */

	private String displayPropertyAtIndex(int i) 
	{
		String str = "";
		
		Property propGetter = this.properties[i];
		
		str += propGetter.toString();
		
		return str;
	}
	
	/**
	 * This method is the toString method that will store every properties information and display it
	 * @return str
	 */

	public String toString() 
	{
		String str = "";
		
		str += "\nList of properties for " + getName() + ", taxID: " + getTaxID() + "\n";
		str += "___________________________________________\n";
		
		for (int index = 0; index < this.properties.length; index++)
		{
			Property propGetter = this.properties[index];
			str += propGetter.toString();
			
		}
		
		str += "\n___________________________________________\n";
		str += "Total Management Fee: " + String.format("%.2f", (totalRent() / mgmFeePer));
		
		return str;
		
	}

}

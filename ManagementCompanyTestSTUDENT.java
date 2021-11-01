

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *  * Class: CMSC203 
 * Instructor: Dr. Grigoriy Grinberg
 * Description: This program creates a plot object
 * Due: 10/25/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * @author Matthew McNey
 *
 */

public class ManagementCompanyTestSTUDENT 
{
	
	ManagementCompany newManagement;
	
	Property prop1, prop2, prop3;
	
	private String propertyName = "Vacant Lot", city = "Metro City", owner = "Kingpin";
	private double rentAmount = 5060.50;
	private int x = 5, y = 5, depth = 2, width = 2;
	
	@Before
	public void setUp() throws Exception 
	{
		//student create a management company
		newManagement = new ManagementCompany("Matthew's Company", "474838392",3);
		//student add three properties, with plots, to mgmt co
		prop1 = new Property ("Bridgeport", "Maryland City", 4844.00, "Bryan Hilarious",3,4,2,2);
		prop2 = new Property ("Oakpointe", "Laurel", 4114, "Alfred Maxwell",6,8,2,2);
		prop3 = new Property ("Ashford", "Ellicott City", 4905, "Maxwell Taylor",2,1,2,2);
	}

	@After
	public void tearDown() 
	{
		//student set mgmt co to null  
		newManagement = null;
	}
	
	@Test
	public void testAddPropertyDefaultPlot() 
	{
		//student should add property with 4 args & default plot (0,0,1,1)
		prop1 = new Property (propertyName, city, rentAmount, owner, 0, 0, 1, 1);
		//student should add property with 8 args
		prop2 = new Property (propertyName, city, rentAmount, owner, x, y, depth, width);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		prop3 = new Property (propertyName, city, rentAmount, owner, 0, 0, 15, 15);
	}
 
	@Test
	public void testMaxRentProp() 
	{
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(newManagement.maxRentProp(),0,0);
	}

	@Test
	public void testTotalRent() 
	{
		//student should test if totalRent returns the total rent of properties
		assertEquals(newManagement.totalRent(),0,0);
	}

 }

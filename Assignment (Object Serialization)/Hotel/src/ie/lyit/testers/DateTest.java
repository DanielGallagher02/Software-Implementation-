package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.hotel.Date;

public class DateTest {
	private Date d1;

	@Before
	public void setUp() throws Exception {
		//Construct d1 with 1,1,1900
		d1 = new Date();
	}

	@Test
	public void testDate() {
		// Check d1’s day is 1
		assertEquals(1, d1.getDay());
		// Check d1’s month is 1, if it is not display appropriate message
		assertEquals("Month should be 1", 1, d1.getMonth());
		// Check d1’s year is 1900, if it is not display appropriate message
		assertEquals("Year should be 1900", 1900, d1.getYear());
	}

	@Test
	public void testDateIntIntInt() {
		//Construct d1 with 5,6,2020
		 d1=new Date(5,6,2020);
		 // Check d1's day is 5
		 assertEquals("Day should be 5.", d1.getDay(), 5);
		// Check d1's Month is 6
		 assertEquals("Month should be 6.", d1.getMonth(), 6);
		// Check d1's Year is 2020
		 assertEquals("Year should be 2020.", d1.getYear(), 2020);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDateIntIntIntException() {
		//Construct d1 with incorrect values 35,13,2020
		d1=new Date(35,13,2020);
		
	}

	@Test
	public void testToString() {
		// test toString() returns 1/1/1900
		assertEquals(d1.toString(), "1/1/1900");
	}

	@Test
	public void testSetDay() {
		// set day of d1 to 15
		d1.setDay(15);
		// Test that d1's day is 15
		assertTrue(d1.getDay() == 15);
	}

	@Test
	public void testSetMonth() {
		// setting month of d1's month to 4
		d1.setMonth(4);
		// Test that d1's month is 4
		assertTrue("d1's month should be 4.", d1.getMonth() == 4);
	}

	@Test
	public void testSetYear() {
		// set the year of d1 to 2022
		d1.setYear(2022);
		//Testing that d1's year is 2022
		assertTrue("d1's year should be 2022", d1.getYear() == 2022);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDayException() {
		//setDay() of d1 to 55
		d1.setDay(55);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMonthException() {
		//setMonth() of d1 to 13
		d1.setMonth(13);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetYearException() {
		//setYear() of d1 to 1800
		d1.setYear(1800);
		
	}

}

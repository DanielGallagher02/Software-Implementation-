package ie.lyit.testers;

import java.util.Scanner;

import ie.lyit.hotel.Date;

public class DateTester{
	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1);      

		int day=55, month=13, year=-200;
		boolean goodInput = false;
		Scanner keyboard = new Scanner(System.in);
		do {
			try {
			   	d1.setDay(day);
				d1.setMonth(month);
				d1.setYear(year);
				goodInput = true;
			}
			catch(IllegalArgumentException iae) {
				System.out.println("Invalid Date, re-enter");
				
				System.out.println("Enter Valid day [1-31]");
				day=keyboard.nextInt();
				System.out.println("Enter Valid day [1-12]");
				month=keyboard.nextInt();
				System.out.println("Enter Valid day [>1900]");
				year=keyboard.nextInt();
			}
		}while(!goodInput);	
			
		System.out.println(d1);
      
		Date d2 = new Date(62, 15, 10);
		System.out.println(d2);
      
		if(d1.equals(d2))
			System.out.println("Date's are equal.");
		else
			System.out.println("Date's are not equal.");
   }
}


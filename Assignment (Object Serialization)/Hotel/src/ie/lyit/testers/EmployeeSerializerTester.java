
/* Name: Daniel Gallagher
 * L00158616
 * Assignment: Object Serialization (40%)
 * Due Date: 02/12/2022
 */

package ie.lyit.testers;

import ie.lyit.serialize.EmployeeSerializer;

import java.util.Scanner;

public class EmployeeSerializerTester {

	public static void main(String[] args) {
		EmployeeSerializer employeeSerializer = new EmployeeSerializer();
		
		int option = 0;
		
		//Read the Arraylist from the file in employee
		//Deserialize the Arraylist
		employeeSerializer.deserializeEmployees();
		
		// a do while loop that display the Menu until the user chooses to quit
		do {
			//Main Menu 
			System.out.println("\t\tEmployee MENU\n");
		    System.out.println("\t1. Add");
			System.out.println("\t2. List");
			System.out.println("\t3. View");
			System.out.println("\t4. Edit");
			System.out.println("\t5. Delete");
			System.out.println("\t6. Quit");	
			
			//Taking in the users input 
			Scanner kbInt = new Scanner(System.in);
	    	System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
	     	option=kbInt.nextInt();
	     	
	     	//Options that the user will pick 
	     	switch(option){
			   case 1:employeeSerializer.add();break;
			   case 2:employeeSerializer.list();break;
			   case 3:employeeSerializer.view();break;
			   case 4:employeeSerializer.edit();break;
			   case 5:employeeSerializer.delete();break;
			   case 6:break;				
			   default:System.out.println("INVALID OPTION...");
	     	}   
			
		}while(option != 6);
		
		//Write the employees Arraylist to File after the user 
		//has exited the menu
		employeeSerializer.serializeEmployees();
		
	}

}

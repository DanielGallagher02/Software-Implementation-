
/* Name: Daniel Gallagher
 * L00158616
 * Assignment: Object Serialization (40%)
 * Due Date: 02/12/2022
 */

package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.lyit.hotel.Employee;

public class EmployeeSerializer {
	
	//An ArrayList of Employees
	private ArrayList<Employee> employees;
	
	final String FILENAME = "employees.bin";
	
	// Default Constructor
	public EmployeeSerializer(){
		// Construct Employees ArrayList
		employees = new ArrayList<Employee>();
	}
	
	//add() - Add Option
	//will read one Employee from the user and it will add it 
	//to the Arraylist called employees
	public void add() {
		//Create Employee Object
		Employee employee = new Employee();
		//Read its Details
		employee.read();
		//And adding it to the Employees ArrayList
		employees.add(employee);
	}	
	
	//list() - List Option
	//will list all stored Employees in employees
	public void list() {
		String employeesToList="";
		
		//For every Employee objects in employees
		for(Employee tmpEmployee : employees) {
			//adding it to employeesToList and 
			employeesToList+=tmpEmployee;
			//adding a newline
			employeesToList+="\n";
		}
		
		//Displaying employeesToList in a messageDialog to the user
		JOptionPane.showMessageDialog(null, employeesToList);
		
	}
	
	//view() - view Option
	//will display the required Employee on the screen and returns it
	//or else null if it isnt found
	public Employee view() {
		String numberAsString="";
		int employeeToView=0;
		
		try {
			numberAsString = JOptionPane.showInputDialog(null, "Enter Employee Number:");
			
			//try and convert numberAsString to an Integer
			employeeToView = Integer.parseInt(numberAsString);
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, numberAsString + "is not a valid number.");
		}
		
		//for every Employee object in employees
		for(Employee tmpEmployee: employees) {
			//if its number equals the number of employeeToView
			if(tmpEmployee.getNumber() == employeeToView) {
				//Display it 
				JOptionPane.showMessageDialog(null, tmpEmployee);
				//return it
				return tmpEmployee;
			}
		}
		//if we reach here the Employee wasnt found so we return null
		return null;
		
	}
	
	//edit() - Edit Option 
	//will edit the required Employee from employee
	public void edit() {
		//Calling view() to find, display and return the employee to edit
		Employee tempEmployee = view();
		
		//check if the employee was found
		if(tempEmployee != null) {
			//getting the index of it
			int index = employees.indexOf(tempEmployee);
			//read in a new employee 
			tempEmployee.read();
			//reset the object in employees
			employees.set(index, tempEmployee);
		}
		//else the employee wasnt found
		else {
			System.out.println("ERROR - Cannot Edit the Employee");
		}
		
	}
	
	//delete() - Delete Option
	//will delete the required Employee from employee
	public void delete() {
		//Calling view() to find, display and return the employee to delete
		Employee tempEmployee = view();
		
		//check if the employee is found 
		if(tempEmployee != null) {
			//if it is remove it from employees
			employees.remove(tempEmployee);
			
		}
		//else the employee is not found 
		else {
			//display an error message to user
			System.out.println("ERROR - Cannot Delete Employee");
		}
		
	}
	
	//serializeEmployees() - will serialize the employees Arraylist when called
	//it will write the Arraylist to the file
	public void serializeEmployees() {
		ObjectOutputStream os = null;
		
		try {
			//Serializing the Arraylist
			//Making a FileOutputStream that connects to employees.bin
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			//Chain a ObjectOutputStream to it
			os = new ObjectOutputStream(fileStream);
			//Writing employees to the to the ObjectOutputStream
			os.writeObject(employees);
			
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE) {
			System.out.println("Cannot write to " + FILENAME + ".");
			
		}
		finally {
				try {
					//Closing the ObjectOutputStream
					os.close();
				}
				catch(IOException ioE) {
					System.out.println(ioE.getMessage());
				}
		}
		
	}
	
	//deserializeEmployees() - will deserialize the employees Arraylist when called
	//it will restore the Arraylist from the file
	public void deserializeEmployees() {
		ObjectInputStream is = null;
		
		try {
			//Deserializing the Arraylist
			//Making a FileInputStream that connects to employees.bin
			FileInputStream fileStream = new FileInputStream(FILENAME);
			//Chain a ObjectInputStream to it
			is = new ObjectInputStream(fileStream);
			//Reading the Employee ArrayList from the ObjectInputStream
			employees = (ArrayList<Employee>)is.readObject();
			
			//Checking to make sure that employees arrayList is not empty
			if(employees.size() > 0) {
				//Getting the highest number of EmployeeNumber in the arraylist
				int num = employees.get(employees.size() - 1).getNumber();
				//setting the next EmployeeNumber and adding 1 to it
				Employee.setNextNum(num + 1);
			}
			
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store employees");
		}
		catch(IOException ioE) {
			System.out.println("Cannot read from " + FILENAME + ".");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
				try {
						//Closing the ObjectIntputStream
						is.close();
				}
				catch(IOException ioE) {
					System.out.println(ioE.getMessage());
				}
		}
		
	}
	
}

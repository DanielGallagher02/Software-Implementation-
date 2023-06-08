package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.Date;
import ie.lyit.hotel.Employee;
import ie.lyit.hotel.Name;

public class EmployeeTester {
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Employee> person = new ArrayList<Employee>();
		
		Name name = new Name("Ms", "Faye", "McGuire");
		Employee e1 = new Employee(name, "087 1234567",
								   new Date(7, 12, 2000),
								   new Date(12, 10, 2020),
								   24000.00);

	
		name = new Name("Mr", "Ben", "Carson");
		Employee e2 = new Employee(name, "086 1234567",
							   new Date(20, 10, 1980),
							   new Date(10, 10, 2012),
							   42000.00);


		name = new Name("Mr", "Mark", "Logan");
		Employee e3 = new Employee(name, "087 9876543",
						   new Date(1, 1, 1980),
						   new Date(2, 8, 2012),
						   28000.00);
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		System.out.println("LIST OF EMPLOYEES");
		for(Employee employee:employees)
			System.out.println(employee);
		
		System.out.println("");
		System.out.println("LIST OF EMPLOYEES AFTER INCREMENT");
		for(Employee employee:employees) {
			if(employee.getSalary() < 30000)
				employee.incrementSalary(1000);
			System.out.println(employee);
		}	
		
		//
		System.out.println("");
		System.out.println("EMPLOYEES TAKE HOME PAY");
		for(Employee employee:employees) {
			if(employee.getSalary() < 35000)
				System.out.println(employee.getNumber() + "\t" + 
								   employee.getName() 	+ "\t" + 
								   "€" + employee.calculatePay(20));
			else
				System.out.println(employee.getNumber() + "\t" + 
						   		   employee.getName() 	+ "\t" + 
						   		   "€" + employee.calculatePay(40));
		}
	}	
}
	
	


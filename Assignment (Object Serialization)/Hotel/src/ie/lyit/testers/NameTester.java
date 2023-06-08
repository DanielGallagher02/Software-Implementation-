package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.Name;

public class NameTester {

	public static void main(String[] args) {
		Name n1 = new Name();
		System.out.println(n1);
		
		//Set n1's name
		n1.setTitle("Mr");
		n1.setFirstName("Homer");
		n1.setSurname("Simpson");
		System.out.println(n1);
		
		//Create a Name object called personB
		Name personB = new Name("Mrs", "Marge", "Simpson");
		System.out.println(personB);
		
		if(n1.equals(personB))
			System.out.println(n1 + " is the same as " + personB);
		else
			System.out.println(n1 + " is not the same as " + personB);
		
		//Testing isFemale method
		if(personB.isFemale())
			System.out.println(personB + " is female.");
		else
			System.out.println(personB + " is not female.");
		
		//Creating an arrayList called names which is capable of
		//storing a list of name objects. 
		//Adding 3 name objects and printing out the whole list
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(new Name("Mr", "Bart", "Simpson"));
		names.add(n1);
		names.add(personB);
		names.trimToSize( );
		
		//Printing out the arrayList
		for(Name tempName:names)
			System.out.println(tempName);
		

	}

}

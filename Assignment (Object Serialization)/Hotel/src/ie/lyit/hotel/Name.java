package ie.lyit.hotel;

public class Name {
	private String title;
	private String firstName;
	private String surname;
	
	//Constructors to initializes the Instance Variables
	//Default constructor
	// => Called when a Name object is created as follows -
	//	  Name n1 = new Name();
	public Name() {
		title = "";
		firstName = "";
		surname = "";
	}
	// Initialization Constructor
	// ==> Called when a Name object is created as follows -
	//	   Name n2 = new Name ("Mr","Joe","Cole");
	public Name(String t, String fN, String sN) {
		title = t;
		firstName = fN;
		surname = sN;
	}
	
	//toString() Method
	// ==> Called when a String of the class is used, e.g -
	//	   System.out.print(n1);
	//	   or System.out.print(n1.toString());
	public String toString() {
		return title + " " + firstName + " " + surname;
		
	}
	
	//equals() method
	// ==> Called when comparing an object with another object, e.g -
	//	  if(n1.equals(n2))
	@Override
	public boolean equals(Object obj) {
		Name nObject;
		if (obj instanceof Name)
			nObject = (Name)obj;
		else
			return false;
		
		return this.title.equals(nObject.title)
				&& this.firstName.equals(nObject.firstName)
				&& this.surname.equals(nObject.surname);
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public boolean isFemale() {
		if(title.equalsIgnoreCase("Miss") ||
		   title.equalsIgnoreCase("Ms")	||
		   title.equalsIgnoreCase("Mrs"))
			return true;
		else
			return false;
	}
}

package ie.lyit.testers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.lyit.hotel.CreditCard;
import ie.lyit.hotel.Date;
import ie.lyit.hotel.Guest;
import ie.lyit.hotel.Name;

public class ExceptionHandlerDemo {

	public static void main(String[] args) {
		//Creating an arrayList of guest objects called hotelGuests
		//and adding 4 guests to this arrayList
		ArrayList<Guest> hotelGuests = new ArrayList<Guest>();
		
		// Create a Guest object called g1 with initial values
		Name n1=new Name("Mr", "Homer", "Simpson");
		CreditCard card=new CreditCard(1111222233334444L,new Date(31,12,2027),111);
		Guest g1 = new Guest(n1, "087 1234567", "homer.simpson@atu.ie", card);	

		// Create a Guest object called g2 with initial values
		Name n2=new Name("Mrs", "Marge", "Simpson");
		card=new CreditCard(5555666677778888L,new Date(31,12,2024),222);
		Guest g2 = new Guest(n2, "086 1234567", "marge.simpson@atu.ie", card);	
				
		// Create a Guest object called g3 with initial values
		Name n3=new Name("Miss", "Lisa", "Simpson");
		card=new CreditCard(9999888877776666L,new Date(31,3,2024),333);
		Guest g3 = new Guest(n3, "087 9876543", "lisa.simpson@atu.ie", card);
		
		// Create a Guest object called g3 with initial values
		Name n4=new Name("Miss", "Lisa", "Simpson");
		card=new CreditCard(9999888877776666L,new Date(31,3,2024),333);
		Guest g4 = new Guest(n4, "087 9876543", "lisa.simpson@atu.ie", card);
		
		hotelGuests.add(g1);
		hotelGuests.add(g2);
		hotelGuests.add(g3);
		hotelGuests.add(g4);
		
		String guestToViewAsString="";
		boolean goodInput = false;
		
		//I'm aware that this code can throw Exception(s)
		//and i'm going to handle them if they occur.
		do {
			try {
				//Asking the user to enter the guest number they wish to view
				JOptionPane.showInputDialog(null,
						 "Enter Guest to View ("+1+" to "+hotelGuests.size()+")");
			
				int guestToViewAsInt = Integer.parseInt(guestToViewAsString);
				JOptionPane.showMessageDialog(null, hotelGuests.get(guestToViewAsInt-1));
			}
			catch(NumberFormatException nfe){
				JOptionPane.showInputDialog(null, guestToViewAsString +
											"is not a valid number, please re-enter.");
						 
			}
			catch(IndexOutOfBoundsException ioe){
				JOptionPane.showInputDialog(null, 
						"you must choose a guest from (1 to " + hotelGuests.size()
						+ ")" + ", please re-enter");
			
			}
		} while (!goodInput);
		
		
		
		

	}

}

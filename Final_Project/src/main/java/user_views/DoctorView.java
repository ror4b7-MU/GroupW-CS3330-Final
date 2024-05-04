package user_views;

import java.util.Scanner;

public class DoctorView extends UserView{

	@Override
	public boolean createNewUser() {
		return false;
	}

	@Override
	protected void displayOptions() {
		System.out.println("Welcome! What would you like to do today?");
		System.out.println("Enter 1 to view your upcoming schedule");
		System.out.println("Enter 2 to book a new appointement");
		System.out.println("Enter 3 to cancel or reschedule an existing appointment");
		System.out.println("Enter 4 assign or remove a patients medication");
		System.out.println("Enter 5 to logout");
	}

	@Override
	protected boolean executeSelectedOption(int optionNumber) {
		switch (optionNumber) {
	    case 1:
	    	// this.viewSchedule();
	        break;
	    case 2:
	    	// this.bookAppointment();
	        break;
	    case 3:
	    	// this.cancelOrReschedulApp();
	    	break;
	    case 4:
	    	// this.assignOrRemovePatientMed();
	    	break;
	    case 5: 
	    	// this.logout
	    default:
	    	return false;
		}
		return true;
	}
	 
	// scans for user input and then calls the appropriate officeManager function
	private boolean assignOrRemovePatientMed() {
		return false;
	}
	
	

}

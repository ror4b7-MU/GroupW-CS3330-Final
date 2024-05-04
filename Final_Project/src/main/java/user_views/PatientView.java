package user_views;

import office_manager.OfficeManager;

public class PatientView extends UserView {

	// implements the abstract method from userview
	// basically just a wrapper for addNewPatient
	@Override
	protected boolean createNewUser() {
		OfficeManager officeManager = getOfficeManager();
		// addNewPatient isnt implemented yet. it should be implemented in OfficeManager
		if(officeManager.addNewPatient()) {
			return true;
		}
		return false;
	}

	@Override
	protected void displayOptions() {
		System.out.println("Welcome! What would you like to do today?");
		System.out.println("Enter 1 to view your upcoming schedule");
		System.out.println("Enter 2 to book a new appointement");
		System.out.println("Enter 3 to cancel or reschedule an existing appointment");
		System.out.println("Enter 4 to logout");
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
	    	// this.logout
	    default:
	    	return false;
		}
		return true;
	}

	
}

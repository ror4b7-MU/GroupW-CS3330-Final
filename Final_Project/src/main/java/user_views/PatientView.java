package user_views;

import office_manager.OfficeManager;
import records.Appointment;
import users.Doctor;
import users.PatientUser;
//import users.User;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Random;
//import java.util.Scanner;
import java.util.Calendar;

public class PatientView extends UserView {

	
	// implements the abstract method from userview
	// basically just a wrapper for addNewPatient
	// and obviously provides a way for the user to input a new userName
	@Override
	public boolean createNewUser() {
		try {
	    	// scan for user inputs 
	    	System.out.print("Please enter a new Username: ");
	    	String userName = scanner.nextLine();
	    	System.out.print("Please enter your first name: ");
	    	String name = scanner.nextLine();
	    	System.out.print("Please enter you surname: ");
	    	String surname = scanner.nextLine();
	    	System.out.print("Please enter your birth date: ");
	    	String birthDate = scanner.nextLine();
	    	OfficeManager officeManager = getOfficeManager();
	    	// addNewPatient isnt implemented yet. it should be implemented in OfficeManager
	    	//System.out.println("officeManager patients array size" + officeManager.getPatients().size());
	    	if(officeManager.addNewPatient(userName, name, surname, birthDate)) { 
				//System.out.println("officeManager patients array size" + officeManager.getPatients().size());
				return true;
			}
			else {
				System.out.println("Failed to create user!");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

		// displays the patients options, could be more if we need more
		@Override
		protected void displayOptions() {
			System.out.print('\n');
			System.out.println("Welcome! What would you like to do today?");
			System.out.println("Enter 1 to view your schedule");
			System.out.println("Enter 2 to book an appointment");
			System.out.println("Enter 3 to cancel or reschedule an existing appointment");
			System.out.println("Enter 4 change your assigned doctor");
			System.out.println("Enter 5 to logout");
		}

		// executes the option that the user selects. again the userView functions that will be called 
		// basically just provide an interface between the user and the underlying officeManager functions
		@Override
		protected boolean executeSelectedOption(int optionNumber) {
			switch (optionNumber) {
		    case 1:
		    	this.viewSchedule();
		        break;
		    case 2:
		    	this.bookAppointment();
		        break;
		    case 3:
		    	this.cancelOrReschedulApp();
		    	break;
		    case 4:
		    	this.alterDoctor();
		    	break;
			case 5:
				this.logout();
				break;
		    default:
		    	return false;
			}
			return true;
		}


	private boolean alterDoctor() {
		Doctor doc = UserInput.getValidDoctor("Please enter the new doctor you want (username)", getOfficeManager());
		PatientUser pat = (PatientUser) getUser(); 
		pat.setGCP(doc);
		return true; 
	}

	@Override
	protected void viewSchedule() {
		OfficeManager instance = this.getOfficeManager();
		int apptNo = 0;
		for(Appointment appt : instance.getAppointments()) {
			if(appt.getPatient()==(PatientUser)user) {
				apptNo+=1;
			}
		}
		System.out.println("\nYou have " + apptNo + " appointment(s).\n");
		instance.viewPatientAppointments((PatientUser)user);

		if(apptNo==0) {
			System.out.println("\nSorry, but we have no appointments on file for you at this time.");
		}

		
	}

	@Override
	protected boolean bookAppointment() {
		PatientUser pat = (PatientUser) this.getUser(); 
		Calendar start = UserInput.getValidDate("Enter Start: YYYYY-MM-DD-HH-mm of requested appointment"); 
		Calendar end  = UserInput.getValidDate("Enter End: YYYY-MM-DD-HH-mm of requested appointment");
		Doctor doc = (Doctor) UserInput.getValidUser("Please enter your doctor(username)", getOfficeManager()); 
		String reason = UserInput.getString("Enter your reason for the visit"); 


		if (getOfficeManager().scheduleAppointment(pat, doc, start.getTime(), end.getTime(), reason) == false)
		{
			System.out.print("Doctor is not availible at your requested time"); 
			executeSelectedOption(2); 
		} 

		return false;
	}

}

package user_views;

import java.util.Calendar;

import office_manager.OfficeManager;
import records.Appointment;
import records.Prescription;
import users.Doctor;
// import users.Doctor;
import users.PatientUser;
import users.Specialization;
import users.User;

public class DoctorView extends UserView{

	// since i think we are having a fixed number of doctors this just returns false
	@Override
	public boolean createNewUser() {
		return false;
	}

	// this isn't everything that a doctor can do i think there is some more stuff on the doc we can add 
	// the point of the function is just to display to the user (doctor in this case) the tasks they can perform
	@Override
	protected void displayOptions() {
		System.out.print('\n');
		System.out.println("Welcome! What would you like to do today?");
		System.out.println("Enter 1 to view your upcoming schedule");
		System.out.println("Enter 2 to refer a patient to another department");
		System.out.println("Enter 3 to cancel or reschedule an existing appointment");
		System.out.println("Enter 4 assign or remove a patients medication");
		System.out.println("Enter 5 to logout");
		// potentially more here
	}

		// this function will execute the selected option by calling its UserView method which
		// in turn will provide a way for the user to supply inputs and then it will call the appropriate 
		// officeManager function. 
	@Override
	protected boolean executeSelectedOption(int optionNumber) {
		switch (optionNumber) {
	    case 1:
	    	this.viewSchedule();
	        break;
	    case 2:
	    	this.referAPatient();
	        break;
	    case 3:
		   	this.cancelOrReschedulApp();
		   	break;
		case 4:
		 	this.assignOrRemovePatientMed();
		    break;
		case 5: 
		    this.logout();
		default:
		  	return false;
		}
		return true;
	}
		 
	private boolean referAPatient() {
		try {
			OfficeManager manager = this.getOfficeManager();
			System.out.print("Please specify the username of the patient you wish to refer: ");
			String userName = this.scanner.nextLine();
			PatientUser patientToRefer = (PatientUser) manager.getUserByUserName(userName);
			if(patientToRefer == null) {
				System.out.println("User not found!");
				return false;
			}
			System.out.println("Please specify the specialization you wish to refer to by entering the corresponding number: ");
			System.out.println("1: for General Care");
			System.out.println("2: for Cardiologist");
			System.out.println("3: for Podiatrist");
			System.out.println("4: for Oncologist");
			int specializationNum = scanner.nextInt();
			Specialization spec = null;
			switch (specializationNum) {
			    case 1:
			    	spec = Specialization.GENERAL_CARE_PRACTITIONER;
			        break;
			    case 2:
			    	spec = Specialization.CARDIOLOGIST;
			        break;
			    case 3:
			    	spec = Specialization.PODIATRIST;
				   	break;
				case 4:
					spec = Specialization.ONCOLOGIST;
				    break;
				default:
				  	return false;
			}
			if (manager.referPatient(patientToRefer, spec)) {
				System.out.println("Patient refered successfully");
				return true;
			}
			else {
				return false;
			}
		} 
		catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        return false;
		}
    
	}

	// scans for user input and then calls the appropriate officeManager function
	private boolean assignOrRemovePatientMed() {
		System.out.print("Type A to assign a new medication and R to remove: ");
		String AOrR = this.scanner.nextLine();
		OfficeManager manager = this.getOfficeManager();
		String userName = UserInput.getString("Please enter the userName of the patient: ");
		if(AOrR.equalsIgnoreCase("A")) {
			System.out.print("Please enter the medication to assign: ");
			Prescription p = Prescription.valueOf(this.scanner.nextLine());
			if(manager.assignPatientMedication(userName, p)) {
				System.out.println("Medication Assigned!");
				return true;
			}
		}
		else if (AOrR.equalsIgnoreCase("R")) {
			System.out.print("Please enter the medication to remove: ");
			Prescription p = Prescription.valueOf(this.scanner.nextLine());
			if(manager.removePatientMedication(userName, p)) {
				System.out.println("Medication Removed!");
				return true;
			}
		}
		else {
			System.out.println("Invalid Input");
			return false;
		}
		System.out.println("Error occured while trying to assign or remove Med!");
		return false;
		
	}
	
	// this function first displays the users appointments for today and then the rest of there upcoming appointments
	@Override
	protected void viewSchedule() {
		System.out.println("Todays Appointments");
		this.getOfficeManager().viewTodaysSchedule((Doctor) this.getUser()); // display todays appointments
		System.out.println("All upcoming Appointments");
		this.getOfficeManager().viewUserAppointments(this.getUser()); // display all appointments
	}

	@Override
	protected boolean bookAppointment() {
		// TODO Auto-generated method stub
		return false;
	}
	
}



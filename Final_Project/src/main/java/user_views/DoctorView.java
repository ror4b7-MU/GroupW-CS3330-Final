package user_views;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

import office_manager.OfficeManager;
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
		System.out.println("Welcome! What would you like to do today?");
		System.out.println("Enter 1 to view your upcoming schedule");
		System.out.println("Enter 2 to book a new appointement");
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
	
	public DoctorView() {
		//need constructor, but need userview constructor first
	}
    
    public boolean referPatient (PatientUser patient, Specialization spec) {
        // ArrayList<PatientUser> patList = manager.getPatients();
        // ArrayList<Doctor> docList = manager.getDoctors();

        spec.addReferral(patient);
        List<PatientUser> refList = spec.getReferrals();
        for(PatientUser ref : refList) {
            if(ref==patient) {
                return true;
            }
        }
        return false;
    }

}

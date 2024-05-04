

import java.util.Date;

import javax.print.Doc;

import records.Appointment;
import users.User;
import users.Doctor;
import users.PatientUser;
import users.Specialization;
//import user_views.DoctorView;
//import user_views.PatientView;
//import user_views.UserView;
import user_views.*;

public class Main 
{
	public static void main(String []args)
    {
//        Doctor doc = new Doctor("Bob", "Joel", "10/10", Specialization.CARDIOLOGIST); 
//        Doctor doc2 = new Doctor("Layla", "Smith", "10/10", Specialization.CARDIOLOGIST);
//        
//    
//        PatientUser pat1 = new PatientUser("Smith", "Name", "10/10", "n.smith"); 
//
//        PatientUser pat2 = new PatientUser("Bob", "Sur", "10/10", "s.bob"); 
//
//        Date start = new Date(2024, 3, 2, 3, 10); 
//        Date end = new Date(2024, 3, 2, 3, 30); 
//
//        Date start2 = new Date(2024, 3, 2, 3, 15); 
//        Date end2 = new Date(2024, 3, 2, 3, 40); 
//
//
//        
//
//
//        //Return True
//        System.out.println(doc.scheduleAppointment(pat1, start, end));
//
//
//        //Should return False
//        System.out.println(doc.scheduleAppointment(pat2, start2, end2));
//
//        //Should return True
//        System.out.println(doc2.scheduleAppointment(pat2, start2, end2));
		
		//Setup
		// I think the system should be setup with a few doctors 
		// Should probably have them setup initially here in main
		// could have some placeholder Patients and appointments as well
		// need to instantiate the OfficeManager here

        // Main program will start here by using scanner to ask the user if they are a Doctor or Patient
        // Based on their response a new instance of PatientView or DoctorView will be initialized
        // Then the UserView.Login method will be called wich will ask for the users name or ID 
        // login will set the identifying variable in the Userview class Probably userName
        // might be a good idea to add ID or UserName to the patient class to uniquely identify.
        // it will also authenticate the user by making sure they exist in the OfficeManager
        // UserView.displayOptions will be called which will print a list of things that the user can do
        // Might have an enum to represent the different options, or could just number them.
        // Could have a switch statement here in main or in the UserView to that would call the appropriate function
        // based on the user response
		
		// Im thinking this could maybe run in a loop that always loops back to the displayOptions part, 
		// one of the options could be to logout. 
		
		PatientView newPatientView = new PatientView();
		
		newPatientView.login();
		

    

    }
}



import java.util.Date;
import java.util.Scanner;

import javax.print.Doc;

import office_manager.OfficeManager;
import records.Appointment;
import records.Prescription;
import users.Doctor;
import users.PatientUser;
import users.Specialization;
import users.User;
import user_views.*;

public class Main 
{
	public static void main(String []args)
    {
//		
//		
//		OfficeManager manager = OfficeManager.getInstance();
//		
//        Doctor doc1 = new Doctor("Bob", "Joel", "10/10", Specialization.CARDIOLOGIST); 
//        Doctor doc2 = new Doctor("Layla", "Smith", "10/10", Specialization.CARDIOLOGIST);
///*
//* //adds doctors to singleton doc list 
//* 		if(!(manager.addDoctor(doc))) {
//* 			System.out.println("Failed to add"); }; if(!(manager.addDoctor(doc2))) {
//* 			System.out.println("Failed to add"); 
//* 		}
//*/
//        PatientUser pat1 = new PatientUser("Smith", "Name", "10/10", "n.smith"); 
//
//        PatientUser pat2 = new PatientUser("Bob", "Sur", "10/10", "s.bob"); 
//
//        Date start = new Date(2024, 3, 2, 3, 10); 
//        Date end = new Date(2024, 3, 2, 3, 30); 
//
//        Date start2 = new Date(2024, 3, 2, 3, 15); 
//        Date end2 = new Date(2024, 3, 2, 3, 40); 

/****Rachel method tests****

/////Return Doc types/////


        Cycles through cardiologists in doc list        
        Doctor cardio1 = manager.returnSpecializedDoc(Specialization.PODIATRIST);
        Doctor cardio2 = manager.returnSpecializedDoc(Specialization.CARDIOLOGIST);
        Doctor cardio3 = manager.returnSpecializedDoc(Specialization.CARDIOLOGIST);
        
        System.out.println(cardio1.toString());
        System.out.println(cardio2.toString());
        System.out.println(cardio3.toString());
        

/////Assign & Delete Patient Medications/////
        
        //Empty patient 1 medlist
        System.out.println(pat1.getMedList());
      
        //Doc 1 assigns albuterol to patient 1
        doc1.assignPatientMedication(pat1, Prescription.ALBUTEROL);
        
        //List prints albuterol
        System.out.println(pat1.getMedList());
        
        //Doc 2 assigns ibuprofen to patient 1
        doc2.assignPatientMedication(pat1, Prescription.IBUPROFEN);
        
        
        //Doc 2 tries to assign iburofen again but it doesn't add a double
        doc2.assignPatientMedication(pat1, Prescription.IBUPROFEN);
        
        
        //Doc 1 tries to assign iburofen but it doesn't add a double since it's already in the list
        doc1.assignPatientMedication(pat1, Prescription.IBUPROFEN);
        
        //List prints albuterol and ibuprofen
        System.out.println(pat1.getMedList());
        
        //Doc 2 removes albuterol from patient 1
        doc2.deletePatientMedication(pat1, Prescription.ALBUTEROL);
        
        //No issues upon attempt to remove non-existent med
        doc1.deletePatientMedication(pat1, Prescription.ALBUTEROL);
        
        //List prints Ibuprofen
        System.out.println(pat1.getMedList());
        
        //Doc 1 removes ibuprofen from patient 1
        doc1.deletePatientMedication(pat1, Prescription.IBUPROFEN);
        
        //Empty patient1 medlist
        System.out.println(pat1.getMedList());

****End Rachel method tests****/
        
        
        //Return True
/*        System.out.println(doc.scheduleAppointment(pat1, start, end));


        //Should return False
        System.out.println(doc.scheduleAppointment(pat2, start2, end2));

        //Should return True
        System.out.println(doc2.scheduleAppointment(pat2, start2, end2));*/

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

		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Indicate (D) for doctor login or (P) for patient: ");
		String DoctorOrPatient = scanner.nextLine(); 
		UserView newUserView = null;
		if(DoctorOrPatient.toLowerCase().equals("d")) {
			newUserView = new DoctorView();
		}
		else if (DoctorOrPatient.toLowerCase().equals("p")) {
			newUserView = new PatientView();
		}
		
//		PatientView newUserView = new PatientView();
		
		// attempt to login
		if(newUserView.login()) {
			
			// this loop will run until the user decides to logout
			while(newUserView.getLoggedInStatus() == true) {
				newUserView.runUserEnvironment();
			}
			System.out.println("Successfully Logged Out! Run the program again to log back in");
		}
		else {
			System.out.println("Failed to login");
		}
		

		
		scanner.close();
    

    }

}

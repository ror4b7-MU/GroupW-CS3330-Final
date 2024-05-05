

import java.util.Date;

import javax.print.Doc;

import office_manager.OfficeManager;
import records.Appointment;
import records.Prescription;
import users.Doctor;
import users.PatientUser;
import users.Specialization;
import users.User;

public class Main 
{
	public static void main(String []args)
    {
		
		
		OfficeManager manager = OfficeManager.getInstance();
		
        Doctor doc1 = new Doctor("Bob", "Joel", "10/10", Specialization.CARDIOLOGIST); 
        Doctor doc2 = new Doctor("Layla", "Smith", "10/10", Specialization.CARDIOLOGIST);
/*
* //adds doctors to singleton doc list 
* 		if(!(manager.addDoctor(doc))) {
* 			System.out.println("Failed to add"); }; if(!(manager.addDoctor(doc2))) {
* 			System.out.println("Failed to add"); 
* 		}
*/
        PatientUser pat1 = new PatientUser("Smith", "Name", "10/10", "n.smith"); 

        PatientUser pat2 = new PatientUser("Bob", "Sur", "10/10", "s.bob"); 

        Date start = new Date(2024, 3, 2, 3, 10); 
        Date end = new Date(2024, 3, 2, 3, 30); 

        Date start2 = new Date(2024, 3, 2, 3, 15); 
        Date end2 = new Date(2024, 3, 2, 3, 40); 

//****Rachel method tests****

/////Return Doc types/////


//Cycles through cardiologists in doc list        
//        Doctor cardio1 = manager.returnSpecializedDoc(Specialization.PODIATRIST);
//        Doctor cardio2 = manager.returnSpecializedDoc(Specialization.CARDIOLOGIST);
//        Doctor cardio3 = manager.returnSpecializedDoc(Specialization.CARDIOLOGIST);
//        
//        System.out.println(cardio1.toString());
//        System.out.println(cardio2.toString());
//        System.out.println(cardio3.toString());
        

/////Assign & Delete Patient Medications/////
      
        //Doc 1 assigns albuterol and ibuprofen to patient 1
        doc1.assignPatientMedication(pat1, Prescription.ALBUTEROL);
        doc1.assignPatientMedication(pat1, Prescription.IBUPROFEN);
        
        //List prints albuterol and ibuprofen
        System.out.println(pat1.getMedList());
        
        


//****End Rachel method tests****/
        
        
        //Return True
/*        System.out.println(doc.scheduleAppointment(pat1, start, end));


        //Should return False
        System.out.println(doc.scheduleAppointment(pat2, start2, end2));

        //Should return True
        System.out.println(doc2.scheduleAppointment(pat2, start2, end2));*/

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

    

    }

}



//import java.util.Date;
import java.util.Scanner;


import user_views.*;

public class Main {
	public static void main(String []args)
    {

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
		for(int i = 0; i<100; i++) {
		System.out.println("Welcome to the doctors office!");
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
			System.out.println("Successfully Logged Out!\n");
		}
		else {
			System.out.println("Failed to login");
		}
		
    	}
		
		scanner.close();
    

    }

}

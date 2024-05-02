package office_manager;

import java.util.ArrayList;
// import java.util.Observable;

import records.*;
import users.*;

// Singleton Class
public class OfficeManager {
    // Private static instance of the class
    private static OfficeManager instance;

    // Private ArrayLists for Appointments, Patients, and Doctors
    private ArrayList<Appointment> appointments;
    private ArrayList<PatientUser> patients;
    private ArrayList<Doctor> doctors;
    // was thinking again and i guess we could just have an ArrayList of Users?
    // instead of doctors and patients
    // need to make it so that Doctor class extends User
    // private ArrayList<User> Users; ???
    // would simplify some of the following code

    // Private constructor to prevent instantiation from outside the class
    private OfficeManager() {
        appointments = new ArrayList<>();
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    // Public static method to access the instance
    public static OfficeManager getInstance() {
        if (instance == null) {
            // If instance is null, initialize it
            instance = new OfficeManager();
        }
        return instance;
    }
    
    // simple functions to search the patient and doctor arrayLists by userName
    // returns null if user not found or invalid params
    public PatientUser getPatientByUserName(String userName) {
    	if(userName == null) {
    		return null;
    	}
    	else {
    		for(PatientUser patient : this.patients) {
    			if(patient.getUserName() == userName) {
    				return patient;
    			}
    		}
  
    	}
    	return null;
    }
    // would be another one for doctors but doctor isn't a subclass of user yet
    
    // instead of having different functions for searching the doctors and patients
    // could have just one :}
//    public User getUserByUserName(String userName) {
//    	if(userName == null) {
//    		return null;
//    	}
//    	else {
//    		for(User user : this.users) {
//    			if(user.getUserName() == userName) {
//    				return user;
//    			}
//    		}
//    	}
//    	return null;
//    }
  
    
}

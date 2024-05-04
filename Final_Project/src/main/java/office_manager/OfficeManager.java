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

    // Private constructor to prevent instantiation from outside the class
    private OfficeManager() {
        appointments = new ArrayList<>();
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    // some getters, don't think we need setters
    public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public ArrayList<PatientUser> getPatients() {
		return patients;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
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
    public User getUserByUserName(String userName) {
    	if(userName == null) {
    		return null;
    	}
    	else {
    		for(User user : this.patients) {
    			if(user.getUserName() == userName) {
    				return user;
    			}
    		}
    		for(User user : this.doctors) {
    			if(user.getUserName() == userName) {
    				return user;
    			}
    		}
  
    	}
    	return null;
    }
    
    // someone needs to implement this. who ever chose to do makeAccount()
    // doesn't necessarily need to return boolean
    // and doesn't really need to be called addNewPatient either
    // thats just how i have it in the patientView - Justice
	public boolean addNewPatient(String userName, String name, String surname, String birthDate) {
		return false;
	}
  
    
}

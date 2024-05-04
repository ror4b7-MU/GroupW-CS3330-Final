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
    
    //To track last index of each type of doctor returned via returnSpecializedDoctor
    private int lastGCPIndex;
    private int lastPodiatristIndex;
    private int lastCardiologistIndex;
    private int lastOncologistIndex;

    // Private constructor to prevent instantiation from outside the class
    private OfficeManager() {
        appointments = new ArrayList<>();
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        lastGCPIndex = -1;
        lastPodiatristIndex = -1;
        lastCardiologistIndex = -1;
        lastOncologistIndex = -1;
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
    
    //Returns one cardiologist in the list, and returns a different cardiologist each time in tandem with the array list
    public Doctor returnSpecializedDoc(Specialization specialization) {
    	//Variable to keep track of the array size
    	int docArraySize = doctors.size();
    	
    	if(specialization = Specialization.GENERAL_CARE_PRACTITIONER) {
    		
    	}
    	
    	else if(specialization = Specialization.PODIATRIST){
    		//if podiatrist
    	}
    	
    	else if(specialiazation = Specialization.CARDIOLOGIST) {
    		//if cardiologist
    	}
    		
    	else if(specialiazation = Specialization.ONCOLOGIST) {
    		//if oncologist
    	}
    	
    	else {
    		//No doctor with the given specialization was found
    	}
    }
    
    public Doctor returnCardiologist() {
    	//Variable to keep track of
    	
    	//for doctor in doctor list
    	for(int index = 0; index <) {
    		//If doctor is cardiologist and the index is greater than the previous cardiologist index, return the doctor
    		if(doctor.doctorSpecialization == CARDIOLOGIST && ) {
    			//return doctor 
    		}
    	}
    }
    
    
}

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
    
    //Returns the next doctor of specified specialty in the arraylist, then starts over from the beginning when it reaches the end
    public Doctor returnSpecializedDoc(Specialization specialization) {

    	try {
        	if(specialization = Specialization.GENERAL_CARE_PRACTITIONER) {
        		//If GCP wanted:
        		return returnGCP();
        	}
        	
        	else if(specialization = Specialization.PODIATRIST){
        		//if podiatrist wanted:
        		return returnPodiatrist();
        	}
        	
        	else if(specialiazation = Specialization.CARDIOLOGIST) {
        		//if cardiologist wanted:
        		return returnCardiologist();
        	}
        		
        	else if(specialiazation = Specialization.ONCOLOGIST) {
        		//if oncologist wanted:
        		return returnOncologist();
        	}
        	
        	else {
        		//If the given specialization was not found, print a message.
        		System.out.println("The given specialization was not found.");
        	}
    	}
    	
    	catch {
    		System.out.println("Something went wrong.");
    	}
    }
    
    //Returns the next gcp listed in the arraylist, then starts over from the beginning when it reaches the end
	public Doctor returnGCP() {
		try {
			
			if(doctors.getsize() == 0) {
				System.out.println("No doctors in Doctor List.");
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is GCP and the index is greater than the previous GCP index, return the doctor
	    		if(doctor.doctorSpecialization == GENERAL_CARE_PRACTITIONER && index > lastGCPindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastGCPindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    		  		
	    	}
	    	
			//If there are no GCPs with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastGCPindex = -1; 
			
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is GCP and the index is greater than the previous GCP index, return the doctor
	    		if(doctor.doctorSpecialization == GENERAL_CARE_PRACTITIONER && index > lastGCPindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastGCPindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    	}  
			
		}
		
		catch{
			System.out.println("Something went wrong.");
		}

	}
    
	//Returns the next podiatrist listed in the arraylist, then starts over from the beginning when it reaches the end
    public Doctor returnPodiatrist() {
		try {
			
			if(doctors.getsize() == 0) {
				System.out.println("No doctors in Doctor List.");
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is Podiatrist and the index is greater than the previous Podiatrist index, return the doctor
	    		if(doctor.doctorSpecialization == PODIATRIST && index > lastPodiatristindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastPodiatristindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    		  		
	    	}
	    	
			//If there are no Podiatrists with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastPodiatristindex = -1; 
			
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is Podiatrist and the index is greater than the previous Podiatrist index, return the doctor
	    		if(doctor.doctorSpecialization == PODIATRIST && index > lastPodiatristindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastPodiatristindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    	}  
			
		}
		
		catch{
			System.out.println("Something went wrong.");
		}

	}
    
    //returns the next cardiologist listed in the arraylist, then starts over from the beginning when it reaches the end
    public Doctor returnCardiologist()  {
		try {
			
			if(doctors.getsize() == 0) {
				System.out.println("No doctors in Doctor List.");
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is Cardiologist and the index is greater than the previous Cardiologist index, return the doctor
	    		if(doctor.doctorSpecialization == CARDIOLOGIST && index > lastCardiologistindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastCardiologistindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    		  		
	    	}
	    	
			//If there are no Cardiologists with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastCardiologistindex = -1; 
			
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is Cardiologist and the index is greater than the previous Cardiologist index, return the doctor
	    		if(doctor.doctorSpecialization == CARDIOLOGIST && index > lastCardiologistindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastCardiologistindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    	}  
			
		}
		
		catch{
			System.out.println("Something went wrong.");
		}

	}
    
    //returns the next oncologist listed in the arraylist, then starts over from the beginning when it reaches the end
    public Doctor returnOncologist()  {
		try {
			
			if(doctors.getsize() == 0) {
				System.out.println("No doctors in Doctor List.");
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is Oncologist and the index is greater than the previous Oncologist index, return the doctor
	    		if(doctor.doctorSpecialization == ONCOLOGIST && index > lastOncologistindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastOncologistindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    		  		
	    	}
	    	
			//If there are no Oncologists with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastOncologistindex = -1; 
			
	    	for(int index = 0; index < doctors.getsize(), index++) {
	    		//If doctor is Oncologist and the index is greater than the previous Oncologist index, return the doctor
	    		if(doctor.doctorSpecialization == ONCOLOGIST && index > lastOncologistindex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastOncologistindex = index;
	    			
	    			//return doctor
	    			return doctors.index;
	    		}
	    	}  
			
		}
		
		catch{
			System.out.println("Something went wrong.");
		}

	}
    
    
}


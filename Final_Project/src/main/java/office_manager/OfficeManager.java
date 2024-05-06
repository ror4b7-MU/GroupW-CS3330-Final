package office_manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// import java.util.Observable;
import java.util.Random;

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

	// dummy doctors
	private Doctor d1 = new Doctor("Kathy", "Kurz", "01-01-1991", "kat", Specialization.GENERAL_CARE_PRACTITIONER);
	private Doctor d2 = new Doctor("Derek", "Han", "12-13-1998", "dhan98", Specialization.ONCOLOGIST);
	private Doctor d3 = new Doctor("Reese", "Darcy", "06-17-2000", "r33sesUser", Specialization.CARDIOLOGIST);
	private Doctor d4 = new Doctor("Skylar", "Crowe", "08-23-1997", "cr0wl4rk", Specialization.PODIATRIST);
	// dummy patients
	private PatientUser p1 = new PatientUser("Casey", "Jones", "07-14-2003", "hockeyboy", d1);
	private PatientUser p2 = new PatientUser("April", "O'Neil", "12-01-2003", "40n3il");
	private PatientUser p3 = new PatientUser("Sharpay", "Evans", "03-28-2002", "pink4lyfe", d1);
	private PatientUser p4 = new PatientUser("Troy", "Bolton", "02-14-2002", "betonit");
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
		patients.add(p1); //adding dummy patients to work with
		patients.add(p2);
		patients.add(p3);
		patients.add(p4);

        doctors = new ArrayList<>();
		doctors.add(d1);
		doctors.add(d2);
		doctors.add(d3);
		doctors.add(d4);

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
    public User getUserByUserName(String userName) {
    	if(userName == null) {
    		//System.out.println("username is null when passed to getUserByUserName");
    		return null;
    	}
    	else {
    		for(User user : this.patients) {
    			if(user.getUserName().equals(userName)) {
    				return user;
    			}
    		}
    		for(User user : this.doctors) {
    			if(user.getUserName().equals(userName)) {
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
		PatientUser newUser = new PatientUser(name, surname, birthDate, userName);
		this.getPatients().add(newUser);
		System.out.println("patients size: " + this.patients.size());
		return true;
	}

	public boolean addNewDocotr(String username, String name, String surname, String birthDate, Specialization spec)
	{
		for (Doctor doc : doctors) {
			if (doc.getUserName().equals(username))
			{
				return false;
			}
		}

		Doctor newDoc = new Doctor(name, surname, birthDate, username, spec);

		doctors.add(newDoc); 

		return true; 
	}
	
    public Boolean scheduleAppointment(PatientUser patient, Doctor doctor, Date start , Date end, String reason)
    {
    	Appointment appointment = new Appointment(patient, doctor, reason, null, start, end); 
    	for(Appointment app : this.getAppointments()) {
    		if(app.getDoctor().equals(doctor) && app.checkOverLap(start, end)) {
    			System.out.println("Error overlapping appointment dates");
    			return false;
    		}
    	}
    	this.getAppointments().add(appointment);
        return true;
    }
	
    // function to view the appointments for a doctor
    // not for patients I think well need another one for that
    public void viewTodaysSchedule(Doctor doctor)
    {

        Date date = new Date(); 
        int count = 0;
        for (Appointment appointment : this.getAppointments()) // loop through all the appointments
        {
            if (appointment.isSameDay(date))
            {
            	if (appointment.getDoctor().equals(doctor)) {
            		System.out.println(appointment.toString());
            		count++;
            	}  
            }
        }
        if(count == 0) { // if there are no appointments today print
        	System.out.println("No appointments found for today");
        }
    }
    
    // this function just prints all the appointments for a given user, patient or doctor
    public void viewUserAppointments(User user) {
    	int count = 0;
    	for (Appointment app : this.getAppointments()) {
    		if(app.getDoctor().equals(user) || app.getPatient().equals(user)) {
    			System.out.println(app.toString());
    			count++;
    		}
    	}
    	if(count == 0) {
    		System.out.println("No appointments found");
    	}
    }
    
    
    public boolean addDoctor(Doctor doctor)
    {
        try 
        {
            doctors.add(doctor); 
            
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
    
    //Returns the next doctor of specified specialty in the arraylist, then starts over from the beginning when it reaches the end
    public Doctor returnSpecializedDoc(Specialization specialization) {

    	try {
        	if(specialization == Specialization.GENERAL_CARE_PRACTITIONER) {
        		//If GCP wanted:
        		return returnGCP();
        	}
        	
        	else if(specialization == Specialization.PODIATRIST){
        		//if podiatrist wanted:
        		return returnPodiatrist();
        	}
        	
        	else if(specialization == Specialization.CARDIOLOGIST) {
        		//if cardiologist wanted:
        		return returnCardiologist();
        	}
        		
        	else if(specialization == Specialization.ONCOLOGIST) {
        		//if oncologist wanted:
        		return returnOncologist();
        	}
        	
        	else {
        		//If the given specialization was not found, print a message.
        		System.out.println("The given specialization was not found.");
        	}
    	}
    	catch(Exception e) {
    		System.out.println("Something went wrong in method returnSpecializedDoc.");
    	}
    	
    	//Upon failure, return null
    	return null;
    }
    
    //Returns the next gcp listed in the arraylist, then starts over from the beginning when it reaches the end
	public Doctor returnGCP() {
		try {
			
			if(doctors.size() == 0) {
				System.out.println("No doctors in Doctor List.");
				return null;
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is GCP and the index is greater than the previous GCP index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.GENERAL_CARE_PRACTITIONER && index > lastGCPIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastGCPIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    		  		
	    	}
	    	
			//If there are no GCPs with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastGCPIndex = -1; 
			
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is GCP and the index is greater than the previous GCP index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.GENERAL_CARE_PRACTITIONER && index > lastGCPIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastGCPIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    	}  
			
		}
		catch (Exception e){
			System.out.println("Something went wrong.");
		}
		
		System.out.println("No General Practitioner found in Doctors list.");
		return null;

	}
    
	//Returns the next podiatrist listed in the arrayList, then starts over from the beginning when it reaches the end
    public Doctor returnPodiatrist() {
		try {
			
			if(doctors.size() == 0) {
				System.out.println("No doctors in Doctor List.");
				return null;
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is Podiatrist and the index is greater than the previous Podiatrist index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.PODIATRIST && index > lastPodiatristIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastPodiatristIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    		  		
	    	}
	    	
			//If there are no Podiatrists with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastPodiatristIndex = -1; 
			
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is Podiatrist and the index is greater than the previous Podiatrist index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.PODIATRIST && index > lastPodiatristIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastPodiatristIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    	}  
			
		}
		catch (Exception e){
			System.out.println("Something went wrong.");
		}

		System.out.println("No Podiatrist found in Doctors list.");
		return null;
	}
    
    //returns the next cardiologist listed in the arraylist, then starts over from the beginning when it reaches the end
    public Doctor returnCardiologist()  {
		try {
			
			if(doctors.size() == 0) {
				System.out.println("No doctors in Doctor List.");
				return null;
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is Cardiologist and the index is greater than the previous Cardiologist index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.CARDIOLOGIST && index > lastCardiologistIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastCardiologistIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    		  		
	    	}
	    	
			//If there are no Cardiologists with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastCardiologistIndex = -1; 
			
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is Cardiologist and the index is greater than the previous Cardiologist index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.CARDIOLOGIST && index > lastCardiologistIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastCardiologistIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    	}  
			
		}
		catch(Exception e) {
			System.out.println("Something went wrong in method returnCardiologist.");
		}
		
		System.out.println("No Cardiologist found in Doctors list.");
		return null;

	}
    
    //returns the next oncologist listed in the arraylist, then starts over from the beginning when it reaches the end
    public Doctor returnOncologist()  {
		try {
			
			if(doctors.size() == 0) {
				System.out.println("No doctors in Doctor List.");
				return null;
			}
			
			//for doctor in doctor list
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is Oncologist and the index is greater than the previous Oncologist index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.ONCOLOGIST && index > lastOncologistIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastOncologistIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    		  		
	    	}
	    	
			//If there are no Oncologists with index greater than the previous index, reset the previous index counter to search from 
			//the beginning of the array and loop again
			lastOncologistIndex = -1; 
			
	    	for(int index = 0; index < doctors.size(); index++) {
	    		//If doctor is Oncologist and the index is greater than the previous Oncologist index, return the doctor
	    		if(doctors.get(index).getDoctorSpecialization() == Specialization.ONCOLOGIST && index > lastOncologistIndex) {
	    			
	    			//Set new lastIndex to the current one
	    			lastOncologistIndex = index;
	    			
	    			//return doctor
	    			return doctors.get(index);
	    		}
	    	}  
			
		}
		catch(Exception e) {
			System.out.println("Something went wrong.");
		}
		
		System.out.println("No Oncologist found in Doctors list.");
		return null;

	}

	/* This function identifies the specialization of the doctor being swapped out, and then selects a random
     * doctor of the same specialization to replace them. This new doctor is then returned by the method itself.
     */
    public Doctor changeDoctor(Doctor docName) {
		ArrayList<Doctor> docList = instance.getDoctors();
		ArrayList<Doctor> options = new ArrayList<>(); // list of doctors with matching specialization
		int length=0; // length of option list
		for (Doctor doc : docList) {
			if (doc.getDoctorSpecialization()==docName.getDoctorSpecialization()) {
				options.add(doc);
				length+=1;
			}
		}
		Random rand = new Random();
		int randint = rand.nextInt(length); //selecting a random doctor from the list

		return options.get(randint); //returning randomly-selected doctor
	}

	/* This function refers a given PatientUser patient to the given Specialization spec's referral list, to then be assigned
	 * to a doctor within that spec. It returns true if the patient is successfully entered into the list, and returns false
	 * if the patient cannot be found within the referral list. 
	 */
	public boolean referPatient (PatientUser patient, Specialization spec) {

        spec.addReferral(patient); //referring patient
        List<PatientUser> refList = spec.getReferrals();
        for(PatientUser ref : refList) { //checking that patient was successfully referred
            if(ref==patient) {
                return true;
            }
        }
		// in case of failure
        return false;
    }
	
	// function to assign a prescription to a patients medlist
	public boolean assignPatientMedication(String patientUserName, Prescription p) {
		PatientUser patient = (PatientUser) this.getUserByUserName(patientUserName); 
		if(patient == null) {
			System.out.println("Patient not found!");
			return false;
		}
		else {
			patient.getMedList().add(p);
			return true;
		}
	}
	
	//function to remove a prescription from a patients medlist
	public boolean removePatientMedication(String patientUserName, Prescription p) {
		PatientUser patient = (PatientUser) this.getUserByUserName(patientUserName); 
		if(patient == null) {
			System.out.println("Patient not found!");
			return false;
		}
		else {
			for(Prescription P : patient.getMedList()) {
				if(P.equals(p)) {
					patient.getMedList().remove(P);
					return true;
				}
			}
		}
		System.out.println("Prescription not found!");
		return false;
	}
	
	// function to return an appointment by id
	public Appointment getApptByID(int id) {
		for(Appointment appt : this.getAppointments()) {
			if(appt.getAppointmentId() == id) {
				return appt;
			}
		}
		System.out.println("Appointment not found");
		return null;
	}

	
	// this function removes the appointment from the manager's appointment list. It returns false if the
	// appointment is still in the list, and true if it has been successfully removed.
	public boolean deleteAppt(Appointment appt) {
		
		appointments.remove(appt);
		
		for(Appointment apptItem : appointments) { //checking that appt no longer exists
			if(apptItem==appt) {
				return false;
			}
		}
		return true;
	}

	// this function deletes the appointment, checks to ensure it is deleted, and then goes to
	// reschedule the appointment with the same parameters, with the exception of the new start-
	// and end-times.
	public boolean rescheduleAppt(Appointment appt, Date newStart, Date newEnd) {

		boolean test = deleteAppt(appt); //deleting the appt

		Appointment newAppt = new Appointment(appt.getPatient(), appt.getDoctor(), appt.getReason(), appt.getConclusion(), newStart, newEnd);

		appointments.add(newAppt);//rescheduling
		
		boolean fixTest = false;
		for(Appointment apptItem : appointments) {
			if(apptItem==newAppt) {
				fixTest = true;
			}
		}
		boolean compTest = test && fixTest;
		return compTest; //checking that the initial appt was deleted and newAppt was implemented
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public ArrayList<PatientUser> getPatients() {
		return patients;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	

    
    
}


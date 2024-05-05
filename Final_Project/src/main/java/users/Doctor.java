package users;

import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.swing.plaf.nimbus.State;

import records.Appointment;
import records.Prescription;

import java.util.ArrayList;

public class Doctor // extends User // need to change the constructor and could get rid of the firstName and LastName fields and ID
{
    private String firstName; 
    private String lastName; 
    private ArrayList<Appointment> schedule; //Holds all appointments for the current docotr 
    private String birthDate; 
    private int ID; //THis is so there is a way for someone to delate a specific doctor
    private Specialization doctorSpecialization; //This keeps track of what specilization the doctor falls under 


    //These belong to all docotrs
    //This  allows any doctor withen a deparmtnet to accese all patients that were refered to their department 
    private static List<Doctor> allDoctors = new ArrayList<>();
    private static int idCounter = 10000; 



    //This creates a doctor account, which is then stored in the allDoctors array
    public Doctor(String firstName, String lastName, String date, Specialization doctorSpecialization)
    {
        this.firstName = firstName; 
        this.lastName = lastName;
        this.birthDate = date;
        this.ID = idCounter;
        this.setDoctorSpecialization(doctorSpecialization); 
        idCounter += 1;  

        this.schedule = new ArrayList<Appointment>(); 

        allDoctors.add(this); 
    }


    public String toString()
    {
        return(ID + "\n" + firstName + " "+ lastName + "\n" + getDoctorSpecialization() + "\n");
    }

    //This method attempts to set up an appointmet.
    //If it fails it returns false, and else it returns true
    public Boolean scheduleAppointment(PatientUser patient, Date start , Date end)
    {
        for (Appointment apointment : schedule)
        {
            if (apointment.checkOverLap(start, end) == true)
            {
                return false;
            }
        }

        Appointment appointment = new Appointment(patient, this, lastName, firstName, start, end); 

        schedule.add(appointment);

        return true;
    }


    //This method gets all the refered patients from the docotrs type 
    public List<PatientUser> getReferedPatients()
    {
        return getDoctorSpecialization().getReferrals();
    }


    //This gets the doctors appointments for the current day
    public void viewTodaysSchedule()
    {

        Date date = new Date(); 

        for (Appointment apointment : schedule)
        {
            if (apointment.isSameDay(date))
            {
                System.out.println(apointment);
            }
        }
    }
    
    public boolean assignPatientMedication(PatientUser patient, Prescription medication)
    {	
    	switch(medication) {
	    	case ALBUTEROL: 
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.ALBUTEROL) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.ALBUTEROL)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case AMOXICILLIN:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.AMOXICILLIN) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.AMOXICILLIN)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case ANASTROZOLE:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.ANASTROZOLE) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.ANASTROZOLE)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case BACTRIM:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.BACTRIM) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.BACTRIM)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case DIGOXIN:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.DIGOXIN) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.DIGOXIN)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case DILTIAZEM:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.DILTIAZEM) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.DILTIAZEM)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case IBUPROFEN:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.IBUPROFEN) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.IBUPROFEN)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case LETROZOLE:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.LETROZOLE) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.LETROZOLE)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case MACROBID:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.MACROBID) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.MACROBID)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	case VERAPAMIL:
	    		//For loop to return true if the medication is already in the list
	    		for(Prescription med : patient.getMedList())
	    		{
	    			if(med == Prescription.VERAPAMIL) {
	    				return true;
	    			}
	    		}
	    		//Otherwise return true upon successful addition
	    		if(patient.addPrescription(Prescription.VERAPAMIL)) {
	    			return true;
	    		}
	    		//else return false
	    		return false;
	    		
	    	default:
	    		return false;
    	}   	
    }
    
    public boolean deletePatientMedication(PatientUser patient, Prescription medication)
    {
    	switch(medication) {
    	case ALBUTEROL: 
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.ALBUTEROL)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case AMOXICILLIN:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.AMOXICILLIN)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case ANASTROZOLE:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.ANASTROZOLE)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case BACTRIM:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.BACTRIM)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case DIGOXIN:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.DIGOXIN)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case DILTIAZEM:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.DILTIAZEM)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case IBUPROFEN:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.IBUPROFEN)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case LETROZOLE:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.LETROZOLE)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case MACROBID:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.MACROBID)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	case VERAPAMIL:
    		//return true upon successful removal
    		if(patient.removePrescription(Prescription.VERAPAMIL)) {
    			return true;
    		}
    		//else return false
    		return false;
    		
    	default:
    		return false;
	} 
    }


    //This gets all of the doctors 
    //Static Type 

    public static List<Doctor> getAllDoctors()
    {
        return allDoctors; 
    }


	public Specialization getDoctorSpecialization() {
		return doctorSpecialization;
	}


	public void setDoctorSpecialization(Specialization doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}


}
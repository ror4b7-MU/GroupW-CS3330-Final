package user_views;

import office_manager.OfficeManager;
import records.Appointment;
import users.Doctor;
import users.User;

import java.util.ArrayList;
import java.util.Random;

public class PatientView extends UserView {

	private User user;
	protected OfficeManager manager;
	
	public PatientView() {
		//need constructor, but need userview constructor first
	}
	
	public Doctor changeDoctor(Doctor docName) {
		ArrayList<Doctor> docList = manager.getDoctors(); //need getters and setters for the doctor and patient lists
		ArrayList<Doctor> options = new ArrayList<>();
		int length=0;
		for (Doctor doc : docList) {
			if (doc.getDoctorSpecialization()==docName.getDoctorSpecialization()) {
				options.add(doc);
				length+=1;
			}
		}
		Random rand = new Random();
		int randint = rand.nextInt(length);

		return options.get(randint);
	}

	// this function makes the appointment NULL, and removes it from the corresponding doctor's schedule
	public boolean deleteAppt(Appointment appt) {
	
		Doctor doc = appt.getDoctor(); // finding the appt's assigned doctor
		doc.getSchedule().remove(appt); //removing appt from schedule
		appt=null;
	
		for(Appointment apptItem : doc.getSchedule()) { //checking that appt no longer exists
			if(apptItem==appt) {
				return false;
			}
		}
		return true;
	}

	// this function deletes the appointment, checks to ensure it is deleted, and then goes to reschedule the appointment with the same parameters
	public boolean rescheduleAppt(Appointment appt) {

		Doctor doc = appt.getDoctor();
		boolean test = deleteAppt(appt); //deleting the appt
		doc.scheduleAppointment(appt.getPatient(), appt.getStart(), appt.getEnd()); //rescheduling
		
		return test; //checking that the initial appt was deleted
	}
}

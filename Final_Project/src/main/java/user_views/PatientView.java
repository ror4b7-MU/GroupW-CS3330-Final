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
	
	Doctor changeDoctor(Doctor docName) {
		ArrayList<Doctor> docList = manager.getDoctors(); //need getters and setters for the doctor and patient lists
		ArrayList<Doctor> options = new ArrayList<>();
		int length;
		for (Doctor doc : docList) {
			if (doc.getDoctorSpecialization()==docName.getDoctorSpecialization()) {
				options.add(doc);
				length+=1;
			}
		}
		Random rand = new Random();
		int randint = rand.nextInt(length);

		return options.get(length);
	}

	public boolean deleteAppt(Appointment appt) {
		//need getters and setters for doctor class
		Doctor doc = appt.getDoctor();
		doc.getSchedule().remove(appt);
		appt=null;
		if(doc.getSchedule().get(appt)==null) {
			return true;
		}
		return false;
	}

	public boolean rescheduleAppt(Appointment appt) {

		Doctor doc = appt.getDoctor();
		boolean test = deleteAppt(appt);
		doc.scheduleAppointment(appt.getPatient(), appt.getStart(), appt.getEnd());
		
		return test;
	}
}

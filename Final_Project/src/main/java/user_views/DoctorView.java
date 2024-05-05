package user_views;

import java.util.ArrayList;
import java.util.Random;

import office_manager.OfficeManager;
import users.Doctor;
import users.PatientUser;
import users.Specialization;
import users.User;

public class DoctorView extends UserView{

    private User user;
	protected OfficeManager manager;
	
	public DoctorView() {
		//need constructor, but need userview constructor first
	}
    
    public boolean referPatient (PatientUser patient, Specialization spec) {
        // ArrayList<PatientUser> patList = manager.getPatients();
        // ArrayList<Doctor> docList = manager.getDoctors();
        // ArrayList<Doctor> options = new ArrayList<>();
        // int length;

        // for(Doctor doc : docList) {
        //     if(doc.getDoctorSpecialization==spec) {
        //         options.add(doc);
        //         length += 1;
        //     }
        // }

        // Random rand = new Random();
        // int randint = rand.nextInt(length);

        // options.get(length);

        spec.addReferral(patient);
    }

}

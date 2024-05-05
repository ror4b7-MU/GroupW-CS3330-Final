package user_views;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

import office_manager.OfficeManager;
// import users.Doctor;
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

        spec.addReferral(patient);
        List<PatientUser> refList = spec.getReferrals();
        for(PatientUser ref : refList) {
            if(ref==patient) {
                return true;
            }
        }
        return false;
    }

}

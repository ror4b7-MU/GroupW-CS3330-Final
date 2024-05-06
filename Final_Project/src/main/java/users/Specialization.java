package users;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;



public enum Specialization {
    GENERAL_CARE_PRACTITIONER,
    PODIATRIST,
    CARDIOLOGIST,
    ONCOLOGIST;


    
    private List<PatientUser> referrals;


    //This gives each department a seperate array of reffered patients
    Specialization() {
        this.referrals = new ArrayList<>();
    }

    //This gets the referls for each department
    public List<PatientUser> getReferrals() {
        return referrals;
    }

    // This adds a referal 
    public void addReferral(PatientUser patient) {
        referrals.add(patient);
    }
   
}
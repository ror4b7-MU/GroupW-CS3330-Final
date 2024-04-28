import java.util.Date;
import java.util.List;

import java.util.ArrayList;



public enum Specialization {
    GENERAL_CARE_PRACTITIONER,
    PODIATRIST,
    CARDIOLOGIST,
    ONCOLOGIST;


    private List<Patient> referrals;


    //This gives each department a sepecrate array of refered patients
    Specialization() {
        this.referrals = new ArrayList<>();
    }

    //This gets the referls for each department
    public List<Patient> getReferrals() {
        return referrals;
    }

    // This adds a referal 
    public void addReferral(Patient patient) {
        referrals.add(patient);
    }

   

}
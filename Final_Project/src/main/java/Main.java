

import java.util.Date;

import users.Doctor;
import users.PatientUser;
import users.Specialization;

public class Main 
{
    public static void main(String []args)
    {
        Doctor doc = new Doctor("Bob", "Joel", "10/10", Specialization.CARDIOLOGIST); 
        Doctor doc2 = new Doctor("Ally", "Tuck", "11/10", Specialization.ONCOLOGIST); 

        PatientUser pat1 = new PatientUser("Layla", "Apricote", "11/24"); 
        PatientUser pat2 = new PatientUser("Bob", "Evans", "11/24"); 

        


       

    }
}

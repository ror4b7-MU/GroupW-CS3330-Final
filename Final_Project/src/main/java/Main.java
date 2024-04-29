

import java.util.Date;

import javax.print.Doc;

import records.Appointment;
import users.Doctor;
import users.PatientUser;
import users.Specialization;
import users.User;

public class Main 
{
    public static void main(String []args)
    {
        Doctor doc = new Doctor("Bob", "Joel", "10/10", Specialization.CARDIOLOGIST); 
        Doctor doc2 = new Doctor("Layla", "Smith", "10/10", Specialization.CARDIOLOGIST);
        
    
        PatientUser pat1 = new PatientUser("Smith", "Name", "10/10"); 

        PatientUser pat2 = new PatientUser("Bob", "Sur", "10/10"); 

        Date start = new Date(2024, 3, 2, 3, 10); 
        Date end = new Date(2024, 3, 2, 3, 30); 

        Date start2 = new Date(2024, 3, 2, 3, 15); 
        Date end2 = new Date(2024, 3, 2, 3, 40); 


        


        //Return True
        System.out.println(doc.scheduleAppointment(pat1, start, end));


        //Should return False
        System.out.println(doc.scheduleAppointment(pat2, start2, end2));

        //Should return True
        System.out.println(doc2.scheduleAppointment(pat2, start2, end2));

        
    

    }
}

package users;

import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.swing.plaf.nimbus.State;

import records.Appointment;


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
        this.doctorSpecialization = doctorSpecialization; 
        idCounter += 1;  

        this.schedule = new ArrayList<Appointment>(); 

        allDoctors.add(this); 
    }


    public String toString()
    {
        return(ID + "\n" + firstName + " "+ lastName + "\n" + doctorSpecialization + "\n");
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
        return doctorSpecialization.getReferrals();
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


    //This gets all of the doctors 
    //Static Type 

    public static List<Doctor> getAllDoctors()
    {
        return allDoctors; 
    }


}
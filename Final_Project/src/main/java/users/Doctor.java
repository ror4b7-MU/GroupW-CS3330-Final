package users;

import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.swing.plaf.nimbus.State;

import records.Appointment;


import java.util.ArrayList;

public class Doctor
{
    private String firstName; 
    private String lastName; 
    private Appointment schedule[]; //Holds all appointments for the current docotr 
    private String birthDate; 
    private int ID; //THis is so there is a way for someone to delate a docotr
    private Specialization doctorSpecialization; 


    //These belong to all docotrs
    //This  allows any doctor withen a deparmtnet to accese all patients that were refered to their department 
    private static List<Doctor> allDoctors = new ArrayList<>();
    private static List<PatientUser> referedList = new ArrayList<>();
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

        this.schedule = new

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

        Appointment appointment = new Appointment(); 

        appointment.createAppointment(patient, this, lastName, firstName, start, end);

        return true;
    }


    //This method gets all the refered patients from the docotrs type 
    public List<PatientUser> getReferedPatients()
    {
        return doctorSpecialization.getReferrals();
    }

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


    public static List<Doctor> getAllDoctors()
    {
        return allDoctors; 
    }


}
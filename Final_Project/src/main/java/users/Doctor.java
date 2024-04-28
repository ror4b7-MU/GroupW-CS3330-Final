package users;

import java.util.Date;
import java.util.List;

import records.Appointment;


import java.util.ArrayList;

public class Doctor
{
    private String firstName; 
    private String lastName; 
    private Appointment schedule[]; //Holds all appointments for the current docotr 
    private Date birthDate; 
    private int ID; //THis is so there is a way for someone to delate a docotr
    private Specialization doctorSpecialization; 


    //These belong to all docotrs 
    private static List<Doctor> allDoctors = new ArrayList<>();
    private static List<PatientUser> referedList = new ArrayList<>();
    private static int idCounter = 10000;



    //This docotr creates a docotr account, which is then kept in the static docotr array
    public void makeDoctorAccount(String firstName, String lastName, Date birthDate, Specialization doctorSpecialization)
    {
        this.firstName = firstName; 
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ID = idCounter;
        this.doctorSpecialization = doctorSpecialization; 
        idCounter += 1;  

        allDoctors.add(this);  
    }


    //This method attempts to sucudle an appointmet.
    //If it fails it returns false, and if it sucudes it returns true 
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


}
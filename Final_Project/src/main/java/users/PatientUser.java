package users;

import java.util.ArrayList;

import records.Appointment;
import records.Prescription;

public class PatientUser extends User {
    private String name;
    private String surname;
    private String birthdate;
    private ArrayList<Prescription> medList;
    private ArrayList<Appointment> pastAppointment;

    public PatientUser (String name, String surname, String birthdate, ArrayList<Prescription> medList, ArrayList<Appointment> pastAppts) {
        super(name, surname, birthdate);
        this.medList=new ArrayList<Prescription>();
        this.pastAppointment=new ArrayList<Appointment>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public ArrayList<Prescription> getMedList() {
        return medList;
    }

    public void setMedList(ArrayList<Prescription> medList) {
        this.medList=medList;
    }

    public ArrayList<Appointment> getPastAppts() {
        return pastAppointment;
    }

    public void setPastAppointment(ArrayList<Appointment> pastAppts) {
        this.pastAppointment=pastAppointment;
    }
}

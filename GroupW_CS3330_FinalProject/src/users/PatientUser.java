package users;

import java.util.ArrayList;

import records.Appt;
import records.Prescription;

public class PatientUser extends User {
    private String name;
    private String surname;
    private String birthdate;
    private ArrayList<Prescription> medList;
    private ArrayList<Appt> pastAppts;

    public PatientUser (String name, String surname, String birthdate, ArrayList<Prescription> medList, ArrayList<Appt> pastAppts) {
        super(name, surname, birthdate);
        this.medList=new ArrayList<Prescription>();
        this.pastAppts=new ArrayList<Appt>();
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

    public ArrayList<Appt> getPastAppts() {
        return pastAppts;
    }

    public void setPastAppts(ArrayList<Appt> pastAppts) {
        this.pastAppts=pastAppts;
    }
}

package records; 

import java.util.Date;
import java.util.List;

import users.Doctor;
import users.PatientUser;

import java.util.Calendar;

public class Appointment 
{
    private PatientUser patient; 
    private Doctor doctor; 
    private String reason; 
    private String conclusion; 
    public Date start; 
    public Date end; 
    private int AppointmentId;
    private static int idCounter = 1;
    


    @Override
    public String toString() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        int year = cal.get(Calendar.YEAR); 
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int startHour = cal.get(Calendar.HOUR_OF_DAY);
        int startMinute = cal.get(Calendar.MINUTE);

        cal.setTime(end);
        int endHour = cal.get(Calendar.HOUR_OF_DAY);
        int endMinute = cal.get(Calendar.MINUTE);
        

        
        return ("Appointment" +
                "\n DATE=" + 
                day + 
                "\n START TIME" + 
                startHour + startMinute +
                "\n END TIME" 
                + 
                endHour + endMinute);


    }

    public Appointment(PatientUser patient, Doctor doctor, String reason,  String conclusion, Date start, Date end)
    {
        this.patient = patient; 
        this.doctor = doctor; 
        this.reason = reason; 
        this.conclusion = conclusion; 
        this.start = start; 
        this.end = end;
        this.setAppointmentId(idCounter);
        idCounter++;
    }

    public boolean isSameDay(Date date) {
        // Get the day, month, and year parts of the start date of this appointment
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        int day1 = cal.get(Calendar.DAY_OF_MONTH);
        int month1 = cal.get(Calendar.MONTH) + 1; // Calendar month starts from 0
        int year1 = cal.get(Calendar.YEAR);

        // Extract the day, month, and year parts of the provided date
        cal.setTime(date);
        int day2 = cal.get(Calendar.DAY_OF_MONTH);
        int month2 = cal.get(Calendar.MONTH) + 1; // Calendar month starts from 0
        int year2 = cal.get(Calendar.YEAR);

        // Compare the day, month, and year parts
        return day1 == day2 && month1 == month2 && year1 == year2;
    }



    

    //Will check to make sure that etheir 
    //The end before the start
    //Or the start happens after the end
    public boolean checkOverLap(Date start, Date end)
    {
        if (end.before(this.start) || start.after(this.end)) {
            // No overlap
            return false;
        }
        // Overlap
        return true;
    }

    public PatientUser getPatient() {
        return patient;
    }

    public void setPatient(PatientUser patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

	public int getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		AppointmentId = appointmentId;
	}
    
}
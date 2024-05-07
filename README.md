This is an appointment management system intended for use in a doctor's office. 
UI Functionalities include:
Patients can:
  - Create User
  - Log In
  - View Schedule
  - Book Appointment
  - Cancel Appointment
  - Reschedule Appointment
  - Change General Care Practitioner
  - Log Out
    
Doctors can:
  - Log In
  - View Schedule
  - Refer Patient to a Department
  - Cancel Appointment
  - Reschedule Appointment
  - Prescribe Medication to a Patient
  - Remove a Patient Prescription
  - Log Out

Currently, accounts only persit for the runtime of the program. Thus, we have hard-coded some example accounts for testing and demo purposes. 
The information for these patients can be seen in the OfficeManager class, however, they are also listed here for the sake of concision.
The dummy accounts are as follows:

Patients:
Casey Jones, Birthdate: 7/14/2003, Username: p1, General Care Practitioner: Kathy Kurz
April O'Neil, Birthdate: 12/1/2003, Username: p2, General Care Practitioner: None
Sharpay Evans, Birthdate: 3/28/2002, Username: p3, General Care Practitioner: Kathy Kurz
Troy Bolton, Birthdate: 2/14/2002, Username: p4, General Care Practitioner: None

Doctors:
Kathy Kurz, Birthdate: 1/1/1991, Username: d1, Specialization: General Care Practitioner
Derek Han, Birthdate: 12/13/1998, Username: d2, Specialization: Oncologist
Reese Darcy, Birthdate: 6/17/2000, Username: d3, Specialization: Cardiologist
Skylar Crowe, Birthdate: 8/23/1997, Username: d4, Specialization: Podiatrist

Instructions to run: 
- Clone repository to your local device
- In eclipse, navigate to Main.java (GroupW-CS3330-Final/Final_Project/src/main/java
- Run

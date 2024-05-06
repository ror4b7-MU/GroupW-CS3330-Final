package user_views;
import java.util.Calendar;
import java.util.Scanner;
import office_manager.OfficeManager;
import records.Appointment;
import users.User;

public abstract class UserView {
	
	// user object will be assigned by login() I'm thinking?
	protected User user; // this could also be userName not sure which would be easier
	protected boolean loggedIn = false; // logged in status. Set to true on successful login. Set to false when the user logs out
	protected Scanner scanner; // i found that having this single instance of scanner was preventing some errors when closing the scanner
	protected UserInput userinput;
	
	public UserView() {
		this.userinput = new UserInput();
		scanner = new Scanner(System.in);
	}
	
	//Provide Access to the OfficeManager which will have all the office info
	// This provides a clear way to get the singleton instance of OfficeManager
    protected OfficeManager getOfficeManager() {
        return OfficeManager.getInstance();
    }
	
    //getters and setters
	public User getUser() {
		return user;
	}
	
	private void setUser(User user) {
		this.user = user;
	}
	
	public boolean getLoggedInStatus() {
		return loggedIn;
	}
	
	private void setLoggedInStatus(boolean loggedInStatus) {
		this.loggedIn = loggedInStatus;
	}

    
    // function imitates logging into the system
    // does so by simply setting the user in user view
	public boolean login() {
	    //Scanner scanner = new Scanner(System.in);
	    try {
	        boolean loggedIn = false;
	        while (!loggedIn) {
	            System.out.print("Enter username to login: ");
	            String userName = scanner.nextLine();
	            
	            OfficeManager officeManager = getOfficeManager();
	            User user = officeManager.getUserByUserName(userName);
	            
	            if (user != null) {
	                this.setUser(user);
	                this.setLoggedInStatus(true);
	                loggedIn = true;
	            } else {
	                System.out.println("User not found!");
	                if (this instanceof PatientView) {
	                    System.out.print("Would you like to create a new user? (Yes/No): ");
	                    String yesOrNo = scanner.nextLine();
	                    if (yesOrNo.equalsIgnoreCase("yes")) {
	                        if (createNewUser()) {
	                            // User created successfully, continue with login process
	                            continue;
	                        }
	                    }
	                }
	                // If no user found and no new user is created, exit the loop
	                break;
	            }
	        }
	        return loggedIn;
	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	        return false;
	    }
	}
    
    
    // if a userName is not found during login a new "account" (basically just a new User) can be created
    // the subclasses will have to implement this method
    // im thinking that in the DoctorView class it will just return false 
    // because we dont just want to be able to create new doctors willy nilly?
    // in the PatientView this method will scan for some user input and then call the the makeAccount method
    // to actually create the new user and save it to the system
    protected abstract boolean createNewUser();
    
    // maybe this isn't the greatest name but the point of the function is to provide an entry
    // into the systems functionality by calling the two following functions displayOptions and executeSelectedOption
    // this is the function that i want to run in a loop in main
    public boolean runUserEnvironment() {
    	// Scanner scanner = null;
    	try { 
    		if(this.loggedIn == false) { // throw an exception if no one is logged in
    			throw new NotLoggedInException("Error: No user is logged in");
    		}
    		scanner = new Scanner(System.in);
    		this.displayOptions(); // first display the options
    		System.out.print("Please select an option by typing in a number: ");
    		int optionNumber = scanner.nextInt(); // scan for the users input
    		if (this.executeSelectedOption(optionNumber)) { // execute the selected option
    			return true;
    		}
    		else {
    			return false;
    		}
    	} catch (Exception e) { // if an exception is caught print it and return false
			e.printStackTrace();
			return false;
		}
	}
    
    // this function will display some options that the user can choose to perform
    // see the subclasses for specifics
    protected abstract void displayOptions();
    
    // has a switch statement to call the function related to that option
    // again im making this abstract because there are slightly different options for Doctors and Patients
    protected abstract boolean executeSelectedOption(int OptionNumber);
    
    // the following are the functions that will be executed based on a users selected option
    // mostly they will just be wrappers for the officeManager functions that the rest of the team is writing
    // and they scan for user input so that the officeManager functions can have parameters\
    
    protected abstract void viewSchedule();
    
    protected abstract boolean bookAppointment();
    
	protected boolean cancelOrReschedulApp() {
		String CorR = UserInput.getString("Enter C to cancel an appointment and R to reschedule");
		if(CorR.equals("C")) {
			int apptNum = UserInput.getValidInt("Enter the appointment number");
			Appointment appt = this.getOfficeManager().getApptByID(apptNum);
			if(appt == null) {
				return false;
			}
			if(this.getOfficeManager().deleteAppt(appt)) {
				return true;
			}
			else {
				System.out.println("Error canceling appointment");
				return false;
			}
		}
		else if (CorR.equals("R")) {
			int apptNum = UserInput.getValidInt("Enter the appointment number");
			Calendar calStart = UserInput.getValidDate("Enter the start time (YYYY-MM-DD-HH-mm)");
			Calendar calEnd = UserInput.getValidDate("Enter the end time (YYYY-MM-DD-HH-mm)");
			Appointment appt = this.getOfficeManager().getApptByID(apptNum);
			if(appt == null) {
				return false;
			}
			if(this.getOfficeManager().rescheduleAppt(appt, calStart.getTime(), calEnd.getTime())) {
				return true;
			}
			else {
				System.out.println("Error rescheduling appointment");
				return false;
			}
		}
		else {
			System.out.println("Invalid Input");
			return false;
		}
	}


    
    // logs the user out
    // its nothing fancy just sets the user to null and the loggedIn status to false
    protected boolean logout() {
    	try {
    		if(this.loggedIn == false) {
    			throw new NotLoggedInException("Error: No user is logged in");
    		}
    		this.setUser(null);
    		this.setLoggedInStatus(false);
    		return true;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return false;
    	}	
    }
    
   
    // not logged in exception
    protected class NotLoggedInException extends Exception {
		private static final long serialVersionUID = 1L;

		public NotLoggedInException(String message) {
            super(message);
        }
    }

	
}

package user_views;
import java.util.Scanner;
import office_manager.OfficeManager;
import users.User;

public abstract class UserView {
	
	// user object will be assigned by login() I'm thinking?
	private User user;
	private boolean loggedIn = false;
	
    //getter
	public User getUser() {
		return user;
	}

	//Provide Access to the OfficeManager which will have all the office info
	// This provides a clear way to get the singleton instance of OfficeManager
    protected OfficeManager getOfficeManager() {
        return OfficeManager.getInstance();
    }
    
    // function imitates logging into the system
    // does so by simply setting the user in user view
    public boolean login() {
        Scanner scanner = null; // Declare scanner outside the try block
        try {
            scanner = new Scanner(System.in); // Assign a new Scanner instance
            System.out.print("Enter username: ");
            String userName = scanner.nextLine();

            OfficeManager officeManager = getOfficeManager();
            User user = officeManager.getUserByUserName(userName);
        
            if (user != null) {
                this.user = user;
                this.loggedIn = true;
                return true;
            } else {
                System.out.println("User not found!");

                if (this instanceof PatientView) {
                    System.out.println("Would you like to create a new user? (Yes/No):");
                    String yesOrNo = scanner.nextLine();

                    if (yesOrNo.toLowerCase().equals("yes")) {
                        createNewUser();
                        return login(); // Recursive call to login() after creating a new user
                    }
                }
                
                return false;
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        } finally {
            // Ensure that the Scanner instance is always closed
            // even if an exception occurs or the method returns early
            if (scanner != null) {
                scanner.close();
            }
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
    	Scanner scanner = null;
    	try {
    		if(this.loggedIn == false) {
    			throw new NotLoggedInException("Error: No user is logged in");
    		}
    		scanner = new Scanner(System.in);
    		this.displayOptions();
    		System.out.println("Please select an option by typing in a number");
    		int optionNumber = scanner.nextInt();
    		if (this.executeSelectedOption(optionNumber)) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	finally {
            if (scanner != null) {
                scanner.close();
            }
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
    
    protected void viewSchedule() {
    	
    }
    
    protected boolean bookAppointment() {
    	return false;
    }
    
    protected boolean cancelOrReschedulApp() {
		return false;
    	
    }
    
    protected boolean logout() {
    	return false;
    }
    
   
    // not logged in exception
    protected class NotLoggedInException extends Exception {
		private static final long serialVersionUID = 1L;

		public NotLoggedInException(String message) {
            super(message);
        }
    }



	
}

package user_views;
import java.util.Scanner;
import office_manager.OfficeManager;
import users.User;

public abstract class UserView {
	
	// user object will be assigned by login() I'm thinking?
	private User user;

	//Provide Access to the OfficeManager which will have all the office info
	// This provides a clear way to get the singleton instance of OfficeManager
    protected OfficeManager getOfficeManager() {
        return OfficeManager.getInstance();
    }
    
    // function imitates logging into the system
    // does so by simply setting the user in user view
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();

        OfficeManager officeManager = getOfficeManager();
        User user = officeManager.getPatientByUserName(userName);
        if (user != null) {
        	this.setUser(user);
        	scanner.close();
            return true;
        } else {
            System.out.println("Login failed.");
            scanner.close();
            return false;
        }
    }


    //getter and setter
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}

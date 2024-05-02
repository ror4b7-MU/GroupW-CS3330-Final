package user_views;
import office_manager.OfficeManager;

public abstract class UserView {

	//
	
	//Provide Access the to OfficeManager which will have all office info
	// This provides a clear way to get the singleton instance of OfficeManager
    protected OfficeManager getOfficeManager() {
        return OfficeManager.getInstance();
    }
	
}

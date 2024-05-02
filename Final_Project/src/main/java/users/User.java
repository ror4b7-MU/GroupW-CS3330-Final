package users;

// superclass for patients and doctors, meant to eliminate redundant code
public class User {
    // shared variables that both usertypes share
    private String name;
    private String surname;
    private String birthdate;
    private String userName; // unique identifier for any user

    public User(String name, String surname, String birthdate, String userName) {
        this.name=name;
        this.surname=surname;
        this.birthdate=birthdate;
        this.userName = userName;
    }

    public String toString()
    {
        return(this.name + " " + this.surname + ", Username: " + this.userName + "\n");  
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

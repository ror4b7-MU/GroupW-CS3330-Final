package users;

// superclass for patients and doctors, meant to eliminate redundant code
public class User {
    // shared variables that both usertypes share
    private String name;
    private String surname;
    private String birthdate;

    public User(String name, String surname, String birthdate) {
        this.name=name;
        this.surname=surname;
        this.birthdate=birthdate;
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

}

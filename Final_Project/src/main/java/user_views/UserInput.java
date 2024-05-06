package user_views;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import office_manager.OfficeManager;
import users.Doctor;
import users.User;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);
    public UserInput() {
       
    }


    //This method requetss a string from the user
    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }


    //This method requests a valid integer
    //Builds off the getString method
    public static int getValidInt(String prompt) 
    {

        String userInput = getString(prompt); 

        if (checkValidInt(userInput))
        {
            return Integer.parseInt(userInput); 
        }

        else 
        {
            System.out.print("Invalid input: Please try again \n"); 
            return getValidInt(prompt); 
        }

    }


    //This method gets a validUser from the user
    //Builds off of getString and getUserByUserName
    public static User getValidUser(String prompt, OfficeManager office)
    {
        String userInput = getString(prompt); 


        User user = office.getUserByUserName(userInput); 

        if (user == null)
        {
            System.out.println("Could not find valid user");
            return getValidUser(prompt, office); 
        }

        else 
        {
            return user; 
        }

    }  


    //THis method gets a validDate from the user
    //Builds off of the Calendar and getString
    public static Calendar getValidDate(String prompt) {

            
            String input = getString(prompt); 

            try {
                String[] parts = input.split("-");
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);
                int hour = Integer.parseInt(parts[3]);
                int minute = Integer.parseInt(parts[4]);

                Calendar calendar = new GregorianCalendar(year, month - 1, day, hour, minute);
                return calendar;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a date in the format YYYY-MM-DD-HH-mm.");
                return getValidDate(prompt); 
            }
    }


    //This method gets a valid doctor
    //Builds off of getUser and checkValidDocotr methods
    public static Doctor getValidDoctor(String prompt, OfficeManager office)
    {
        User user = getValidUser(prompt, office); 

        if (checkValidDoctor(user) == true)
        {

        return (Doctor) user; 
        }


        else 
        {
            return getValidDoctor(prompt, office); 
        }

        
    }


    //This checks for a validInt
    private static boolean checkValidInt(String check) {
        try {
            Integer.parseInt(check);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    //This method checks to make sure a user is a doctor
    private static boolean checkValidDoctor(User user) {
    try {
        // Doctor doctor = (Doctor) user; 
        return true; 
    } catch (ClassCastException e) {
        return false;
    }

}

    public static void closeScanner()
    {
        scanner.close(); 
    }
}

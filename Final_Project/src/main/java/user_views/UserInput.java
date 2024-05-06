package user_views;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);
    private UserInput() {
       
    }

    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

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

    private static boolean checkValidInt(String check) {
        try {
            Integer.parseInt(check);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void closeScanner()
    {
        scanner.close(); 
    }
}

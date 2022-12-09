package Project;

import java.io.*;
import java.sql.*;
import java.util.Scanner;
// TODO
// SQL ERROR - Menu.StartExercises
// check chooseExercise method and if it works
// adjust/add System out print texts where applicable
// method to tell user how many points were acquired during last session
// startExercise - case 2 - finish session

// optional
// methods to enter user data - name, email, physique, goal
// methods to "register" & "login"
// methods to add/change exercises

import static Project.Menu.mainMenu;


public class Main {
    public static String jdbcURL = "jdbc:mysql://localhost:3306/exercisetracker";
    public static String username = "root";
    public static String password = "Kakajunn006!";
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {

//        Console console = System.console();
//        console = (Console) mainMenu();
//        System.out.println("Application has been shut down");

        mainMenu();

//<<<<<<< Updated upstream
        try(Connection connection = DriverManager.getConnection(jdbcURL, username, password)){

            if (connection != null){
                System.out.println("Connected to the database");

                connection.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
//=======
//>>>>>>> Stashed changes
    }

    // TODO correct validation
    public static int choiceFromTo( int number, int num){
        int choice;
        do {
            choice = validatesInputNumber();
            if ((choice < number) || (choice > num)) {
                System.out.println("There is no such option.");

            }
        }while ((choice < number) || (choice > num));

        return choice;
    }

    //checks input for a number
    public static int validatesInputNumber() {
        int numb;
        int number = 0;
        do {
            numb = 0;
            try {
                number = scanner.nextInt();
            } catch (Exception e) {
                System.out.printf("%s - is not an integer.%n", scanner.next());
                numb = 1;
            }
        } while (numb == 1);

        return number;
    }


}

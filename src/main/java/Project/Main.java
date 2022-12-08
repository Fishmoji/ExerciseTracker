package Project;

import java.io.*;
import java.sql.*;
// TODO
// make both Console and Connection work together without errors
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
    public static void main(String[] args) throws SQLException {

        Console console = System.console();
        console = mainMenu(console);
        System.out.println("Application has been shut down");


        String jdbcURL = "jdbc:mysql://localhost:3306/exercisetracker";
        String username = "root";
        String password = "Kakajunn006!";
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            if (connection != null){
                System.out.println("Connected to the database");

                connection.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {

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
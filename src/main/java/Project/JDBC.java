package Project;

import java.sql.*;

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

  /*  public static void drop(Connection con) throws SQLException {
        Statement dropStatement =  con.createStatement();
        dropStatement.execute("DROP TABLE IF EXISTS tracker");
    }

    public static void createDB(Connection con) throws SQLException{

        Statement createTableStatement = con.createStatement();
        String createTableQuery = "CREATE DATABASE IF NOT EXISTS exercisetracker";
        createTableStatement.execute(createTableQuery);

    }
    public static void createTable(Connection con) throws SQLException{

        Statement createTableStatement = con.createStatement();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS tracker ("+
                "activityID INT NOT NULL AUTO_INCREMENT, "+
                "lastupdate DATETIME DEFAULT CURRENT_TIMESTAMP, "+
                "pointsGranted INT, "+
                "PRIMARY KEY (activityID)";
        createTableStatement.execute(createTableQuery);

    }

    public static void insert(Connection con) throws SQLException{
        Statement insertItemStatement = con.createStatement();
        String insertEasyPoints = "INSERT INTO tracker (pointsGranted) VALUES (10)";
        String insertMediumPoints = "INSERT INTO tracker (pointsGranted) VALUES (15)";
        String insertHardPoints = "INSERT INTO tracker (pointsGranted) VALUES (20)";
        insertItemStatement.executeUpdate(insertEasyPoints);
        insertItemStatement.executeUpdate(insertMediumPoints);
        insertItemStatement.executeUpdate(insertHardPoints);
    } */
}
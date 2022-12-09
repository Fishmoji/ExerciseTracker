package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exercisetracker", "root","Kakajunn006!");

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM tracker");

            while (result.next()){
                System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getInt(3));
            }

            con.close();

        }catch (Exception e){
            System.out.println(e);
        }


    }
}

package Project;

import java.io.Console;
import java.sql.*;
import java.util.*;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static int selection;

    public static Object mainMenu(Console console) throws SQLException {
        System.out.println("Welcome to the exercise tracker");

        do {
            System.out.println("MAIN MENU");
            System.out.println("--------------\n");
            System.out.println("[1] - Profile");
            System.out.println("[2] - Log exercise");
            System.out.println("[0] - Exit");

            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1: profileMenu(console);
                    break;
                case 2: startExercise(console);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 0);
        return console;
    }

    public static void profileMenu(Console console, Connection connection) throws SQLException {

        do {

            System.out.println("Select option: ");
            System.out.println("--------------\n");
            System.out.println("1 - Points");
            System.out.println("2 - Goals");
            System.out.println("0 - Exit");


            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1: totalPoints(connection);
                    break;
                case 2: goals(console);
                    break;
                case 0: mainMenu(console);
                    break;
                default:
                    System.out.println("Selection invalid");
                    break;
            }
        }
        while (selection != 3);
        return;

    }
    public static void totalPoints(Connection connection) throws SQLException {

        Statement readItemStatement = connection.createStatement();
        String readItemsQuery = "SELECT SUM(pointsGranted) FROM tracker";
        ResultSet rs = readItemStatement.executeQuery(readItemsQuery);

        while (rs.next()) {
            rs.getInt("activityID");
            rs.getString("lastupdate");
            rs.getInt("pointsGranted");

        }
    }
    public static void goals(Console console) {
        return;
     }

    public static void startExercise(Console console, Connection connection) throws SQLException {

        do {
            System.out.println("Let's start exercising");
            System.out.println("--------------\n");
            System.out.println("1 - Choose exercise");
            System.out.println("2 - Finish session");
            System.out.println("0 - Exit");


            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    chooseExercise(connection);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0: mainMenu(console);
                    break;
                default:
                    System.out.println("Selection invalid");
                    break;
            }
        }
        while (selection != 3);
        return;

    }

    public static void chooseExercise(Connection connection) throws SQLException {
        Statement insertItemStatement = connection.createStatement();
        String insertEasyPoints = "INSERT INTO tracker (lastupdate, pointsGranted) VALUES (now(), 10)";
        String insertMediumPoints = "INSERT INTO tracker (lastupdate, pointsGranted) VALUES (now(), 15)";
        String insertHardPoints = "INSERT INTO tracker (lastupdate, pointsGranted) VALUES (now(), 20)";

        System.out.println("[1] - push-up - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[2] - pull-up - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[3] - lunge - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[4] - plank - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[5] - squat - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[6] - mountain climber - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[7] - burpee - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[8] - inchworm - [E] - x5 - [M] - x15 - [H] - x25");
        System.out.println("[9] - russian twist - [E] - x5 - [M] - x15 - [H] - x25");

        String nextExercise = scanner.next();
        String nextDifficulty = scanner.next();

        if (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("E")) {
            insertItemStatement.executeUpdate(insertEasyPoints);


        }

        else if (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("M")) {
            insertItemStatement.executeUpdate(insertMediumPoints);
        }

        else if
        (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                        || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                        || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("H")) {
            insertItemStatement.executeUpdate(insertHardPoints);
        }
        return;
    }

}

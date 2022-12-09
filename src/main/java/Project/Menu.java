package Project;

import color.Color;
import java.sql.*;
import java.util.*;


public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static int selection;

    static int sum = 0;

    public static void mainMenu() throws SQLException {
        System.out.println("Welcome to the exercise tracker");


        do {
            System.out.println("--------------\n");
            System.out.println("MAIN MENU");
            System.out.println(" ");
            System.out.println("[1] - Profile");
            System.out.println("[2] - Log exercise");
            System.out.println("[0] - Exit");

            System.out.print("Insert selection: ");
            selection=Main.choiceFromTo(0,2);

            switch (selection) {
                case 1:
                    profileMenu();
                    break;
                case 2:
                    startExercise();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 0);
    }

    public static void profileMenu() {
        try (Connection connection = DriverManager.getConnection(Main.jdbcURL, Main.username, Main.password)) {
            do {

                System.out.println("--------------\n");
                System.out.println("Select option: ");
                System.out.println(" ");
                System.out.println("1 - Points");
                System.out.println("2 - Goals");
                System.out.println("0 - Exit");


                System.out.print("Insert selection: ");
                selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        totalPoints(connection);
                        break;
                    case 2:
                        goals();
                        break;
                    case 0:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Selection invalid");
                        break;
                }
            }
            while (selection != 3);

        } catch (SQLException e) {
            System.out.println(Color.ANSI_YELLOW+"SQL ERROR - Menu.ProfileMenu()"+ Color.ANSI_RESET);
            e.printStackTrace();

        }

    }

    public static void totalPoints(Connection connection) throws SQLException {

        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT SUM(pointsGranted) as pointsSum FROM tracker");

        while (res.next()) {
            int pointsSum = res.getInt(1);
            sum = sum + pointsSum;
        }
        System.out.println("Total point count: " + sum);
    }

    public static void goals() {
        return;
    }

    public static void startExercise() {

        try(Connection connection = DriverManager.getConnection(Main.jdbcURL, Main.username, Main.password)) {
            do {
                System.out.println("--------------\n");
                System.out.println("Let's start exercising");
                System.out.println(" ");
                System.out.println("1 - Choose exercise");
                System.out.println("2 - Finish session");
                System.out.println("0 - Exit");


                System.out.print("Insert selection: ");
                selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        chooseExercise();
                        startExercise();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Selection invalid");
                        break;
                }
            }
            while (selection != 3);
        }catch (SQLException e){
            System.out.println(Color.ANSI_YELLOW+"SQL ERROR - Menu.StartExercise()"+Color.ANSI_RESET);
        }

    }

    public static void chooseExercise() throws SQLException {
            char choice = 0;
            do {
                try (Connection connection = DriverManager.getConnection(Main.jdbcURL, Main.username, Main.password)) {
                    Statement insertItemStatement = connection.createStatement();
                    String insertEasyPoints = "INSERT INTO tracker (pointsGranted) VALUES (10)";
                    String insertMediumPoints = "INSERT INTO tracker (pointsGranted) VALUES (15)";
                    String insertHardPoints = "INSERT INTO tracker (pointsGranted) VALUES (20)";

                    System.out.println("[1] - push-up - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[2] - pull-up - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[3] - lunge - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[4] - plank - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[5] - squat - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[6] - mountain climber - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[7] - burpee - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[8] - inchworm - [E] - x5 - [M] - x15 - [H] - x25");
                    System.out.println("[9] - russian twist - [E] - x5 - [M] - x15 - [H] - x25");

                    String nextExercise = Main.scanner.next();
                    String nextDifficulty = Main.scanner.next();

                    if (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                            || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                            || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("E")) {
                        insertItemStatement.executeUpdate(insertEasyPoints);


                    } else if (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                            || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                            || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("M")) {
                        insertItemStatement.executeUpdate(insertMediumPoints);
                    } else if
                    (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                                    || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                                    || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("H")) {
                        insertItemStatement.executeUpdate(insertHardPoints);


                    }
                } catch (SQLException e) {
                    System.out.println(Color.ANSI_YELLOW + "SQL ERROR - Menu.ProfileMenu()" + Color.ANSI_RESET);
                    e.printStackTrace();

                }


                do {
                    System.out.println("Would you like to do another one? - y/n");
                    choice = Main.scanner.next().charAt(0);

                    if (choice != 'y' && choice != 'n') {
                        System.out.println("Choose the right option");
                    }
                } while (choice != 'n' && choice != 'y');

            } while (choice != 'n');
        }

}
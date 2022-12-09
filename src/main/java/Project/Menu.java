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
                System.out.println("2 - Go to exercise menu");

                //  System.out.println("2 - Goals");
                System.out.println("0 - Exit");


                System.out.print("Insert selection: ");
                selection = scanner.nextInt();

                switch (selection) {
                    case 1 -> totalPoints(connection);
                    case 2 -> startExercise();
                    case 0 -> mainMenu();
                    default -> System.out.println("Selection invalid");
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
        System.out.println("\nTotal point count: " + sum);
    }

  /*  public static void goals() {
        return;
    } */

    public static void startExercise() {

        try(Connection connection = DriverManager.getConnection(Main.jdbcURL, Main.username, Main.password)) {
            do {
                System.out.println("--------------\n");
                System.out.println("Let's start exercising");
                System.out.println(" ");
                System.out.println("1 - Choose exercise");
                System.out.println("2 - See total score");
                System.out.println("0 - Exit");


                System.out.print("Insert selection: ");
                selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        chooseExercise();
                        startExercise();
                        break;
                    case 2: totalPoints(connection);
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


                List<String> id = new ArrayList<>();
                id.add("1");
                id.add("2");
                id.add("3");
                id.add("4");
                id.add("5");
                id.add("6");
                id.add("7");
                id.add("8");
                id.add("9");

                List<String> physicalExercise = new ArrayList<>();
                physicalExercise.add("E");
                physicalExercise.add("M");
                physicalExercise.add("H");

                // variables
                String nextExercise;
                String nextDifficulty ;

                //ask what exercise did you do
                boolean select=false;
                do {
                    System.out.println("Choose an exercise");
                    nextExercise = Main.scanner.next();
                    for (String exercise: id) {
                        if (nextExercise.equals(exercise)){
                            select =true;
                        }
                    }
                }while (!select);



                //asking for physical activity
                select=false;
                do {
                    System.out.println("Choose difficulty");
                    nextDifficulty = Main.scanner.next();
                    for (String grade: physicalExercise) {
                        if (nextDifficulty.toUpperCase().equals(grade)){
                            select =true;
                        }
                    }
                }while (!select);

                // Grade goes to data
                if (nextDifficulty.equals(physicalExercise.get(0))) {
                    insertItemStatement.executeUpdate(insertEasyPoints);
                } else if (nextDifficulty.equals(physicalExercise.get(1))) {
                    insertItemStatement.executeUpdate(insertMediumPoints);
                } else {
                    insertItemStatement.executeUpdate(insertHardPoints);
                }
                totalPoints(connection);


            } catch(SQLException e){
                System.out.println(Color.ANSI_YELLOW + "SQL ERROR - Menu.ProfileMenu()" + Color.ANSI_RESET);
                e.printStackTrace();

            }

            do {
                System.out.println("Add another exercise? - y/n");
                choice = Main.scanner.next().toLowerCase().charAt(0);

                if (choice != 'y' && choice != 'n') {
                    System.out.println("Choose a valid option");
                }
            } while (choice != 'n' && choice != 'y');

        } while(choice !='n');
    }

}
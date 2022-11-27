package Project;

import java.io.Console;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static int selection;
    public static Console mainMenu(Console console) {
        System.out.println("Welcome to the exercise tracker");

        do {
            System.out.println("MAIN MENU");
            System.out.println("--------------\n");
            System.out.println("[1] - Profile");
            System.out.println("[2] - Exercises");
            System.out.println("[3] - Rewards");
            System.out.println("[4] - Start session");

            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    return profileMenu(console);
                case 2:
                    return exercisesMenu(console);
                case 3:
                    return rewardsMenu(console);
                case 4:
                    return startSession(console);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 4);
        return console;
    }


    public static Console profileMenu(Console console) {

        do {

            System.out.println("Select option: ");
            System.out.println("--------------\n");
            System.out.println("1 - Avatar settings");
            System.out.println("2 - Profile settings");
            System.out.println("0 - Exit");


            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1: setAvatar(console);
                    break;
                case 2: profileSettings(console);
                    break;
                case 3: scoreBoard(console);
                    break;
                case 0: mainMenu(console);
                break;
                default:
                    System.out.println("Selection invalid");
                    break;
            }
        }
        while (selection != 3);
        return console;

    }
    public static Console setAvatar(Console console) {

        return console;
    }
     public static Console profileSettings(Console console) {

         return console;
     }
    public static Console scoreBoard(Console console) {

        return console;
    }

    public static Console exercisesMenu(Console console) {

        do {
            System.out.println("Select option: ");
            System.out.println("--------------\n");
            System.out.println("1 - All exercises");
            System.out.println("2 - Edit exercises");
            System.out.println("4 - New routine");
            System.out.println("0 - Exit");


            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
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
        return console;


    }

    public static Console rewardsMenu(Console console) {

        do {
            System.out.println("Select option: ");
            System.out.println("--------------\n");
            System.out.println("1 - Personal goals");
            System.out.println("2 - Scoreboard");
            System.out.println("3 - Promotions");
            System.out.println("4 - Challenges");
            System.out.println("0 - Exit");


            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
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
        return console;


    }

    public static Console startSession(Console console) {

        do {
            System.out.println("Select option: ");
            System.out.println("--------------\n");
            System.out.println("1 - Choose routine");
            System.out.println("2 - Choose exercise");
            System.out.println("3 - Finish session");
            System.out.println("0 - Exit");


            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
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
        return console;


    }
}

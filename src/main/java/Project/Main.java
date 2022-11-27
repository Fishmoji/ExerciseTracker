package Project;

import java.io.Console;
import java.util.Scanner;

import static Project.Menu.mainMenu;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        console = mainMenu(console);
        System.out.println("Application has been shut down");
    }
}
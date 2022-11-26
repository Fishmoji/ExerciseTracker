package Project;

import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);
        console = Menu.mainMenu(console);
        System.out.println("Application has been shut down");
    }
}
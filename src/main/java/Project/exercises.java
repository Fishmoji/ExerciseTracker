package Project;

import java.io.Console;
import java.lang.constant.Constable;

import static Project.Menu.scanner;

public class exercises {

    public static int chooseExercise(Console console) {
        int easypoints = 10;
        int mediumpoints = 15;
        int hardpoints = 20;

        int scorecount = 0;

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
            scorecount = scorecount + easypoints;

        }

       else if (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("M")) {
            scorecount = scorecount + mediumpoints;
       }

        else if
            (nextExercise.equals("1") || nextExercise.equals("2") || nextExercise.equals("3") || nextExercise.equals("4")
                    || nextExercise.equals("5") || nextExercise.equals("6") || nextExercise.equals("7")
                    || nextExercise.equals("8") || nextExercise.equals("9") && nextDifficulty.equals("H")) {
            scorecount = scorecount + hardpoints;
        }
            return scorecount;
        }

}

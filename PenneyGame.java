import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

public class PenneyGame {
    private static Scanner input = new Scanner(System.in);
    private static String exit = "You won't see me again";

    private static String cpuChoice = "HHH";
    private static String pChoice = "HTH";

    //Simple wait funciton
    private static void wait(int ms) {
        try { //.sleep() for `ms` MILLISECONDS
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    //coinFlip
    private static String coinFlip(boolean print) {
        int randomFlip = (int)( Math.random()*2 ); //range 0-1
        if (randomFlip==1) {
            if (print) System.out.print("Heads! ");
            return "H";
        } else {
            if (print) System.out.print("Tails!");
            return "T";
        }
    }

    //Intro
    public static void main(String[] args) {
        System.out.println("A coin will be flipped over and over.");
        wait(200);
        System.out.println("The goal is to predict a sequence emerging from the flips,");
        wait(200);
        System.out.println("Would you like to see an example?");
        exampleYN();
    }
    public static void exampleYN() {
        
    }
    public static void example() {
        System.out.println("I'll bet that the coin lands on Heads three times ina row.");
        wait(100);
        System.out.println("Let's say you then bet that HTH happens first.");
        wait(300);
        System.out.println("\Game simulation:");
        String flips = "";
        for (int i=0; i<100; i++) {
            flips += coinFlip(true);
            wait(400);
            if (flips.indexOf(cpuChoice)!=-1) {
                System.out.println("\nI won!");
                break;
            } else if (flips.indexOf(pChoice)!=-1) {
                System.out.println("\nYou won!");
                break;
            }
            if (i==99)
                System.out.println("I'll stop here");
        }
    }
}
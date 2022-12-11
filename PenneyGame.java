import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

public class PenneyGame {
    private static Scanner input = new Scanner(System.in);
    private static String exitMsg = "You won't see me again";

    //Simple wait funciton
    private static void wait(int ms) {
        try { //.sleep() for `ms` MILLISECONDS
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        //
        System.out.println("This is a game about flipping pennies")
    }
}
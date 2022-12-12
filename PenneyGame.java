import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class PenneyGame {
    /**
     * @param ms number of milliseconds to sleep for
     */
    private static void wait(int ms) {
        try { //.sleep() for `ms` MILLISECONDS
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    /**
     * @return pseudo-random  0 or 1
     */
    private static int coinFlip() {
        return (int)( Math.random()*2 );
    }
    //
    private static Scanner input = new Scanner(System.in);
    //
    public static void main(String[] args) {
        System.out.println("A coin will be flipped over and over.");
        System.out.println("The goal is to predict a pattern appearing, Ex: 3 heads ina row.");
        wait(200);
        System.out.println("Would you like to see an example?");
        if (chooseExample()) {
            example();
        }
        System.out.println("Okay, how'd you like to play this?\n"
                    +"  0) Easy: I choose first, randomly\n"
                    +"  1) Normal: I choose first, strategically\n"
                    +"  2) Hard: You choose first, I choose strategically");
        int difficulty = chooseDifficulty();

        if (difficulty!=2) {
            String cpuChoice = cpuChoice(difficulty,"");
            System.out.println("I'll bet on "+cpuChoice+"\nNow you choose:");
            String pChoice = pChoice();
        } else {
            System.out.println("Alright, you choose first");
            String pChoice = pChoice();
            String cpuChoice = cpuChoice(difficulty,pChoice);
            System.out.println("In that case I'll bet on "+cpuChoice);
        }
        

        
        
        input.close();
    }
    public static boolean chooseExample() {
        // Input, Yes/No
    }
    public static void example() {
        // Simulate game
    }
    public static int chooseDifficulty() {
        // Input: 0,1,2 or e,n,h or easy,normal,hard
    }
    /**
     * @param difficulty 0)Easy; choose random. 1)Normal; strategy. 2)Hard; reply to pChoice
     * @param pChoice should be in HHT format
     * @return cpu's choice
     */
    public static String cpuChoice(int difficulty,String pChoice) {
        // 
    }
    public static String pChoice() {
        // Input: idek yet
    }
}
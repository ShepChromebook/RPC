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
        for (int i=0; i<3; i++) {
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
                String pChoice = pChoice(cpuChoice);
            } else {
                System.out.println("Alright, you choose first");
                String pChoice = pChoice("");
                String cpuChoice = cpuChoice(difficulty,pChoice);
                System.out.println("In that case I'll bet on "+cpuChoice);
            }
            
            play(pChoice,cpuChoice);
        }
        System.out.println("Imma stop now");
        input.close();
    }
    /**
     * @return true if player inputs "yes"/"y", false otherwise
     */
    public static boolean chooseExample() {
        String INPUT = input.nextLine().toLowerCase();
        if (INPUT.equals("yes") || INPUT.equals("y"))
            return true;
        //else
            System.out.println("Skipping the example then");
            return false;
    }
    /**
     * Simulate game
     */
    public static void example() {
        System.out.println("Simulate");
    }
    /**
     * @return player's input as 0/e/easy=0, 1/n/normal=1, else=2
     */
    public static int chooseDifficulty() {
        // Input: 0,1,2 or e,n,h or easy,normal,hard
        String INPUT = input.nextLine().toLowerCase();
        switch (INPUT) {
            case 0: case "e": case "easy":
                System.out.println("Guess I'll play like a noob");
                return 0;
            case 1: case "n": case "normal":
                return 1;
            default: case "h": case "hard":
                System.out.println("Hard it is then")
                return 2;
        }
    }
    /**
     * @param difficulty 0)Easy; choose random. 1)Normal; strategy. 2)Hard; reply to pChoice
     * @param pChoice should be in HHT format
     * @return cpu's choice, cannot == pChoice
     */
    public static String cpuChoice(int difficulty,String pChoice) {
        if (difficulty==0) {
            int random8 = (int)(Math.random()*8);
            switch (random8) {
                case "HHH";
                case "HHT";
                case "HTH";
                case "HTT";
                case "THH";
                case "THT";
                case "TTH";
                case "TTT";
            }
        } if (difficulty==1) {
            int random4 = (int)(Math.random()*4);
            switch (random4) {
                case "THH"; //7:1 3:1
                case "HHT"; //2:1 2:1
                case "TTH"; //2:1 2:1
                case "HTT"; //7:1 3:1
            }
        } if (difficulty==2) {
            String y = pChoice.charAt(1)
            if (y.equals("H")) y = "T";
            else y = "H";
            return y + pChoice.charAt(0)+pChoice.charAt(1);
        }
    }
    /**
     * @return player's choice in HTH format if != cpuChoice
     * @param cpuChoice
     */
    public static String pChoice(String cpuChoice) {
        while (true) {
            String INPUT = input.nextLine().toUpperCase();
            switch (INPUT) {
                case "HHH": case "HHT": case "HTH": case "HTT":
                case "THH": case "THT": case "TTH": case "TTT":
                return INPUT;
            } System.out.println("I didn't understand that. Try saying HHH");
        }
    }
    public static void player(String pChoice,String cpuChoice) {
        //Call coin flip over and over until pChoice or cpuChoice happens
    }
}
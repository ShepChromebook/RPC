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
    private static String coinFlip() {
        if ( (int)( Math.random()*2 ) == 0)
            return "H";
        return "T";
    }
    //
    private static Scanner input = new Scanner(System.in);
    //
    public static void main(String[] args) {
    while (true) {

        System.out.println("A coin will be flipped over and over.");
        System.out.println("The goal is to predict a pattern appearing, Ex: 3 heads ina row.");
        wait(200);

        System.out.println("Would you like to see an example?");
        if (chooseExample())
            example();

        System.out.println("Okay, how'd you like to play this?\n"
                    +"  0) Easy: I choose first, randomly\n"
                    +"  1) Normal: I choose first, strategically\n"
                    +"  2) Hard: You choose first, I choose strategically");
        int difficulty = chooseDifficulty();

        String pChoice = "";
        String cpuChoice = "";
        if (difficulty!=2) {
            cpuChoice = cpuChoice(difficulty,"");
            System.out.println("I'll bet on "+cpuChoice+"\nNow you choose:");
            pChoice = pChoice(cpuChoice);
        } else {
            System.out.println("Alright, you choose first");
            pChoice = pChoice("");
            cpuChoice = cpuChoice(difficulty,pChoice);
            System.out.println("In that case I'll bet on "+cpuChoice);
        }
        
        System.out.println("\n"+play(pChoice,cpuChoice));
        
    }
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
            case "0": case "e": case "easy":
                System.out.println("Guess I'll play like a noob");
                return 0;
            case "1": case "n": case "normal":
                System.out.println("Aight, I'll go first");
                return 1;
            default:
                System.out.println("Hard it is then");
                return 2;
        }
    }
    /**
     * @param difficulty 0)Easy; choose randomly  1)Normal; strategy  2)Hard; reply to pChoice
     * @param pChoice If difficulty is not 0 or 1, pChoice is required and needs to be in "HHT" format
     * @return cpu's choice (Note: pChoice is only taken into account when difficulty is not 0 or 1)
     */
    public static String cpuChoice(int difficulty,String pChoice) {
        if (difficulty==0 || difficulty==1) {
            int random8 = (int)(Math.random()*8);
            if (difficulty==1) { random8 /= 2; }

            switch (random8) { //"HHH" "HHT" "HTH" "HTT" "THH" "THT" "TTH" "TTT"
                case 0: return "THH"; //7:1 3:1
                case 1: return "HHT"; //2:1 2:1
                case 2: return "TTH"; //2:1 2:1
                case 3: return "HTT"; //7:1 3:1

                case 4: return "HHH";
                case 5: return "HTH";
                case 6: return "THT";
                case 7: return "TTT";
            }
        }
        if (pChoice.charAt(1)=='H')
            return "T" + pChoice.charAt(0)+pChoice.charAt(1);
        else
            return "H" + pChoice.charAt(0)+pChoice.charAt(1);
    }
    /**
     * @return player's choice in HTH format if != cpuChoice
     * @param cpuChoice
     */
    public static String pChoice(String cpuChoice) {
        while (true) {
            String INPUT = input.nextLine().toUpperCase();
            switch (INPUT) {
                case "HHH": case "HHT": case "HTH": case "HTT": case "THH": case "THT": case "TTH": case "TTT":
                    if (!INPUT.equals(cpuChoice))
                        return INPUT;
                    //Else
                    System.out.println("Hey I already chose "+cpuChoice+". Try something else");
                    break;
                default:
                    System.out.println("I didn't understand that. Try saying HHH");
            }
        }
    }
    public static String play(String pChoice,String cpuChoice) {
        System.out.println("\nNow flipping!");
        String flips = "";
        while (true) {
            flips += coinFlip();
            System.out.print(""+flips.charAt(flips.length()-1));
            
        if (flips.length()>=3)
            if (flips.substring(flips.length()-3).equals(cpuChoice))
                return "I win!!!";
            else if (flips.substring(flips.length()-3).equals(pChoice))
                return "You won!";
            

            wait(300);
        }
    }
}
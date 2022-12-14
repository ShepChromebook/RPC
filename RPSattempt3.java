import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
public class RPSattempt3 {
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
     * Prints out str, except waits `ms` milliseconds before printing each '.' & '!'
     * @param str string to iterate through
     * @param ms number of milliseconds to wait for
     */
    private static void suspensefulPrint(String str,int ms) {
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i)=='.' || str.charAt(i)=='!')   //CHANGE THIS TO SMTH ELSE!!!
                wait(ms);
            System.out.print(str.charAt(i));
        }
    }
    // easier to have as static rater than passing down and back up through 3 methods
    private static Scanner input = new Scanner(System.in);
    private static int pWins = 0;
    private static int cpuWins = 0;
    //

    /* =================================== */

    public static void main(String[] args) {
        while(true) {
            System.out.println("Wanna play Rock Paper Scissors?");
            if (!choosePlay())
                break;
            
            System.out.println("How many games should we do?");
            int numOfGames = chooseNumOfGames();
            while (pWins+cpuWins < numOfGames && (pWins <= numOfGames/2) && (cpuWins <= numOfGames/2))
            {    
                System.out.println("Choose Rock(R), Paper(P), or Scissors(S)");
                int pChoice = pChoice();

                int cpuChoice = (int)(Math.random()*3); //range 0-2
                suspensefulPrint("Alright.. I choose... "+cpuChoiceToString(cpuChoice),400);

                printFists(pChoice,cpuChoice);
                wait(300);
                System.out.println( whoWon(pChoice, cpuChoice) );
                wait(500);
                System.out.println("You: "+RPSattempt3.pWins+"  Me: "+RPSattempt3.cpuWins);
                wait(500);
            }
            System.out.println("Oop we're done!");
            
            suspenseful
        }
        System.out.println("goodbye");
        input.close();
    }
    /**
     * @return player input, y/yes=true   Else=false
     */
    public static boolean choosePlay() {
        String INPUT = input.nextLine().toLowerCase();
        if (INPUT.equals("yes") || INPUT.equals("y"))
            return true;
        return false;
    }
    /**
     * @return First positive (!=0) integer that player inputs. Keeps asking until a correct int is entered.
     */
    public static int chooseNumOfGames() {
        while (true) {
            String INPUT = input.nextLine();
            if (Pattern.matches("^[1-9]+[0-9]*$",INPUT)) //if matchFound
                return Integer.parseInt(INPUT);         
            else
                System.out.println("I didn't understand that, try saying \"3\"");
        }
    }
    /**
     * @return Player's choice, Rock=0 Paper=1 Scissors=2
     */
    public static int pChoice() {
        while (true) {
            String INPUT = input.nextLine().toLowerCase();
            switch (INPUT) {
                case "rock": case "r": case "0":
                    return 0;
                case "paper": case "p": case "1":
                    return 1;
                case "scissors": case "s": case "2":
                    return 2;
            }
            System.out.println("I didn't understand that. Try saying \"Scissors\"");
        }
    }
    /**
     * @param cpuChoice the cpu's choice as 0, 1, or 2
     * @return 0=ROCK! 1=PAPER!  Else=SCISSORS!
     */
    public static String cpuChoiceToString(int cpuChoice) {
        switch (cpuChoice) {
            case 0: return "ROCK!";
            case 1: return "PAPER!";
            default: return "SCISSORS!";
        }
    }
    /**
     * Prints out the fists
     * @param pChoice @param cpuChoice MUST be 0, 1, or 2.
     */
    public static void printFists(int pChoice, int cpuChoice) {
        String[] leftRPS = new String[] {
            "You _______       ", //'You' to show which side is You or CPU
            "---'   ____)      ", //All of the ascii art is 18 chars
            "      (_____)     ", //In individual lines so I can stack it against the other hand
            "      (_____)     ", //6 lines, 0-5 6-12 13-20
            "      (____)      ",
            "---.__(___)       ",
    
            "You ________      ", //leftRPS[6]
            "---'    ____)____ ",
            "           ______)",
            "           ______)",
            "         _______) ",
            "---.__________)   ",
    
            "You ________      ",
            "---'    ____)____ ",
            "           ______)",
            "       __________)",
            "      (____)      ",
            "---.__(___)       "  };
        String[] rightRPS = new String[] {
            "   CPU _______    ",
            "      (____   '---",
            "     (_____)      ",
            "     (_____)      ",
            "      (____)      ",
            "       (___)__.---",
    
            "  CPU ________    ",
            " ____(____    '---",
            "(______           ",
            "(_______          ",
            " (_______         ",
            "   (__________.---",
    
            "  CPU  _______    ",
            " _____(____   '---",
            "(_______          ",
            "(__________       ",
            "      (____)      ",
            "       (___)__.---"  };
        //
        for (int i=0; i<6; i++) {
            System.out.println( leftRPS[i + 6*(pChoice)] +"    "+rightRPS[i + 6*(cpuChoice)] );
            wait(170);
        }
    }
    /**
     * @param pChoice @param cpuChoice Should be 0, 1, or 2.
     * @return Checks if tied. Checks if player won: 2 beats 0, 0 beats 1, 1 beats 2. Else, cpu won.
     */
    public static String whoWon(int pChoice, int cpuChoice) {
        if ( (pChoice == cpuChoice+1) || (pChoice==0 && cpuChoice==2)) {
            RPSattempt3.pWins++;
            return "You won!";
        }
        if (pChoice == cpuChoice) return "woah, a tie?";
        
        RPSattempt3.cpuWins++;
        return "I WON!!!!";
    }
}
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
public class MyRPS_v1 {
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
        String[] splitStr = str.split("(?<=[.!])"); //"Lookbehind" for chars in [] //Add "lookahead" so consecutives are grouped together (?=[^\.\!])
        for (String part : splitStr) {
            System.out.print(part);
            wait(ms);
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
            
            System.out.println("How many games should we play to?");
            int numOfGames = chooseNumOfGames();
            System.out.println("Aight, best out of "+numOfGames);

            while (pWins+cpuWins < numOfGames && (pWins <= numOfGames/2) && (cpuWins <= numOfGames/2))
            {    
                System.out.println("Choose Rock(R), Paper(P), or Scissors(S)");
                int pChoice = pChoice();

                int cpuChoice = (int)(Math.random()*3); //range 0-2
                suspensefulPrint("Alright.. I choose... "+cpuChoiceToString(cpuChoice)+"\n",400);

                printFists(pChoice,cpuChoice);
                wait(300);
                System.out.print( "\n"+whoWonRound(pChoice, cpuChoice) ); //also updates the win count
                wait(500);
                System.out.println("    You: "+MyRPS_v1.pWins+"  Me: "+MyRPS_v1.cpuWins);
                wait(500);
                System.out.println("_ _ _ _\nNext round:");
            }
            System.out.println("Oop we're done! Looks like the final winner was.. "+whoWonGame());
            wait(500);
            suspensefulPrint("\nNew game in a second....\n\n\n\n",500);
            
            MyRPS_v1.pWins = 0;
            MyRPS_v1.cpuWins = 0;
        }
        System.out.println("goodbye");
        input.close();
    }
    /**
     * @return player input, y/yes=true   Else=false
     */
    public static boolean choosePlay() {
        while (true) {
            String INPUT = input.nextLine().toLowerCase();
            switch (INPUT) {
                case "yes": case "y": case "sure": return true;
                case "no": case "n": case "nah": return false;
            } System.out.println("I didn't understand that, try saying \"yes\"");
        }
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
        }   return "SCISSORS!";
    }
    /**
     * Prints out the fists
     * @param pChoice|cpuChoice MUST be 0, 1, or 2.
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
     * @param pChoice|cpuChoice Should be 0, 1, or 2.
     * @return Checks if tied. Checks if player won: 2 beats 0, 0 beats 1, 1 beats 2. Else, cpu won.
     */
    public static String whoWonRound(int pChoice, int cpuChoice) {
        if ( (pChoice == cpuChoice+1) || (pChoice==0 && cpuChoice==2)) {
            MyRPS_v1.pWins++;
            return "You won!";
        }
        if (pChoice == cpuChoice) return "woah, a tie?";
        
        MyRPS_v1.cpuWins++;
        return "I WON!!!";
    }
    /**
     * @return if MyRPS_v1.pWins > MyRPS_v1.cpuWins return "You!";  Else return "ME!!!!";
     */
    public static String whoWonGame() {
        if (MyRPS_v1.pWins > MyRPS_v1.cpuWins) return "You!";
        if (MyRPS_v1.pWins < MyRPS_v1.cpuWins) return "ME!!!!";
        else    return "o.0 a tie in the final game?";
    }
}
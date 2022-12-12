import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
public class RPSmemoryFix {
    //Easier to have as static fields rather than passing down then back up a chain of 5 methods
    private static Scanner input = new Scanner(System.in);
    private static int pWins = 0;
    private static int cpuWins = 0;
    /**
     * Calls .sleep(ms) and catches InterruptedException
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
     * Prints X "." after Y milliseconds, print \n if newLine
     * @param dotDotDot amount of dots "." to print
     * @param ms amount of milliseconds to wait between dots
     * @param newLine if true print a \n at the end of the "."s
     */
    public static void suspense(int dotDotDot, int ms, boolean newLine) {
        for (int i=0; i<dotDotDot; i++) {
            wait(ms);
            System.out.print(".");
        }
        if (newLine)
            System.out.println();
    }

    public static void main(String[] args) {
        // Get user feedback (First time only)
        System.out.println("Wanna play Rock Paper Scissors?");
        boolean isPlay = choosePlay();
        
        // Execute only if user wants to play
        while (isPlay) {
            System.out.println("How many games should we do? Best out of: _");
            int bestOutOf = chooseBestOutOf();
            System.out.print("Alright! Best out of "+bestOutOf+"!\nNow, ");

            boolean inGame = true;
            while (inGame) {
                System.out.println("Choose Rock (R), Paper (P), or Scissors (S).");
                int pChoice = chooseRPS();
                wait(200);

                //Prints results of round, update pWins & cpuWins, randomizes cpuChoice
                roundResults(pChoice); //Doesnt need to be own method
                wait(1000);

                if (pWins+cpuWins < bestOutOf && pWins < bestOutOf/2 && cpuWins<bestOutOf/2) {
                    System.out.println("    Score: You "+pWins+"  Me "+cpuWins);
                    wait(800);
                    System.out.println("Next round starting in a second..");
                    wait(2800);
                    System.out.println("\n* - * - * - * - * - *");
                } else {
                    System.out.println("---\nOop we're done! Final Score:\nPlayer: "+pWins+"\nMe: "+cpuWins);
                    wait(1000);
                    System.out.println("=============================\n\n\n\n");
                    RPSmemoryFix.pWins = 0;
                    RPSmemoryFix.cpuWins = 0;
                    inGame = false; //breaks loop
                }
            }
            System.out.println("Wanna play again?");
            isPlay = choosePlay();
        }
        // User doesn't want to play
        System.out.println("You won't see me again");
        input.close();
    }
    /**
     * Determines if user wants to play, repeats until INPUT = Yes||No
     * @return true if user wants to play, false otherwise
     */
    public static boolean choosePlay() {
        while (true) {
            String INPUT = RPSmemoryFix.input.nextLine().toLowerCase();

            if (INPUT.equals("yes") || INPUT.equals("y"))
                return true;
            if (INPUT.equals("no") || INPUT.equals("n"))
                return false;
            
            //remember that Else is implied after every return;
            
            System.out.println("I do not understand, try Yes/No.");
        }
    }
    /**
     * Asks User to input an int, repeats until an int is inputted
     * @return returns the int
     */
    public static int chooseBestOutOf() {
        while (true) {
            String INPUT = RPSmemoryFix.input.nextLine();
            //Check for positive ints
            Pattern pattern = Pattern.compile("^[1-9]+[0-9]*$"); //I wrote regex myself :D
            Matcher matcher = pattern.matcher(INPUT);

            if (matcher.find()) //if matchFound
                return Integer.parseInt(INPUT);                
            else
                System.out.println("I didn't understand that, try saying 3");
                //loop from top
        }
    }
    /**
     * Asks user to choose Rock/R, Paper/P, Scissors/S, repeats until INPUT is one of them
     * @return R = 0,  P = 1,  S = 2
     */
    public static int chooseRPS() {
        //loop only exits if INPUT is R, P or S
        while (true) {
            String INPUT = RPSmemoryFix.input.nextLine().toLowerCase();
            switch (INPUT) { //Check R, P, or S. Assign to an int as 1, 2, or 3.
                case "rock": case "r":
                    return 0;
                case "paper": case "p":
                    return 1;
                case "scissors": case "s":
                    return 2;
            } 
            System.out.println("I didn't understand that. Try saying R, P, or S.");
        }
    }

    /**
     * Prints the results of the round, cpuChoice is randomized inside the method
     * @param pChoice player choice, as 0-2
     */
    public static void roundResults(int pChoice) {
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
        //random int range 0-2
        int cpuChoice = (int)( Math.random()*3 );

        System.out.print("\nDrumroll"); suspense(3,200,true);
        System.out.print("I choose"); suspense(4,200,false);
        System.out.println(rpsToString(cpuChoice));
        
        for (int i=0; i<6; i++) {
            System.out.println(leftRPS[i + 6*(pChoice)] +"    "+rightRPS[i + 6*(cpuChoice)]);
            wait(300);
        }
        System.out.println("\n"+whoWon(pChoice,cpuChoice));
    }
    /**
     * Turns an Int into a String
     * @param rps should be 0, 1, or 2
     * @return 0 = "ROCK!"  1 = "PAPER!"  else = "SCISSORS!"
     */
    public static String rpsToString(int rps) {
        if (rps == 0) return "ROCK!";
        if (rps == 1) return "PAPER!";
        return "SCISSORS!";
    }
    /**
     * Sees who won
     * @param pChoice Int 0-2 representing Rock Paper Scissors
     * @param cpuChoice Int 0-2 representing Rock Paper Scissors
     * @return player win requires  1->   3 -> 2 -> 1
     * tie requires pChoice == cpuChoice
     * Else, cpu wins
     */
    public static String whoWon(int pChoice, int cpuChoice) {
        //     2 -> 1 -> 0      //if pChoice is one more than cpuChoice, then player won
        //0 -> 2            //or if pChoice==1 && cpuChoice == 3
        if ( (pChoice == cpuChoice+1) || (pChoice==0 && cpuChoice==2)) {
            RPSmemoryFix.pWins++;
            return "You won!";
        }
        if (pChoice == cpuChoice) return "woah, a tie?";
        
        RPSmemoryFix.cpuWins++;
        return "I WON!!!!";
    }
}
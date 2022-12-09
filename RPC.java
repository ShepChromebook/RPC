import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
public class RPC {
    /* --------- Below is a bunch of fields --------- */
    private static Scanner input = new Scanner(System.in);
    private static String exitMsg = "You won't see me again";

    private static int pWins = 0;
    private static int cpuWins = 0;
    private static int bestOutOf = -1;

    private static String cpuString = "";
    private static int cpuChoice = -1;
    private static int pChoice = -1;

    //The hand on the left, the Player's.
    private static String[] leftRPC = new String[] {
        "You _______       ", //'You' to show which side is You or CPU
        "---'   ____)      ", //All of the ascii art is 18 chars
        "      (_____)     ", //In individual lines so I can stack it against the other hand
        "      (_____)     ",
        "      (____)      ",
        "---.__(___)       ",

        "You ________      ",
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
        "---.__(___)       "
    };
    //the hand on the right, the CPU's.
    private static String[] rightRPC = new String[] {
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
        "       (___)__.---"
    };
    private static void randomCpuChoice() {
        //Randomize cpuChoice
        // *3 gets range 0-2. // +1 transforms to range 1-3.
        cpuChoice = (int)( Math.random()*3+1 );

        //For the final message
        if (cpuChoice == 1) cpuString = "ROCK!";
        else if (cpuChoice == 2) cpuString = "PAPER!";
        else if (cpuChoice == 3) cpuString = "SCISSORS!";
    }
    //A simple wait function
    private static void wait(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static void suspense(int dotDotDot, boolean newLine, int ms) {
        for (int i=0; i<dotDotDot; i++) {
            wait(ms);
            System.out.print(".");
        }
        if (newLine)
            System.out.println();
    }
    /*
     * ====================================================
     *           ^ Above is a bunch of fields ^
     *      -- I should extend to a different class--
     *           v Below interacts with user  v
     * ====================================================
     */

    public static void main(String[] args) {
        //Start the sequence of everything requiring player input
        System.out.println("Wanna play Rock Paper Scissors?");
        start();
    }
    public static void start() {
        //Check Y/N, recursion if gibberish
        String CHOOSE = input.nextLine().toLowerCase();
        if (CHOOSE.equals("no") || CHOOSE.equals("n"))
            System.out.println(exitMsg);
        else if (CHOOSE.equals("yes") || CHOOSE.equals("y")) {
            System.out.println("How many games should we do? Best out of: _");
            chooseBestOutOf();
        } else {
            System.out.println("I didn't understand that. Try Yes/No.");
            start();
        }
    }
    public static void chooseBestOutOf() {
        String INPUT = input.nextLine();
        //Check for positive ints
        Pattern pattern = Pattern.compile("^[1-9]+$"); //I wrote regex myself :D
        Matcher matcher = pattern.matcher(INPUT);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            System.out.println("I didn't understand that. Try saying a positive Integer:");
            chooseBestOutOf();
        }
        bestOutOf = Integer.parseInt(INPUT);
        System.out.println("Alright! Best out of "+bestOutOf);
        wait(200);
        System.out.println("Now, choose Rock (R), Paper (P), or Scissors (S).");
        chooseRPC();
    }
    public static void chooseRPC() {
        //randomize cpu's choice
        randomCpuChoice();
        //Check R, P, or C. Assign to an int as 1, 2, 3.
        String INPUT = input.nextLine().toLowerCase();
        switch (INPUT) {
        case "rock":
        case "r":
            pChoice = 1;
            break;
        case "paper":
        case "p":
            pChoice = 2;
            break;
        case "scissors":
        case "s":
            pChoice = 3;
            break;
        default:
            System.out.println("I didn't understand that. Try saying R, P, or C.");
            chooseRPC();
        }
        System.out.println("Alright!");
        results();
    }
    public static void results() {
        System.out.print(" \nDrumroll");
        suspense(3,true,200);

        System.out.print("I choose");
        suspense(4,false,250);
        System.out.println(" "+cpuString); //output: I choose.... SCISSORS!

        //iterate through 0 to 5 to print lines 0 to 5
        for (int i=0; i<6; i++) {
            System.out.print(leftRPC [i + 6*pChoice - 6]);
            System.out.print("   ");
            System.out.print(rightRPC[i + 6*cpuChoice -6]);
            System.out.println();
            wait(70);
        }

        System.out.print(" \n"+whoWon());

        if (pWins+cpuWins >= bestOutOf) {
            System.out.println(" \n\n---\nOop we're done! Final Score:\nPlayer: "+pWins+"\nMe: "+cpuWins);
            wait(900);
            System.out.println(",\n=============\n");
            pWins = 0;
            cpuWins = 0;
            main(leftRPC);
        } else {
            System.out.println("  Next round starting in a second..");
            wait(1000);
            System.out.println("\n* - * - * - *\nChoose Rock (R), Paper (P), or Scissors (S)");
            chooseRPC();
        }
    }
    public static String whoWon() {
        System.out.println();
        if (pChoice == cpuChoice)
            return "A Tie!!!";
//1 -> 3 -> 2 -> 1
        if (pChoice-1 == cpuChoice || (pChoice==1 && cpuChoice==3)) {
            pWins++;
            return "You won!";
        }
        cpuWins++;
        return "I Won!!!!";
    }
}

import java.util.Scanner;

public class RPSmemoryFix {
    private static Scanner input = new Scanner(System.in);
    private static String exit = "You wont see me again";

    public static void main(String[] args) {
        // Get user feedback for the first time
        System.out.println("Wanna play Rock Paper Scissors?");
        boolean isPlay = isPlay();

        // Execute only if user wants to play
        while (isPlay) {
            
            
            
            // After the current round
            // Ask user again if they want to continue playing
            isPlay = isPlay();
        }
        input.close();
    }

    // Below I'm experimenting with VSCode's Intellisense automatically generating documentation
    /**
     * Determines if user wants to play
     * @return true if user wants to play, false otherwise
     */
    public static boolean isPlay() {
        String INPUT = "";
        
        //loop only exits after Yes or No.
        while (true) {
            INPUT = input.nextLine().toLowerCase();

            if (INPUT.equals("yes") || INPUT.equals("y"))
                return true;
            if (INPUT.equals("no") || INPUT.equals("n"))
                return false;
            
            //remember that Else is implied after every return;
            
            System.out.println("I do not understand, try Yes/No.");
        }
    }
}

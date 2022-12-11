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
        
    }

    // Below I'm experimenting with VSCode's Intellisense automatically generating documentation
    /**
     * Determines if user wants to play
     * @return true if user wants to play, false otherwise
     */
    public static boolean isPlay() {
        
    }
}

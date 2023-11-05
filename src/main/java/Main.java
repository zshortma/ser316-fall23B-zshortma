import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {
    /* SER316 TASK 2 SPOTBUGS FIX - fix DM error */
    static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    
    /**
     * This is the main starting method.
     * @param args takes in argument string
     */
    public static void main(String[] args) {
    	
    try {
    	
    
        // just some calls
        System.out.println("Getting started");
        Game game = new Game(1);
        System.out.println("Current word: " + game.answer);
        System.out.println(game.progress);
        game.makeGuess("a");
        System.out.println("Automatic guess a");
        System.out.println(game.progress);


        // Rough game play
        Game newgame = new Game("Dr. M.", 0);
        System.out.println("Make a guess: ");
        System.out.println(newgame.progress);
        while (newgame.getGameStatus() == 0) {
            String message = scanner.nextLine();
            boolean validGuess = newgame.makeGuess(message);
            
            if (!validGuess) {
            	
                System.out.println("Invalid guess. Please enter a valid letter or word.");
                
            }
            
           
            System.out.println("Score: " + newgame.score);
            System.out.println(newgame.progress);
            
          } 
        
        } catch (Exception e) {
        	
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            
        }
    }
}

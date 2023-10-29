import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
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
        Game newgame = new Game("Dr. M.", 0 );
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

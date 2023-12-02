import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("****************************************");
        System.out.println("**~~==WELCOME TO THE GUESSING GAME==~~**");
        System.out.println("Instructions: Guess letters and once you figure out the word enter it to see if your're a winner.");


        // Start Interactive Game
        Game newgame = new Game("Player One", 0 );
        System.out.println("****************************************");
        System.out.println("Make your guess (letter or word): ");
        System.out.println(newgame.progress);
        
        while (newgame.getGameStatus() == 0) {
            String message = scanner.nextLine();
            System.out.println(newgame.makeGuess(message));
            System.out.println("Your Score: " + newgame.score);
            System.out.println(newgame.progress);
        }
        
        
        if (newgame.getGameStatus() == 1) {
            System.out.println("You're a winner! :D  ");
        }
        
    }
}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {
    private Class<Game> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<Game>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
            {Game0.class},
            {Game1.class},
            {Game2.class},
            {Game3.class}
        };
        return Arrays.asList(classes);
    }

    private Game createGame() throws Exception {
        Constructor<Game> constructor = classUnderTest.getConstructor();
        return constructor.newInstance();
    }

    Game game;

    @org.junit.Before
    public void setUp() throws Exception {
        game = createGame();
    }

    /*
    #1 Simple test to check that beginning score is 10 and name is set correctly
    */
    @Test
    public void startGame() {
        game.init_Game("Aachen", "Dr. M");
        assertEquals(10, game.score);
        assertEquals("Dr. M" , game.getName());
    }

    /*
    #2 Check that if one letter is guessed correctly the score is updated correctly
    */
    @Test
    public void oneHit() {
        game.init_Game("Aachen", "Dr. M");
        boolean guess = game.makeGuess("c");
        assertEquals(11, game.score);
    }
    
    /*
    #3 Check that if one letter is guessed incorrectly the score is updated correctly
    */
    @Test
    public void oneMiss() {
        game.init_Game("Aachen", "Dr. M");
        boolean guess = game.makeGuess("d");
        assertEquals(9, game.score);
    }
    
    /*
    #4 Check that a correct lower case letter updates score correctly
    */
    @Test
    public void letterCorrectLower() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("a");
        assertEquals(12, game.score);
    }
    
    /*
    #5 Check that a wrong lower case letter updates score correctly
    */
    @Test
    public void letterNotCorrectLower() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("z");
        assertEquals(9, game.score);
    }
    
    /*
    #6 Check that a correct upper case letter updates score correctly
    */
    @Test
    public void letterCorrectUpper() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("N");
        assertEquals(11, game.score);
    }
    
    /*
    #7 Check that a wrong upper case letter updates score correctly
    */
    @Test
    public void letterNotCorrectUpper() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("Q");
        assertEquals(9, game.score);
    }
    
    /*
    #8 Check that a correct lower case word updates score correctly
    */
    @Test
    public void wordCorrectLower() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("aachen");
        assertEquals(16, game.score);
    }
    
    /*
    #9 Check that a wrong lower case word updates score correctly
    */
    @Test
    public void wordNotCorrectLower() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("wrong");
        assertEquals(5, game.score);
    }
    
    /*
    #10  Check that a correct upper case word updates score correctly
    */
    @Test
    public void wordCorrectUpper() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("AACHEN");
        assertEquals(16, game.score);
    }
    
    /*
    #11 Check that a wrong upper case word updates score correctly
    */
    @Test
    public void wordNotCorrectUpper() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("WRONG");
        assertEquals(5, game.score);
    }
    
    /*
    #12 Check that if there is an empty guess the score updates
    */
    @Test
    public void emptyGuess() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("");
        assertEquals(9, game.score);
    }
    
    /*
    #13 Check that if one invalid character is given the score updates
    */
    @Test
    public void specailCharacterGuess() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("%");
        assertEquals(9, game.score);
    }
    
    /*
    #14 Check that a invalid guess is updating the score correctly. 
    */
    @Test
    public void invalidWordGuess() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("zoe%");
        assertEquals(5, game.score);
    }
    
    /*
    #15 Check that if two correct letter guesses are given the score is correctly. 
    */
    @Test
    public void duplicatedCorrectGuessLetter() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("a");
        boolean guessTwo = game.makeGuess("a");
        assertEquals(10, game.score);
    }
    
    /*
    #16 Check that if two wrong letter guesses are given the score is correctly. 
    */
    @Test
    public void duplicatedWrongGuessLetter() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("z");
        boolean guessTwo = game.makeGuess("z");
        assertEquals(7, game.score);
    }
    
    /*
    #17 Check that if two correct word guesses are given the score is correctly. 
    */
    @Test
    public void duplicatedCorrectGuessWord() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("Aachen");
        boolean guessTwo = game.makeGuess("Aachen");
        assertEquals(6, game.score);
    }
    
    /*
    #18 Check that if wrong and right guesses are given the score reflects properly. 
    */
    @Test
    public void duplicatedCorrectWrongGuessWord() {
        game.init_Game("Aachen", "Dr.M");
        
        boolean guessOne = game.makeGuess("Zoe");
        boolean guessTwo = game.makeGuess("Zoe");
        boolean guessThree = game.makeGuess("Aachen");
        
        assertEquals(11, game.score);
    }
    
    /*
    #19 Check that the score is calculating correctly for two incorrect word guesses
    */
    @Test
    public void duplicatedWrongGuessWord() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("Zoe");
        boolean guessTwo = game.makeGuess("Zoe");
        assertEquals(-1, game.score);
    }
    
    /*
    #20 Check that the win status is correct
    */
    @Test
    public void testWinStatus() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("A");
        boolean guessTwo = game.makeGuess("C");
        boolean guessThree = game.makeGuess("H");
        boolean guessFour = game.makeGuess("E");
        boolean guessFive = game.makeGuess("N");
        assertEquals(1,game.gameStatus);
        
    }
    
    /*
    #21 Check that the status is correct for a lost game
    */
    @Test
    public void testLoseStatus() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("z");
        boolean guessTwo = game.makeGuess("z");
        assertEquals(2,game.gameStatus);
        
    }
    
    /*
    #22 Check that the status is in-progress if game is ongoing. 
    */
    @Test
    public void testActiveStatus() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("a");
        boolean guessTwo = game.makeGuess("z");
        assertEquals(0,game.gameStatus);
        
    }
    
    /*
    #23 Check that the return for a correct guess is true. 
    */
    @Test
    public void testReturn() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("aachen");
        assertTrue(guess);
        
    }
    
    /*
    #24 Check that the guess registers as false if incorrect. 
    */
    @Test
    public void testReturnFalse() {
        game.init_Game("Aachen", "Dr.M");
        boolean guess = game.makeGuess("aach");
        assertFalse(guess);
        
    }
    
    
    /*
    #25 Check that the status is correct
    */
    @Test
    public void testWinStatusOneLetter() {
        game.init_Game("aaa", "Dr.M");
        boolean guess = game.makeGuess("A");
        assertEquals(1,game.gameStatus);
        
    }
    
    /*
    #26 Check that mixed guess types letter/word are properly calculating the score. 
    */
    @Test
    public void mixedGuesses() {
        game.init_Game("Berlin", "Zoe");
        boolean guess = game.makeGuess("Aachen");
        boolean guessTwo = game.makeGuess("B");
        assertEquals(11, game.score);
        
    }
    
    /*
    #27 Check that the score is correct if a correct letter is guessed and then the correct word. 
    */
    @Test
    public void correctLetterThenWord() {
        game.init_Game("Berlin", "Zoe");
        boolean guess = game.makeGuess("B");
        boolean guessTwo = game.makeGuess("Berlin");
        assertEquals(16, game.score);
        
    }
    
    /*
    #28 Check that the status updates from in-progress to game won.
    */
    @Test
    public void statusUpdatingWin() {
        game.init_Game("Berlin", "Zoe");
        boolean guess = game.makeGuess("B");
        assertEquals(0,game.gameStatus);
        boolean guessTwo = game.makeGuess("Berlin");
        assertEquals(1,game.gameStatus);
        
    }
    
    /*
    #29 Check that the status updates from in-progress to game lost.
    */
    @Test
    public void statusUpdatingLose() {
        game.init_Game("Berlin", "Zoe");
        boolean guess = game.makeGuess("B");
        assertEquals(0,game.gameStatus);
        boolean guessTwo = game.makeGuess("Cat");
        assertEquals(2,game.gameStatus);
        
    }
    
}
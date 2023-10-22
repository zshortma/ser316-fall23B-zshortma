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
    Simple test to check that beginning score is 10 and name is set correctly
    */
    @Test
    public void startGame() {
        game.init_Game("Aachen", "Dr. M");
        assertEquals(10, game.score);
        assertEquals("Dr. M" , game.getName());
    }

    /*
    Check that if one letter is guessed correctly the score is updated correctly
    */
    @Test
    public void oneHit() {
        game.init_Game("Aachen", "Dr. M");
        boolean guess = game.makeGuess("c");
        assertEquals(11, game.score);
    }
    
}
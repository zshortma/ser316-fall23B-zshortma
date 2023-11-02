import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;



public class GivenWhiteBox {
    Game game;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void startGame() {
        Game game = new Game("Aachen", "Alex");
        assertEquals(game.score, 10);
    }
    
    
    /**
     * 1. Node Test SetProgress 
     * { 78,79,80,81,85,86,87 }
     */
    @Test
    public void setProgressNodeOne() {
    	Game game = new Game("Aachen", "Alex");
        int count = game.setProgress('z');
        assertEquals(0, count);  
    }
    
    /**
     * 2. Node Test SetProgress 
     *  { 78,79,80,81,82,83,84,81,85,86,87 }
     */
    @Test
    public void setProgressNodeTwo() {
    	Game game = new Game("Aachen", "Alex");
        int count = game.setProgress('n');        
        assertEquals(1, count);  
    }

    /**
     * 3. Edge Test SetProgress  
     * { 78,79,80,81,82,83,84,81,82,83,84,85,86,87 }
     */
    @Test
    public void setProgressEdgeOne() {
    	Game game = new Game("Aachen", "Alex");
        int count = game.setProgress('a');
        assertEquals(2, count);  
    }
    
    /**
     * 4. Node Test fillProgress (no for loop)
     * {92,93,94,100,101,102,103 }
     */
    @Test
    public void fillProgressNodeOne() {
    	Game game = new Game("Aachen", "Alex");
    	game.progress = "Aachen".toCharArray();
    	int hit = game.fillProgress();
    	assertEquals(0, hit); 
    }
    
    /**
     * 5. Node Test fillProgress 
     *  {92,93,94,95,98,99,100,101,102,103 }
     */
    @Test
    public void fillProgressNodeTwo() {
    	Game game = new Game("zoe", "Alex");
    	game.progress = "___".toCharArray();
    	int count = game.setProgress('z');
    	int hit = game.fillProgress();
    	assertEquals(2, hit); 
    }

    /**
     * 6. Edge Test fillProgress 
     *  { 92,93,94,95,96,97,98,99,94,95,98,99,94,100,101,102,103 }
     */
    @Test
    public void fillProgressEdgeOne() {
    	Game game = new Game("Aachen", "Alex");
        int count = game.setProgress('a');
        assertEquals(2, count);  
    }
   
    
    /**
     * 7. Edge Test getRandomWord
     * 	  City branch
     *    Changes Required : Made change to make case sensitive. 
     */
    @Test
    public void getRandomTestCity() {
    	Game game = new Game("Aachen", "Alex");
        game.getRandomWord("city");
        String answer = game.getAnswer();

        assertNotNull(answer);
        assertTrue(answer, answer.equals("aachen") || answer.equals("berlin") || answer.equals("phoenix") || answer.equals("washington") || answer.equals("munich") || answer.equals("hamburg"));
    }
    
    /**
     * 7. Edge Test getRandomWord
     *    Not city branch
     */
    @Test
    public void getRandomTestCountry() {
    	Game game = new Game("Aachen", "Alex");
        game.getRandomWord("");
        String answer = game.getAnswer();

        assertNotNull(answer);
        assertTrue(answer, answer.equals("ireland") || answer.equals("usa") || answer.equals("austria") || answer.equals("washington") || answer.equals("switzerland") || answer.equals("germany"));
    }
    
    /**
     * 8. Testing game constructor Branch Case One
     *    
     */
    @Test
    public void testingGameConstructor() {
        Game game = new Game("Elsa", 0); 
        assertEquals("Elsa", game.getName()); 
        assertEquals(game.getAnswer().length(), game.getProgress().length); 
    }
    
    /**
     * 9. Testing game constructor Branch Case Two
     *    
     */
    @Test
    public void testGameConstructorSecond() {
        Game game = new Game("Elsa", 1); 
        assertEquals("Elsa", game.getName()); 
        assertEquals(game.getAnswer().length(), game.getProgress().length); 
    }
    
    
    /**
     * 10. Testing game constructor Branch Case Three
     *    
     */
    @Test
    public void testGameConstructorThree() {
        Game game = new Game();
        assertEquals("", game.getName());
        assertEquals("", game.getAnswer());
        assertEquals(10, game.score);
        assertEquals(0, game.getProgress().length);
    }
    
    
    /**
     * 11. Testing makeGuess Empty
     *    
     */
    @Test
    public void testMakeGuessEmptyGuess() {
    	Game game = new Game("Aachen", "Alex");
        assertFalse(game.makeGuess(""));
        assertEquals(9, game.score);
    }
    
    
    /**
     * 12. Testing makeGuess incorrect branch
     *    
     */
    @Test
    public void testMakeGuessEmptyGuess88() {
    	Game game = new Game("Aachen", "Alex");
        assertFalse(game.makeGuess("j"));
        assertEquals(9, game.score);
    }
    
    /**
     * 13. Testing makeGuess correct branch
     *    
     */
    @Test
    public void testMakeGuessCorrectSingleLetter() {
    	Game game = new Game("apple", "Alex");
        assertTrue(game.makeGuess("a"));
        assertEquals(11, game.score);
    }
    
    /**
     * 14. Testing makeGuess incorrect branch
     *    
     */
    @Test
    public void testMakeGuessWord() {
    	Game game = new Game("apple", "Alex");
        assertFalse(game.makeGuess("test"));
        assertEquals(5, game.score);
    }
    
    
    /**
     * 15. Testing makeGuess word correct branch
     *    
     */
    @Test
    public void testMakeGuessCorrectWord() {
    	Game game = new Game("jade", "Alex");
        assertTrue(game.makeGuess("jade"));
      }
    
    
    /**
     * 16. Testing game constructor with image type branch one
     *    
     */
    @Test
    public void testGameConstructorWithInvalidImageType() {
        Game gameInvalid = new Game(1);
        assertEquals("Anna", gameInvalid.getName());
        assertEquals(12, gameInvalid.score);
    }
    
    
    /**
     * 17. Testing game constructor with image type branch two
     *    
     */
    @Test
    public void testGameConstructorWithTypeOne() {
        Game game = new Game(2);
        assertEquals("Anna", game.getName());
        assertEquals(12, game.score);
    }
    
    
    /**
     * 18. Testing init game constructor 
     *    
     */
    @Test
    public void testInitGame() {
    	 Game game = new Game();
        game.init_Game("city", "Anna");
        assertEquals("Anna", game.getName());
        assertEquals("city", game.getAnswer());
        assertEquals(10, game.score);
        assertEquals("city".length(), game.getProgress().length);
        char[] expectedProgress = { '_', '_', '_', '_' };
        assertArrayEquals(expectedProgress, game.getProgress());
    }

}

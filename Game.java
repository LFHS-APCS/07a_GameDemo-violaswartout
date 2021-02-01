import java.util.*;
/**
 * Phase 1:
 *   1) Run the play method.
 *   2) What does this game do?
 *   3) Without changing any code, how can you win by "cheating"? 
 * Phase 2:
 *   Wait for instructions...
 */
public class Game {

    private int [] locations;  // note: unitialized, will be created in constructor
    private int numGuesses = 0;
    private int numHits = 0; // TODO (in phase 2) get rid of this variable
    public final int UPPER = 5;

    public static void main(String args[]) {
        Game game = new Game();
        game.play();
    }

    /**
     * play the game
     */
    public void play()
    {
        setup();
        String result = "";
        while(!result.equals("kill")) {
            int guess = getGuess();
            result = checkGuess(guess);
            System.out.println(result + " for " + guess); 
        }
        System.out.println("It took " + numGuesses + " guesses to win");
    }

    /**
     * setup the game
     */
    public void setup()
    {
        // Get a random number from 0 to UPPER-1 inclusive. 
        int randomNum = (int) (Math.random() * UPPER);
        locations = new int[3]; 
        locations[0] = randomNum;
        locations[1] = randomNum + 1;
        locations[2] = randomNum + 2;
    }

    /**
     * return an integer guess from the user
     */
    public int getGuess() {
        System.out.println("enter a number from 0 to " + (UPPER+1));
        Scanner scan = new Scanner(System.in);
        int guess = scan.nextInt();
        numGuesses++;
        return guess;
    }

    /** 
     * check the guess to see if it is a hit or miss
     */
    public String checkGuess(int guess) 
    { 
        String result = "miss"; 
        for(int i=0; i < locations.length; i++) { 
            if (guess == locations[i]) {
                result = "hit"; 
                numHits++; 
                break;
            }
        } 
        if (numHits == locations.length) { 
            result = "kill"; 
        }

        return result; 
    } 
}


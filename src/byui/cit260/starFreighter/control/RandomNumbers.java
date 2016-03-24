package byui.cit260.starFreighter.control;

import java.util.Random;

/**
 * A utility class with functions for generating random numbers and rolling
 * dice.
 */
public final class RandomNumbers {
    /**
     * Static class members.
     */
    private final static Random gen = new Random();
    
    /**
     * Private constructor prevents instantiation.
     */
    private RandomNumbers() {
        
    }
    
    /**
     * Returns a random number between min and max, inclusive.
     * @param min
     * @param max
     * @return 
     */
    public static int range(int min, int max) {
        return gen.nextInt(max - min + 1) + min;
    }
}

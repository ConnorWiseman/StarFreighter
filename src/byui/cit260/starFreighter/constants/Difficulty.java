package byui.cit260.starFreighter.constants;

/**
 * A basic class for describing enemy difficulty ratings.
 */
public enum Difficulty {
    EASY(25),
    MEDIUM(50),
    HARD(100);
    
    private final int rating;
    
    Difficulty(int rating) {
        this.rating = rating;
    }
    
    public int getRating() {
        return this.rating;
    }
}
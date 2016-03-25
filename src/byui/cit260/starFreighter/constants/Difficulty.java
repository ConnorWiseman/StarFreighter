package byui.cit260.starFreighter.constants;

/**
 * A basic class for describing enemy difficulty ratings.
 */
public enum Difficulty {
    EASY(25, 10, 2),
    MEDIUM(50, 20, 4),
    HARD(100, 30, 6);
    
    /**
     * Constants.
     */
    private final int hullIntegrity;
    private final int crewHitPoints;
    private final int crewFighterStat;
    
    /**
     * Constructor.
     * @param hullIntegrity;
     * @param crewRating 
     */
    Difficulty(int hullIntegrity, int crewHitPoints, int crewFighterStat) {
        this.hullIntegrity = hullIntegrity;
        this.crewHitPoints = crewHitPoints;
        this.crewFighterStat = crewFighterStat;
    }
    
    /**
     * Gets the ship's hull integrity.
     * @return 
     */
    public int getHullIntegrity() {
        return this.hullIntegrity;
    }
    
    /**
     * Gets the crew's hit points.
     * @return 
     */
    public int getCrewHitPoints() {
        return this.crewHitPoints;
    }
    
    /**
     * Gets the crew's fighter stat.
     * @return 
     */
    public int getCrewFighterStat() {
        return this.crewFighterStat;
    }
}
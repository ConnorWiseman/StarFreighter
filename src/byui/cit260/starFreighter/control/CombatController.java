package byui.cit260.starFreighter.control;

/**
 * Utility class for handling some combat-related tasks.
 */
public class CombatController {
    
    /**
     * Private constructor prevents instantiation.
     */
    private CombatController() {
        
    }
    
    /**
     * Calculates damage from a given "pool" of dice to roll.
     * @param pool
     * @return 
     */
    public static int calculateDamage(int pool) {
        int damage = 0;
        for (int i = 0; i < pool; i++) {
            damage += RandomNumbers.range(1, 6);
        }
        return damage;
    }
}
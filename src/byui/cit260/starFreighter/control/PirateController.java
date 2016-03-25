package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.Difficulty;
import byui.cit260.starFreighter.constants.Role;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.Ship;
import byui.cit260.starFreighter.model.SpacePirate;

/**
 *
 */
public final class PirateController {
    
    /**
     * Private constructor prevents instantiation.
     */
    private PirateController() {

    }

    /**
     * Creates an enemy ship of the specified difficulty rating.
     * @param difficulty
     * @return 
     */
    public static SpacePirate createEnemy(Difficulty difficulty) {
        // Create a new enemy Ship.
        Ship enemyShip = new Ship("Space Pirates");
        
        // Set the ship's hull integrity. Fuel doesn't matter, pirates don't travel.
        enemyShip.setHullIntegrity(difficulty.getHullIntegrity());
        enemyShip.setHull(enemyShip.hullIntegrity());
        
        // Create a crew of five pirates.
        CrewRoster enemyCrew = new CrewRoster();
        for (int i = 0; i < 5; i++) {
            // Create a pirate.
            CrewMember pirate = CrewController.createCrewMember("Space Pirate");
            
            // Set the pirate's HP and fighting ability.
            pirate.setHitPoints(difficulty.getCrewHitPoints());
            pirate.setStat(Role.FIGHTER, difficulty.getCrewFighterStat());

            // Assign each crew member a role. Doesn't matter which.
            enemyCrew.set(i, pirate);
        }

        // Return our enemy object.
        return new SpacePirate(enemyShip, enemyCrew);
    }
}
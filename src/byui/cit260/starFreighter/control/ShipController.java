package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.Difficulty;
import byui.cit260.starFreighter.model.Ship;
import starfreighter.StarFreighter;

/**
 * Controls instances of the player's ship.
 */
public class ShipController {
    /**
     * Creates a new Ship.
     * @param shipName
     * @return 
     */
    public static Ship createShip(String shipName) {
        // Create a new Ship.
        Ship newShip = new Ship(shipName);
        
        // Assign values to the Ship's properties.
        newShip.setFuelCapacity(100);
        newShip.setHullIntegrity(100);
        newShip.setFuel(newShip.fuelCapacity());
        newShip.setHull(newShip.hullIntegrity());

        return newShip;
    }
    
    /**
     * Creates an enemy ship of the specified difficulty rating.
     * @param difficulty
     * @return 
     */
    public static Ship createEnemyShip(Difficulty difficulty) {
        // Create a new enemy Ship.
        Ship enemyShip = new Ship("Space Pirates");
        
        // Assign values to the Ship's properties.
        enemyShip.setFuelCapacity(difficulty.getRating());
        enemyShip.setHullIntegrity(difficulty.getRating());
        enemyShip.setFuel(enemyShip.fuelCapacity());
        enemyShip.setHull(enemyShip.hullIntegrity());

        return enemyShip;
    }

    /**
     * Renames the Ship.
     * @param newName
     */
    public static void renameShip(String newName) {
        getShip().setName(newName);
    }
    
    /**
     * Gets the player's ship from the current game instance.
     * @return 
     */
    public static Ship getShip() {
        return StarFreighter.getCurrentGame().getShip();
    }

    /**
     * Calculates the fuel cost given a specified distance.
     * @param distance
     * @return 
     */
    public static int calculateFuelCost(double distance) {
        return 0;
    }
}
package byui.cit260.starFreighter.control;

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
     * Renames the Ship.
     * @param newName
     */
    public static void renameShip(String newName) {
        StarFreighter.currentGame().getShip().setName(newName);
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
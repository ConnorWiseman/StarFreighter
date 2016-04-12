package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.Role;
import byui.cit260.starFreighter.model.CrewRoster;
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
        newShip.setFuelCapacity(125);
        newShip.setHullIntegrity(100);
        newShip.setFuel(newShip.getFuelCapacity());
        newShip.setHull(newShip.getHullIntegrity());

        // Return the new ship.
        return newShip;
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
     * Calculates the fuel cost given a specified distance. Uses the pilot skill
     * to determine how much fuel is consumed when traveling.
     * @param distance
     * @return 
     */
    public static int calculateFuelCost(double distance) {
        CrewRoster playerCrew = CrewController.getPlayerRoster();
        int pilotModifier = playerCrew.getCrewMemberAssignedTo(Role.PILOT).getStat(Role.PILOT);
        int fuelCostModifier = 11 - pilotModifier;
        return (int) ((int) distance * fuelCostModifier);
    }
    
    /**
     * Calculates the cost of refueling the player's ship.
     * @return 
     */
    public static int calculateRefuelCost() {
        Ship playerShip = getShip();
        int maxFuel = playerShip.getFuelCapacity();
        int currentFuel = playerShip.getFuel();
        
        return (int) ((maxFuel - currentFuel) * 0.5);
    }
    
    /**
     * Calculates the cost of repairing the player's ship.
     * @return 
     */
    public static int calculateRepairCost() {
        Ship playerShip = getShip();
        int maxHull = playerShip.getHullIntegrity();
        int currentHull = playerShip.getHull();
        
        return (maxHull - currentHull) * 2;
    }
}
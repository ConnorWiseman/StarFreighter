package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.Ship;
import byui.cit260.starFreighter.view.Input;
import starfreighter.StarFreighter;

/**
 *
 * @author Connor
 */
public class ShipController {
    /**
     * Creates a new Ship.
     * @return 
     */
    public static Ship createShip() {
        // Prompt the player for the name of their ship; create a new Ship.
        String shipName = Input.getStringSameLine("Please name your ship: ");
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
     */
    public static void renameShip() {
        String newName = Input.getStringSameLine("Enter new name: ");
        StarFreighter.currentGame().getShip().setName(newName);
    }

    public static int calculateFuelCost(double distance) {
        return 0;
    }
}

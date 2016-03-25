package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Ship;
import java.io.IOException;
import starfreighter.StarFreighter;

/**
 * The help menu view, accessible in-game.
 */
public class ShipMenu extends MenuView {
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public ShipMenu() {
        menuTitle = "Ship Menu";
        menuItems.add(new MenuItem('S', "Ship Status"));
        menuItems.add(new MenuItem('N', "Rename Ship"));
        menuItems.add(new MenuItem('F', "Refuel Ship"));
        menuItems.add(new MenuItem('R', "Repair Ship"));
        menuItems.add(new MenuItem('E', "Exit to previous menu"));
    }

    /**
     * Displays a status report on the player's Ship.
     * @todo Something with printf, for nicer formatting?
     */
    private void shipStatus() {
        Ship ship = ShipController.getShip();
        TextBox.displayText(
            "Welcome, Captain. The " + ship.getName() + " is reporting the" +
                " following status:",
            "Hull integrity: " + ship.getHull() + "/" + ship.getHullIntegrity(),
            "Fuel supply: " + ship.getFuel() + "/" + ship.getFuelCapacity()
        );
    }

    /**
     * Renames the player's ship.
     */
    private void renameShip() {
        try {
            String newName = Input.getStringSameLine("Enter new name: ");
            ShipController.renameShip(newName);
            TextBox.displayText(
                "You have rechristened your ship " + newName + "."
            );
        } catch (IOException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
    }

    /**
     * Refuels the player's ship.
     */
    private void refuelShip() {
        // Get the player's ship.
        Ship playerShip = ShipController.getShip();
        
        // Check to make sure fuel supplies aren't full already.
        if (playerShip.getFuel() == playerShip.getFuelCapacity()) {
            TextBox.displayText(
                "The " +
                playerShip.getName() +
                "'s fuel supplies are full, sir."
            );
            return;
        }
        
        // Calculate the cost of refueling.
        int refuelCost = ShipController.calculateRefuelCost();

        // Inform the player of the consequences of their actions.
        TextBox.displayText(
            "Refueling the " +
            playerShip.getName() +
            " will cost " +
            refuelCost +
            " " +
            InventoryController.CURRENCY +
            "."
        );
        
        try {
            // Does the player want to proceed?
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");

            // If the player does, then proceed. Otherwise, cancel.
            if (proceed == 'Y') {
                // Make sure the player has enough money to spend.
                if (StarFreighter.getCurrentGame().getInventory().getCurrency() >= refuelCost) {
                    // Update the player's fuel.
                    playerShip.setFuel(playerShip.getFuelCapacity());
                    
                    // Display a confirmation message.
                    TextBox.displayText(
                        "You spend " +
                        refuelCost +
                        " " +
                        InventoryController.CURRENCY +
                        " to refuel the " +
                        playerShip.getName() +
                        "."
                    );
                }
                else {
                    // Inform the player of their inability to refuel.
                    // Should have used a budget!
                    TextBox.displayText(
                        "Unfortunately, you cannot afford to refuel your ship."
                    );
                }
            }
            else {
                TextBox.displayText(
                    "Refueling canceled."
                );
            }
        } catch (IOException error) {
            ErrorView.display(TravelView.class.getName(), error.getMessage());
        }
    }

    /**
     * Repairs the player's ship.
     */
    private void repairShip() {
        // Get the player's ship.
        Ship playerShip = ShipController.getShip();
        
        // Check to make sure hull integrity isn't maxed already.
        if (playerShip.getHull() == playerShip.getHullIntegrity()) {
            TextBox.displayText(
                "The " +
                playerShip.getName() +
                "'s hull is at maximum integrity, sir."
            );
            return;
        }
        
        // Calculate the cost of repairing.
        int repairCost = ShipController.calculateRepairCost();

        // Inform the player of the consequences of their actions.
        TextBox.displayText(
            "Repairing the " +
            playerShip.getName() +
            " will cost " +
            repairCost +
            " " +
            InventoryController.CURRENCY +
            "."
        );
        
        try {
            // Does the player want to proceed?
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");

            // If the player does, then proceed. Otherwise, cancel.
            if (proceed == 'Y') {
                // Make sure the player has enough money to spend.
                if (StarFreighter.getCurrentGame().getInventory().getCurrency() >= repairCost) {
                    // Update the player's hull integrity.
                    playerShip.setHull(playerShip.getHullIntegrity());
                    
                    // Display a confirmation message.
                    TextBox.displayText(
                        "You spend " +
                        repairCost +
                        " " +
                        InventoryController.CURRENCY +
                        " to repair the " +
                        playerShip.getName() +
                        "."
                    );
                }
                else {
                    // Inform the player of their inability to repair.
                    // Should have used a budget!
                    TextBox.displayText(
                        "Unfortunately, you cannot afford to repair your ship."
                    );
                }
            }
            else {
                TextBox.displayText(
                    "Repairing canceled."
                );
            }
        } catch (IOException error) {
            ErrorView.display(TravelView.class.getName(), error.getMessage());
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S': {
                shipStatus();
                break;
            }
            case 'N': {
                renameShip();
                break;
            }
            case 'F': {
                refuelShip();
                break;
            }
            case 'R': {
                repairShip();
                break;
            }
            case 'E': {
                return true;
            }
            default: {
                CONSOLE.println(INVALID);
                break;
            }
        }
        return false;
    }
}
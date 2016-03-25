package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Ship;
import java.io.IOException;

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
            "Hull integrity: " + ship.getHull() + "/" + ship.hullIntegrity(),
            "Fuel supply: " + ship.getFuel() + "/" + ship.fuelCapacity()
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
        
    }

    /**
     * 
     */
    private void repairShip() {
        
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
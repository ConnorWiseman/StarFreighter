package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Ship;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        menuItems.add(new MenuItem('R', "Rename Ship"));
        menuItems.add(new MenuItem('E', "Exit to previous menu"));
    }

    /**
     * Displays a status report on the player's Ship.
     */
    private void shipStatus() {
        Ship ship = ShipController.getShip();
        TextBox.displayText(
            "Welcome, Captain. The " + ship.getName() + " is reporting the" +
                " following status:",
            "Hull integrity: " + ship.hull() + "/" + ship.hullIntegrity(),
            "Fuel supply: " + ship.fuel() + "/" + ship.fuelCapacity()
        );
    }

    /**
     * Renames the player's ship.
     * @param name
     * @return 
     */
    private void renameShip() throws IOException {
        String newName = Input.getStringSameLine("Enter new name: ");
        ShipController.renameShip(newName);
        TextBox.displayText(
            "You have rechristened your ship " + newName + "."
        );
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S': {
                shipStatus();
                break;
            }
            case 'R': {
                try {
                    renameShip();
                } catch (IOException error) {
                    ErrorView.display(this.getClass().getName(), error.getMessage());
                }
                break;
            }
            case 'E': {
                return true;
            }
            default: {
                console.println(INVALID);
                break;
            }
        }
        return false;
    }
}
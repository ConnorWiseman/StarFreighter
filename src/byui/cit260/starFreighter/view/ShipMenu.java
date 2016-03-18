package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Ship;
import starfreighter.StarFreighter;

/**
 * The help menu view, accessible in-game.
 * @author Connor
 */
public class ShipMenu extends MenuView {
    /**
     * Class properties. Additional views called by this view.
     */
    private final TextBox textBox = new TextBox();

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
        Ship ship = StarFreighter.currentGame().getShip();
        textBox.displayText(
            "Welcome, Captain. The " + ship.name() + " is reporting the" +
                " following status:",
            "Hull integrity: " + ship.hull() + "/" + ship.hullIntegrity(),
            "Fuel supply: " + ship.fuel() + "/" + ship.fuelCapacity()
        );
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S':
                shipStatus();
                break;
            case 'R':
                ShipController.renameShip();
                break;
            case 'E':
                return true;
            default:
                System.out.println(INVALID);
                break;
        }
        return false;
    }
}
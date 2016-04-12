package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Ship;
import java.io.IOException;
import starfreighter.StarFreighter;

/**
 *
 */
public class UpgradeMenu extends MenuView {
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public UpgradeMenu() {
        menuTitle = "Upgrade Menu";
        menuItems.add(new MenuItem('H', "Upgrade hull integrity"));
        menuItems.add(new MenuItem('F', "Upgrade fuel capacity"));
        menuItems.add(new MenuItem('E', "Exit to previous menu"));
    }
    
    public void upgradeHull() {
        // Get the player's ship.
        Ship playerShip = ShipController.getShip();
        TextBox.displayText(
            "The " + playerShip.getName() + "'s maximum hull integrity is" +
                    " currently " + playerShip.getHullIntegrity() + "." +
                    " upgrading it by 25 points will cost 100 " +
                    InventoryController.CURRENCY + "."
        );

        try {
            // Does the player want to proceed?
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");

            // If the player does, then proceed. Otherwise, cancel.
            if (proceed == 'Y') {
                // Make sure the player has enough money to spend.
                if (StarFreighter.getCurrentGame().getInventory().getCurrency() >= 100) {
                    // Update the player's ship's maximum hull integrity.
                    playerShip.setHullIntegrity(playerShip.getHullIntegrity() + 25);
                    
                    // Display a confirmation message.
                    TextBox.displayText(
                        "You spend 100 " +
                        InventoryController.CURRENCY +
                        " to upgrade the " +
                        playerShip.getName() +
                        "'s maximum hull integrity to " +
                        playerShip.getHullIntegrity() +
                        "."
                    );
                }
                else {
                    // Inform the player of their inability to upgrade.
                    // Should have used a budget!
                    TextBox.displayText(
                        "Unfortunately, you cannot afford to upgrade your ship."
                    );
                }
            }
            else {
                TextBox.displayText(
                    "Upgrade canceled."
                );
            }
        } catch (IOException error) {
            ErrorView.display(TravelView.class.getName(), error.getMessage());
        }
    }
    
    public void upgradeFuel() {
        // Get the player's ship.
        Ship playerShip = ShipController.getShip();
        TextBox.displayText(
            "The " + playerShip.getName() + "'s maximum fuel capacity is" +
                    " currently " + playerShip.getFuelCapacity() + "." +
                    " upgrading it by 25 points will cost 100 " +
                    InventoryController.CURRENCY + "."
        );

        try {
            // Does the player want to proceed?
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");

            // If the player does, then proceed. Otherwise, cancel.
            if (proceed == 'Y') {
                // Make sure the player has enough money to spend.
                if (StarFreighter.getCurrentGame().getInventory().getCurrency() >= 100) {
                    // Update the player's ship's maximum fuel capacity.
                    playerShip.setFuelCapacity(playerShip.getFuelCapacity() + 25);
                    
                    // Display a confirmation message.
                    TextBox.displayText(
                        "You spend 100 " +
                        InventoryController.CURRENCY +
                        " to upgrade the " +
                        playerShip.getName() +
                        "'s maximum fuel capacity to " +
                        playerShip.getFuelCapacity() +
                        "."
                    );
                }
                else {
                    // Inform the player of their inability to upgrade.
                    // Should have used a budget!
                    TextBox.displayText(
                        "Unfortunately, you cannot afford to upgrade your ship."
                    );
                }
            }
            else {
                TextBox.displayText(
                    "Upgrade canceled."
                );
            }
        } catch (IOException error) {
            ErrorView.display(TravelView.class.getName(), error.getMessage());
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'H': {
                upgradeHull();
                break;
            }
            case 'F': {
                upgradeFuel();
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
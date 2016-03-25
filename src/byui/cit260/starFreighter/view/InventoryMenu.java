package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.InventoryItem;
import byui.cit260.starFreighter.model.MenuItem;

/**
 * The player inventory menu.
 */
public final class InventoryMenu extends MenuView {
    /**
     * Class constructor.
     */
    public InventoryMenu() {
        menuTitle = "Inventory";
        menuItems.add(new MenuItem('C', "Cargo Manifest"));
        menuItems.add(new MenuItem('S', "Sell"));
        menuItems.add(new MenuItem('B', "Buy"));
        menuItems.add(new MenuItem('E', "Exit"));
    }
    
    /**
     * Displays the contents of the player's inventory.
     */
    private void displayInventoryContents() {
        Inventory playerInventory = InventoryController.getInventory();
        console.println("You have " + playerInventory.getCurrency() + " " + InventoryController.CURRENCY);
        console.println("[Item name]\t[Value]");
        playerInventory.getContents().stream().forEach((current) -> {
            console.println(current);
        });
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'C': {
                displayInventoryContents();
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
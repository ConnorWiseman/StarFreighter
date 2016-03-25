package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.InventoryItem;
import byui.cit260.starFreighter.model.MenuItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    /**
     * Displays the item list of an inventory. Used during buying/selling.
     * @param inventory 
     */
    private void displayItemList(ArrayList<InventoryItem> inventory) {
        inventory.stream().forEach((InventoryItem current) -> {
            // Offset the index by one to make the numbers "human-readable."
            int index = inventory.indexOf(current) + 1;
            console.write("[");
            if (index < 10) {
                console.write("0");
            }
            console.write(index + "] - " + current.getName() + "\n");
            console.flush();
        });
    }
    
    /**
     * Sells an item to the shop at the player's current location.
     */
    private void sellItem() throws IOException {
        ArrayList<InventoryItem> playerInventory = InventoryController.getInventory().getContents();
        if (playerInventory.size() > 0) { 
            displayItemList(playerInventory);
            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose an item to sell: ") - 1;
            InventoryController.sellItem(playerInventory.get(selection));
        }
        else {
            console.println("You have no items to sell!");
        }
    }
    
    /**
     * Buys an item from the shop at the player's current location.
     */
    private void buyItem() throws IOException {
        ArrayList<InventoryItem> shopStock = ShipController.getShip().getLocation().getShop().getContents();
        if (shopStock.size() > 0) { 
            displayItemList(shopStock);
            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose an item to buy: ") - 1;
            InventoryController.buyItem(shopStock.get(selection));
        }
        else {
            console.println("There are no items for sale here.");
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'C': {
                displayInventoryContents();
                break;
            }
            case 'S': {
                try {
                    sellItem();
                } catch (IOException error) {
                    ErrorView.display(this.getClass().getName(), error.getMessage());
                }
                break;
            }
            case 'B': {
                try {
                    buyItem();
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
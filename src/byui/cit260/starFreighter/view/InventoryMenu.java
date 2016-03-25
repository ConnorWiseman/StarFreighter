package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.InventoryItem;
import byui.cit260.starFreighter.model.MenuItem;
import java.io.IOException;
import java.util.ArrayList;

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
     * @todo Fix the way this prints out. printf, maybe?
     */
    private void displayInventoryContents() {
        Inventory playerInventory = InventoryController.getInventory();
        console.println("You have " + playerInventory.getCurrency() + " " + InventoryController.CURRENCY);
        console.println("[Item name]\t[Value]");
        playerInventory.getContents().stream().forEach((current) -> {
            console.println(current);
        });
        console.println("Your cargo is worth a combined " +
                InventoryController.calculateTotalValue(playerInventory) +
                " credits.");
    }
    
    /**
     * Displays the item list of an inventory. Used during buying/selling.
     * @param inventory 
     * @todo printf?
     */
    private void displayItemList(ArrayList<InventoryItem> inventory) {
        // Must keep track of index manually; ArrayList indexOf method returns
        // duplicate indexes for separate items with the same values.
        int index = 1;
        for (InventoryItem current : inventory) {
            // Pad the index with a leading zero for readability's sake.
            console.write("[");
            if (index < 10) {
                console.write("0");
            }
            console.write(index + "] - " + current.getName() + "\t");
            console.write(InventoryController.calculateResaleValue(current) + "\n");
            console.flush();
            // Increment the index.
            index++;
        }
    }
    
    /**
     * Sells an item to the shop at the player's current location.
     */
    private void sellItem() {
        // Get the player's inventory.
        ArrayList<InventoryItem> playerInventory = InventoryController.getInventory().getContents();
        
        // Ensure there are items to sell.
        if (!(playerInventory.size() > 0)) {
            TextBox.displayText("You have no items to sell!");
            return;
        }
        
        try {
            // Display the player's inventory.
            displayItemList(playerInventory);

            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose an item to sell: ") - 1;

            // If the user got smart and gave us a number that doesn't exist
            // in the inventory ArrayList indices, we need to catch the
            // impending error in addition to the IO exception potentially
            // thrown by Input class's methods.
            InventoryController.sellItem(playerInventory.get(selection));
        } catch (IOException | IndexOutOfBoundsException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
    }
    
    /**
     * Buys an item from the shop at the player's current location.
     */
    private void buyItem() {
        // Get the shop's inventory.
        ArrayList<InventoryItem> shopStock = ShipController.getShip().getLocation().getShop().getContents();
        
        // Ensure there are items to buy.
        if (!(shopStock.size() > 0)) {
            TextBox.displayText("There are no items for sale here.");
            return;
        }
        
        try {
            // Display the shop's inventory.
            displayItemList(shopStock);

            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose an item to buy: ") - 1;

            // If the user got smart and gave us a number that doesn't exist
            // in the inventory ArrayList indices, we need to catch the
            // impending error in addition to the IO exception potentially
            // thrown by Input class's methods.
            InventoryController.buyItem(shopStock.get(selection));
        } catch (IOException | IndexOutOfBoundsException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
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
                sellItem();
                break;
            }
            case 'B': {
                buyItem();
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
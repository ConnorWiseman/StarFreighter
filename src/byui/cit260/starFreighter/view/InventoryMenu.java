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
        menuItems.add(new MenuItem('A', "Sell All"));
        menuItems.add(new MenuItem('B', "Buy"));
        menuItems.add(new MenuItem('E', "Exit"));
    }
    
    /**
     * Displays the contents of the player's inventory.
     * @todo Fix the way this prints out. printf, maybe?
     */
    private void displayInventoryContents() {
        Inventory playerInventory = InventoryController.getPlayerInventory();
        CONSOLE.println("You have " + playerInventory.getCurrency() + " " + InventoryController.CURRENCY);
        CONSOLE.println("[Item name]\t[Value]");
        playerInventory.getContents().stream().forEach((current) -> {
            CONSOLE.println(current);
        });
        CONSOLE.println("Your cargo is worth a combined " +
                InventoryController.calculateTotalValue(playerInventory) +
                " credits.");
    }
    
    /**
     * Sells an item to the shop at the player's current location.
     */
    private void sellItem() {
        // Get the player's inventory.
        ArrayList<InventoryItem> playerInventory = InventoryController.getPlayerInventory().getContents();
        
        // Ensure there are items to sell.
        if (!(playerInventory.size() > 0)) {
            TextBox.displayText("You have no items to sell!");
            return;
        }
        
        try {
            // Display the player's inventory.
            int index = 1;
            for (InventoryItem current : playerInventory) {
                // Pad the index with a leading zero for readability's sake.
                CONSOLE.write("[");
                if (index < 10) {
                    CONSOLE.write("0");
                }
                CONSOLE.write(index + "] - " + current.getName() + "\t");
                CONSOLE.write(InventoryController.calculateResaleValue(current) + "\n");
                CONSOLE.flush();
                // Increment the index.
                index++;
            }

            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose an item to sell: ") - 1;
            
            // Get the item to sell.
            InventoryItem itemToSell = playerInventory.get(selection);

            // If the user got smart and gave us a number that doesn't exist
            // in the inventory ArrayList indices, we need to catch the
            // impending error in addition to the IO exception potentially
            // thrown by Input class's methods.
            InventoryController.sellItem(itemToSell);
            
            // Display an explanatory message.
            TextBox.displayText(
                "You sold one " +
                itemToSell.getName() +
                " and now have " +
                InventoryController.getPlayerInventory().getCurrency() +
                " " +
                InventoryController.CURRENCY +
                "."
            );
        } catch (IOException | IndexOutOfBoundsException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
    }
    
    /**
     * Sells all the items in the player's inventory.
     */
    private void sellAllItems() {
        // Get the player's inventory.
        ArrayList<InventoryItem> playerInventory = InventoryController.getPlayerInventory().getContents();
        
        // Ensure there are items to sell.
        if (!(playerInventory.size() > 0)) {
            TextBox.displayText("You have no items to sell!");
            return;
        }
        
        try {
            // Does the player want to proceed?
            CONSOLE.println("This will sell all the items in your inventory.");
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");

            // If the player does, then proceed. Otherwise, cancel.
            if (proceed == 'Y') {
                // Sell all the items in the player's inventory.
                InventoryController.sellAll();

                // Display an explanatory message.
                TextBox.displayText(
                    "You sold your entire inventory and now have " +
                    InventoryController.getPlayerInventory().getCurrency() +
                    " " +
                    InventoryController.CURRENCY +
                    "."
                );
            }
        } catch (IndexOutOfBoundsException | IOException error) {
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
            int index = 1;
            for (InventoryItem current : shopStock) {
                // Pad the index with a leading zero for readability's sake.
                CONSOLE.write("[");
                if (index < 10) {
                    CONSOLE.write("0");
                }
                CONSOLE.write(index + "] - " + current.getName() + "\t");
                CONSOLE.write(current.getValue() + "\n");
                CONSOLE.flush();
                // Increment the index.
                index++;
            }

            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose an item to buy: ") - 1;

            // Get the item to buy.
            InventoryItem itemToBuy = shopStock.get(selection);

            // If the user got smart and gave us a number that doesn't exist
            // in the inventory ArrayList indices, we need to catch the
            // impending error in addition to the IO exception potentially
            // thrown by Input class's methods.
            InventoryController.buyItem(itemToBuy);
            
            // Display an explanatory message.
            TextBox.displayText(
                "You bought one " +
                itemToBuy.getName() +
                " and now have " +
                InventoryController.getPlayerInventory().getCurrency() +
                " " +
                InventoryController.CURRENCY +
                "."
            );
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
            case 'A': {
                sellAllItems();
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
                CONSOLE.println(INVALID);
                break;
            }
        }
        return false;
    }
}
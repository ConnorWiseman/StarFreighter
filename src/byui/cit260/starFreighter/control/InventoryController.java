package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.InventoryItem;
import byui.cit260.starFreighter.model.Planet;
import java.util.Collections;
import starfreighter.StarFreighter;

/**
 * A controller class for handling item and monetary transactions.
 */
public class InventoryController {
    /**
     * Class constants.
     */
    public final static String CURRENCY = "credits";

    /**
     * Private constructor prevents instantiation.
     */
    private InventoryController() {
        
    }
    
    /**
     * Creates a new inventory.
     * @return 
     */
    public static Inventory createInventory() {
        Inventory playerInventory = new Inventory();
        
        playerInventory.addItem(new InventoryItem("Testing", 100));
        
        return playerInventory;
    }
    
    /**
     * Gets the player's inventory.
     * @return 
     */
    public static Inventory getInventory() {
        return StarFreighter.getCurrentGame().getInventory();
    }

    /**
     * Sorts a particular inventory by item value.
     * @param toSort
     */
    public static void sortByValue(Inventory toSort) {
        Collections.sort(toSort.getContents(), (InventoryItem itemOne, InventoryItem itemTwo) -> {
            if (itemOne.getValue() > itemTwo.getValue()) {
                return 1;
            }
            if (itemOne.getValue() < itemTwo.getValue()) {
                return -1;
            }
            return 0;
        });
    }
    
    /**
     * Sells a particular item to the shop on the current planet.
     * @param item 
     */
    public static void sellItem(InventoryItem item) {
        Inventory currentInventory = getInventory();
        
        Planet currentLocation = ShipController.getShip().getLocation();
        Inventory otherInventory = currentLocation.getShop();
        
        currentInventory.removeItem(item);
        currentInventory.addCurrency(item.getValue());
        otherInventory.addItem(item);
        otherInventory.removeCurrency(item.getValue());

        sortByValue(currentInventory);
        sortByValue(otherInventory);
    }

    /**
     * Buys a particular item from the shop on the current planet.
     * @param item 
     */
    public static void buyItem(InventoryItem item) {
        // get player's current location
        // remove item from shop at current location
        // add value to shop's currency
        // add item to player's inventory
        // remove value from player's currency
        // done
    }
}
package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.Role;
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
        playerInventory.addItem(new InventoryItem("More!", 1000));
        
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
     * Calculates the total value of a specified inventory.
     * @param inventory
     * @return 
     */
    public static int calculateTotalValue(Inventory inventory) {
        int totalValue = 0;
        for (InventoryItem current : inventory.getContents()) {
            totalValue += current.getValue();
        }
        return totalValue;
    }
    
    /**
     * Calculates the resale value of a specific item. Takes into account the
     * skill of the crew member assigned to the trader role.
     * @param item
     * @return 
     */
    public static int calculateResaleValue(InventoryItem item) {
        int tradeModifier = CrewController.getCrewMemberAssignedTo(Role.TRADER).getStat(Role.TRADER);
        double baseResaleValue = 0.45;
        double resaleValue = baseResaleValue + (0.05 * tradeModifier);
        return (int) ((int) item.getValue() * resaleValue);
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
        currentInventory.addCurrency(calculateResaleValue(item));
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
        Inventory currentInventory = getInventory();
        
        Planet currentLocation = ShipController.getShip().getLocation();
        Inventory otherInventory = currentLocation.getShop();
        
        otherInventory.removeItem(item);
        otherInventory.addCurrency(item.getValue());
        currentInventory.addItem(item);
        currentInventory.removeCurrency(item.getValue());

        sortByValue(currentInventory);
        sortByValue(otherInventory);
    }
}
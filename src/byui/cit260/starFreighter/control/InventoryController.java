package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.ItemList;
import byui.cit260.starFreighter.constants.Role;
import byui.cit260.starFreighter.model.CrewRoster;
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
        Inventory inventory = new Inventory();
        return inventory;
    }
    
    /**
     * Gets the player's inventory.
     * @return 
     */
    public static Inventory getPlayerInventory() {
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
        CrewRoster playerCrew = CrewController.getPlayerRoster();
        int tradeModifier = playerCrew.getCrewMemberAssignedTo(Role.TRADER).getStat(Role.TRADER);
        double baseResaleValue = 0.45;
        double resaleValue = baseResaleValue + (0.05 * tradeModifier);
        return (int) ((int) item.getValue() * resaleValue);
    }
    
    /**
     * Sells a particular item to the shop on the current planet.
     * @param item 
     */
    public static void sellItem(InventoryItem item) {
        Inventory playerInventory = getPlayerInventory();
        
        Planet currentLocation = ShipController.getShip().getLocation();
        Inventory otherInventory = currentLocation.getShop();
        
        playerInventory.removeItem(item);
        playerInventory.addCurrency(calculateResaleValue(item));
        otherInventory.addItem(item);
        otherInventory.removeCurrency(item.getValue());

        sortByValue(playerInventory);
        sortByValue(otherInventory);
    }

    /**
     * Buys a particular item from the shop on the current planet.
     * @param item 
     */
    public static void buyItem(InventoryItem item) {
        Inventory playerInventory = getPlayerInventory();
        
        Planet currentLocation = ShipController.getShip().getLocation();
        Inventory otherInventory = currentLocation.getShop();
        
        otherInventory.removeItem(item);
        otherInventory.addCurrency(item.getValue());
        playerInventory.addItem(item);
        playerInventory.removeCurrency(item.getValue());

        sortByValue(playerInventory);
        sortByValue(otherInventory);
    }
    
    /**
     * Adds a bunch of debris to the player's inventory. Used in TravelDisplay.
     */
    public static void salvageDebris() {
        // Add a bunch of stuff to the player's inventory.
        Inventory playerInventory = getPlayerInventory();
        playerInventory.addItem(ItemList.JUNK);
        playerInventory.addItem(ItemList.JUNK);
        playerInventory.addItem(ItemList.JUNK);
        playerInventory.addItem(ItemList.JUNK);
        playerInventory.addItem(ItemList.JUNK);
        playerInventory.addItem(ItemList.OLD_PARTS);
        playerInventory.addItem(ItemList.OLD_PARTS);
        playerInventory.addItem(ItemList.OLD_PARTS);
        playerInventory.addItem(ItemList.NEW_PARTS);

        // Sort the player's inventory as a parting gesture.
        sortByValue(playerInventory);
    }
    
    /**
     * Empties the specified inventory.
     * @param inventory 
     */
    public static void emptyInventory(Inventory inventory) {
        inventory.empty();
    }
    
    /**
     * Adds the contents of a specified inventory to the player's inventory.
     * @param inventory 
     */
    public static void addInventoryToPlayerInventory(Inventory inventory) {
        // Get the player's inventory.
        Inventory playerInventory = getPlayerInventory();
        
        // Iterate over the specified inventory and add each item to the
        // player's inventory.
        inventory.getContents().stream().forEach((current) -> {
            playerInventory.addItem(current);
        });
        
        // Sort the player's inventory.
        sortByValue(playerInventory);
        
        // Give the player's inventory the other inventory's currency, too.
        playerInventory.setCurrency(playerInventory.getCurrency() + inventory.getCurrency());
    }
}
package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.Inventory;
import starfreighter.StarFreighter;

/**
 *
 */
public class InventoryController {

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
        return new Inventory();
    }
    
    /**
     * Gets the player's inventory.
     * @return 
     */
    public static Inventory getInventory() {
        return StarFreighter.getCurrentGame().getInventory();
    }
}
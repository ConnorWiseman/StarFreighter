package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.InventoryItem;
import byui.cit260.starFreighter.view.TextBox;

/**
 * 
 */
public class EncounterController {
    /**
     * Class constants.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32;1;2m";
    public static final String ANSI_YELLOW = "\u001B[33;1;2m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35;1m";
    public static final String ANSI_CYAN = "\u001B[36m";

    /**
     * Static constructor prevents instantiation.
     */
    private EncounterController() {
        
    }
    
    public static void generateEncounter() {
        TextBox.displayText("The " +
                ShipController.getShip().getName() +
                " embarks into the cold reaches of space...");
        
        int selection = RandomNumbers.range(1, 5);
        switch(selection) {
            case 1: {
                TextBox.displayText("... and arrives at its detination without incident.");
                break;
            }
            case 2: {
                TextBox.displayText("... and is attacked by space pirates!");
                break;
            }
            case 3: {
                TextBox.displayText("... and is attacked by space pirates!");
                break;
            }
            case 4: {
                TextBox.displayText(
                    "... and finds jettisoned cargo along the" +
                    " way! One man's trash is another man's treasure. You" +
                    " salvage everything you can find."
                );

                // Create a bunch of stuff...
                InventoryItem junk1 = new InventoryItem("Junk", 1);
                InventoryItem junk2 = new InventoryItem("Junk", 1);
                InventoryItem junk3 = new InventoryItem("Junk", 1);
                InventoryItem junk4 = new InventoryItem("Junk", 1);
                InventoryItem junk5 = new InventoryItem("Junk", 1);
                InventoryItem oldParts1 = new InventoryItem("Old Parts", 3);
                InventoryItem oldParts2 = new InventoryItem("Old Parts", 3);
                InventoryItem oldParts3 = new InventoryItem("Old Parts", 3);
                InventoryItem newParts = new InventoryItem("New Parts", 15);
                
                // ... then add it to the player's inventory.
                Inventory playerInventory = InventoryController.getInventory();
                playerInventory.addItem(junk1);
                playerInventory.addItem(junk2);
                playerInventory.addItem(junk3);
                playerInventory.addItem(junk4);
                playerInventory.addItem(junk5);
                playerInventory.addItem(oldParts1);
                playerInventory.addItem(oldParts2);
                playerInventory.addItem(oldParts3);
                playerInventory.addItem(newParts);
                
                // Sort the player's inventory as a parting gesture.
                InventoryController.sortByValue(playerInventory);
                break;
            }
            case 5: {
                TextBox.displayText("... and explodes into a million pieces!");
                break;
            }
        }
    }
}
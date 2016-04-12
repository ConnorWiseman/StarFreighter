package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.constants.Difficulty;
import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.control.PlanetSystemController;
import byui.cit260.starFreighter.control.RandomNumbers;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.Planet;
import byui.cit260.starFreighter.model.Ship;
import java.io.IOException;

/**
 *
 */
public class TravelView extends Display {
    /**
     * Class constants.
     */
    private static final CombatMenu COMBAT_MENU = new CombatMenu();

    /**
     * Displays the travel view to the player.
     */
    public static void display() {
        try {
            // Display the map so the player's not flying blind.
            MapDisplay.display();
            
            // We'll ask the player for a destination in an upcoming loop,
            // but we need to access it outside, too, so declare it here.
            Planet destination = null;
            
            // Get the player's ship.
            Ship playerShip = ShipController.getShip();
            
            // The distance to the player's destination begins at 0.0. In the
            // loop, if the distance is still 0.0 after selecting a destination,
            // that means the player is already on the planet they want to
            // travel to- so prompt them again.
            double distance = 0.0;

            while (true) {
                // Use a nested loop to make sure we get a destination and not null.
                while (destination == null) {
                    // Get an uppercase character for the player's selection.
                    char selection = Input.getCharSameLineUppercase("Enter planet symbol: ");

                    // Set the destination.
                    destination = PlanetSystemController.planetAtSymbol(selection);
                }

                // Calculate the distance.
                distance = PlanetSystemController.calculateDistance(destination);
                
                // Check to see if the player is traveling to a different planet.
                if (distance == 0.0) {
                    TextBox.displayText(
                        playerShip.getName() +
                        " is already docked on " +
                        destination.getName() +
                        "."
                    );
                    
                    // Set destination back to null. Important!
                    destination = null;
                    
                    // Start the loop over.
                    continue;
                }
                
                // Otherwise, break from the loop.
                break;
            }

            // Calculate the fuel cost.
            int fuelCost = ShipController.calculateFuelCost(distance);
            
            // Inform the player about the consequences of their actions.
            TextBox.displayText(
                destination.getName() +
                    ": " +
                    destination.getDesc(),
                "Target planet is " +
                    distance +
                    " lightyears away. Traveling to " +
                    destination.getName() +
                    " from " +
                    playerShip.getLocation().getName() +
                    " will consume " +
                    fuelCost +
                    " units of fuel."
            );
            
            // Does the player want to proceed?
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");
            
            // If the player does, then proceed. Otherwise, cancel travel.
            if (proceed == 'Y') {
                // Make sure the player's ship has enough fuel for the journey.
                if (playerShip.getFuel() >= fuelCost) {
                    // Update the player's location and fuel.
                    playerShip.setLocation(destination);
                    playerShip.setFuel(playerShip.getFuel() - fuelCost);
                    
                    // Then generate a random encounter.
                    randomEncounter();
                }
                else {
                    // Inform the player of the need to refuel.
                    TextBox.displayText(
                        "The " +
                        playerShip.getName() +
                        " doesn't have enough fuel to make the journey! You" +
                        " must refuel before launch."
                    );
                }
            }
            else {
                CONSOLE.println("Travel canceled.");
            }
        } catch (IOException error) {
            ErrorView.display(TravelView.class.getName(), error.getMessage());
        }
    }

    /**
     * Handles random encounters after successfully traveling.
     */
    private static void randomEncounter() {
        TextBox.displayText("The " +
                ShipController.getShip().getName() +
                " embarks into the cold reaches of space...");
        
        
        
        int selection = RandomNumbers.range(1, 4);
        switch(selection) {
            case 1: {
                TextBox.displayText("... and arrives at its destination without incident.");
                break;
            }
            case 2: {
                TextBox.displayText("... and is attacked by space pirates!");
                COMBAT_MENU.initiateCombat(Difficulty.EASY);
                break;
            }
            case 3: {
                TextBox.displayText("... and is attacked by space pirates!");
                COMBAT_MENU.initiateCombat(Difficulty.MEDIUM);
                break;
            }
            case 4: {
                TextBox.displayText(
                    "... and finds jettisoned cargo along the" +
                    " way! One man's trash is another man's treasure. You" +
                    " salvage everything you can find."
                );
                InventoryController.salvageDebris();
                break;
            }
        }
    }
}
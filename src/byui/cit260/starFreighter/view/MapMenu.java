package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.EncounterController;
import byui.cit260.starFreighter.control.PlanetSystemController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Planet;
import java.io.IOException;

/**
 * The map menu view, accessible in-game.
 */
public class MapMenu extends MenuView {
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public MapMenu() {
        menuTitle = "Map Menu";
        menuItems.add(new MenuItem('M', "Display map"));
        menuItems.add(new MenuItem('T', "Travel"));
        menuItems.add(new MenuItem('E', "Exit to previous menu"));
    }
    
    /**
     * Used to travel between planets.
     */
    private void travel() {
        try {
            MapDisplay.display();
            Planet destination = null;
            double distance = 0.0;

            while (true) {
                char selection = Input.getCharSameLineUppercase("Enter planet symbol: ");
                destination = PlanetSystemController.planetAtSymbol(selection);
                distance = PlanetSystemController.calculateDistance(destination);
                
                if (distance == 0.0) {
                    console.println(ShipController.getShip().getName() +
                            " is already docked on " +
                            destination.getName() +
                            ".");
                    continue;
                }
                break;
            }

            console.println(destination.getName() +
                    " is " +
                    distance +
                    " lightyears away.");
            
            int fuelCost = ShipController.calculateFuelCost(distance);
            
            console.println("Traveling there will consume " + fuelCost + " units of fuel.");
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");
            
            if (proceed == 'Y') {
                ShipController.getShip().setLocation(destination);
                ShipController.getShip().setFuel(ShipController.getShip().getFuel() - fuelCost);
                EncounterController.generateEncounter();
            }
            else {
                console.println("Travel canceled.");
            }
        } catch (IOException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'M': {
                MapDisplay.display();
                break;
            }
            case 'T': {
                travel();
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
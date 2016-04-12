package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.PlanetList;
import byui.cit260.starFreighter.model.Planet;
import byui.cit260.starFreighter.model.PlanetSystem;
import byui.cit260.starFreighter.model.Point;
import java.util.ArrayList;
import starfreighter.StarFreighter;

/**
 * A controller class for planetary systems. (Collections of planets).
 */
public final class PlanetSystemController {
    
    /**
     * Private constructor prevents instantiation.
     */
    private PlanetSystemController() {

    }
    
    /**
     * Creates a new planetary system. Called when making a new game.
     * @return 
     */
    public static PlanetSystem createSystem() {
        // We had this set up with a list of static enums, but I'm going to add
        // a bit of variety for gameplay's sake. Hence, this ugly-looking mess.
        
        // Create a new planet system.
        PlanetSystem system = new PlanetSystem();
        
        // Create each planet using some random numbers, and add it to the
        // system. Sorry, we gotta do it manually.
        system.addPlanet(PlanetList.KRYTA);
        system.addPlanet(PlanetList.QUALUFE);
        system.addPlanet(PlanetList.MEZOPAN);
        system.addPlanet(PlanetList.REDECENT);
        system.addPlanet(PlanetList.GOAL);
        
        // Return the system.
        return system;
    }
    
    /**
     * Gets the current game's planetary system.
     * @return 
     */
    public static PlanetSystem getSystem() {
        return StarFreighter.getCurrentGame().getPlanetSystem();
    }
    
    /**
     * Retrieves the planet at a specific pair of coordinates.
     * @param coords
     * @return 
     */
    public static Planet planetAt(Point coords) {
        ArrayList<Planet> planets = getSystem().getContents();
        for (Planet planet : planets) {
            if (planet.getCoords() == coords) {
                return planet;
            }
        }
        return null;
    }

    /**
     * Retrieves a planet with a given map symbol.
     * @param symbol
     * @return 
     */
    public static Planet planetAtSymbol(char symbol) {
        ArrayList<Planet> planets = getSystem().getContents();
        for (Planet planet : planets) {
            if (planet.getSymbol() == symbol) {
                return planet;
            }
        }
        return null;
    }
    
    /**
     * Retrieves the planet with a given name.
     * @param name
     * @return 
     */
    public static Planet planetNamed(String name) {
        ArrayList<Planet> planets = getSystem().getContents();
        for (Planet planet : planets) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }

    /**
     * Calculates the distance between two planets using the distance formula
     * @param desired
     * @return {double} the distance between the two planets
     */
    public static double calculateDistance(Planet desired) {
        Planet current = ShipController.getShip().getLocation();
        /* The distance formula between two points on a coordinate plane
           is given by sqrt( (x2 - x1)^2 + (y2 - y1)^2 ) */

        // Perform subtraction
        int coordX = (desired.getCoords().x - current.getCoords().x);
        int coordY = (desired.getCoords().y - current.getCoords().y);

        // Square the result
        double coordXSquared = Math.pow(coordX, 2);
        double coordYSquared = Math.pow(coordY, 2);
        // Cubing the result created some weird situations in which coordSum
        // became negative. You can't get the square root of a negative number,
        // so TravelView would print NaN as the distance to a planet "behind"
        // the player's position.
        // If you can change this function to fix that before tonight, be my
        // guest! Until then though, this needs to go back to squaring the
        // result, as per the distance forumla.

        // Add the squares
        double coordSum = coordXSquared + coordYSquared;

        // Return the square root of the summed squares
        return Math.sqrt(coordSum);
    }
}
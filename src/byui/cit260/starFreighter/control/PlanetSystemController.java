package byui.cit260.starFreighter.control;

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
     * Creates a new planetary system. Called when making a new game.
     * @return 
     */
    public static PlanetSystem createSystem() {
        // We had this set up with a list of static enums, but I'm going to add
        // a bit of variety for gameplay's sake. Hence, this ugly-looking mess.
        
        // Create a new planet system.
        PlanetSystem system = new PlanetSystem();
        
        // Create each planet using some random numbers, and add it to the
        // system.
        Point krytaCoords = new Point(1, RandomNumbers.range(2, 8));
        Planet kryta = new Planet("Kryta", "A barren desert planet with a few secrets", krytaCoords, 'K');
        system.addPlanet(kryta);
        
        Point qualufeCoords = new Point(RandomNumbers.range(3, 4), RandomNumbers.range(0, 9));
        Planet qualufe = new Planet("Qualufe", "Oceans as far as the eye can see", qualufeCoords, 'Q');
        system.addPlanet(qualufe);
        
        Point mezopanCoords = new Point(RandomNumbers.range(5, 6), RandomNumbers.range(3, 7));
        Planet mezopan = new Planet("Mezopan", "Green forests and tall trees", mezopanCoords, 'M');
        system.addPlanet(mezopan);

        Point redecentCoords = new Point(RandomNumbers.range(7, 8), RandomNumbers.range(4, 6));
        Planet redecent = new Planet("Redecent", "The galaxy's capital", redecentCoords, 'R');
        system.addPlanet(redecent);
        
        // Return the system.
        return system;
    }
    
    /**
     * Gets the current game's planetary system.
     * @return 
     */
    public static PlanetSystem getSystem() {
        return StarFreighter.currentGame().getPlanetSystem();
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
     * Calculates the distance between two planets using the distance formula
     * @param current
     * @param desired
     * @return {double} the distance between the two planets
     */
    public static double calculateDistance(Planet current, Planet desired) {
        /* The distance formula between two points on a coordinate plane
           is given by sqrt( (x2 - x1)^2 + (y2 - y1)^2 ) */

        // Perform subtraction
        int coordX = (desired.getCoords().x() - current.getCoords().x());
        int coordY = (desired.getCoords().y() - current.getCoords().y());

        // Square the result
        double coordXSquared = Math.pow(coordX, 2);
        double coordYSquared = Math.pow(coordY, 2);

        // Add the squares
        double coordSum = coordXSquared + coordYSquared;

        // Return the square root of the summed squares
        return Math.sqrt(coordSum);
    }
}
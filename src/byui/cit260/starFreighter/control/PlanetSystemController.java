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
        
        Point qualufeCoords = new Point(RandomNumbers.range(3, 4), RandomNumbers.range(1, 10));
        Planet qualufe = new Planet("Qualufe", "Oceans as far as the eye can see", qualufeCoords, 'Q');
        system.addPlanet(qualufe);
        
        Point mezopanCoords = new Point(RandomNumbers.range(5, 6), RandomNumbers.range(3, 7));
        Planet mezopan = new Planet("Mezopan", "Green forests and tall trees", mezopanCoords, 'M');
        system.addPlanet(mezopan);

        Point redecentCoords = new Point(RandomNumbers.range(5, 6), RandomNumbers.range(3, 7));
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
            if (planet.getCoords().x() == coords.x() &&
                planet.getCoords().y() == coords.y()) {
                return planet;
            }
        }
        return null;
    }
}
package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.Planet;

/**
 * Controls the map object.
 */
public class MapController {
    /**
     * Creates and returns a new game map object.
     * @param rows
     * @param columns
     * @return 
     */
    public static GameMap createMap(int rows, int columns) {
        return new GameMap(rows, columns);
    }

    /**
     * Calculates the distance between two planets using the distance formula
     * @param current
     * @param desired
     * @return {double} the distance between the two planets
     */
    public double calculateDistance(Planet current, Planet desired) {
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

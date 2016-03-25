package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.PlanetSystemController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.Point;
import java.io.PrintWriter;
import starfreighter.StarFreighter;

/**
 * A utility for displaying the game's map.
 */
public final class MapDisplay {
    /**
     * Class constants.
     */
    private final static int ROWS = 10; // number of horizontal rows in the map
    private final static int COLS = 18; // number of vertical columns in the map
    private final static char SYMBOL_EMPTY = '.'; // used to display empty space
    private final static int MAP_HSPACE = 1; // how much horizontal space in the grid
    private final static int MAP_VSPACE = 0; // how much vertical space in the grid
    private final static PrintWriter console = StarFreighter.getOutFile();

    /**
     * Private constructor prevents instantiation.
     */
    private MapDisplay() {
        
    }

    /**
     * Displays the map.
     */
    public static void display() {
        // Create an empty map to display.
        char[][] displayMap = new char[ROWS][COLS];
        
        // Fill the map with empty space.
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                displayMap[row][col] = SYMBOL_EMPTY;
            }
        }
        
        // Fill the planets in on the map.
        PlanetSystemController.getSystem().getContents().stream().forEach((current) -> {
            Point coords = current.getCoords();
            displayMap[coords.y][coords.x] = current.getSymbol();
        });
        
        // Display the map.
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                console.write(displayMap[row][col]);
                console.flush();
                displayHorizontalSpace();
            }
            displayVerticalSpace();
        }
        
        // Display the ship's current location.
        String shipName = ShipController.getShip().getName();
        String location = ShipController.getShip().getLocation().getName();
        TextBox.displayText("The " + shipName + " is currently docked on " + location + ".");
    }
    
    /**
     * Displays horizontal spacing using ' '
     */
    private static void displayHorizontalSpace() {
        for (int i = 0; i < MAP_HSPACE; i++) {
            console.write(' ');
            console.flush();
        }
    }

    /**
     * Displays vertical spacing using '\n'
     */
    private static void displayVerticalSpace() {
        console.write('\n');
        console.flush();
        for (int i = 0; i < MAP_VSPACE; i++) {
            console.write('\n');
            console.flush();
        }
    }
}
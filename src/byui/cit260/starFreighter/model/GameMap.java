package byui.cit260.starFreighter.model;

import java.io.Serializable;

/**
 *
 * @author Connor
 */
public class GameMap implements Serializable {
    // Class constants
    private final int ROWS; // number of horizontal rows in the map
    private final int COLS; // number of vertical columns in the map
    private final char SYMBOL_EMPTY = '.'; // used to display empty space
    private final int MAP_HSPACE = 1; // how much horizontal space in the grid
    private final int MAP_VSPACE = 0; // how much vertical space in the grid

    private final char[][] displayMap;

    public int getRows() {
        return this.ROWS;
    }
    
    public int getColumns() {
        return this.COLS;
    }
    
    public int getHorizontalSpace() {
        return this.MAP_HSPACE;
    }

    public int getVerticalSpace() {
        return this.MAP_VSPACE;
    }
    
    public char[][] getContents() {
        return this.displayMap;
    }
    
    /**
     * Populates the map array with character data.
     * @param rows
     * @param cols
     */
    public GameMap(int rows, int cols) {
        this.ROWS = rows;
        this.COLS = cols;

        displayMap = new char[ROWS][COLS];

        // fill the map with a bunch of initial values
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                displayMap[row][col] = SYMBOL_EMPTY;
            }
        }
        // next, fill in the planets
        /* todo: "can use functional operations"? I don't get it,
           sticking with syntax I understand */
        for (Planet current : Planet.values()) {
            Point coords = current.coords();
            int x = coords.x();
            int y = coords.y();
            displayMap[y][x] = current.getSymbol();
        }
    }
}
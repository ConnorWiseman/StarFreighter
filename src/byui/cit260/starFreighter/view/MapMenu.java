package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.MenuItem;
import starfreighter.StarFreighter;

/**
 * The help menu view, accessible in-game.
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

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'M':
                displayMap();
                break;
            case 'T':
                // travel
                break;
            case 'E':
                return true;
            default:
                System.out.println(INVALID);
                break;
        }
        return false;
    }

    /**
     * Displays the map.
     */
    public void displayMap() {
        displayTopLegend();
        displayRows();
    }

    
    /**
     * Displays horizontal spacing using ' '
     */
    private void displayHorizontalSpace() {
        GameMap map = StarFreighter.currentGame().getMap();
        for (int i = 0; i < map.getHorizontalSpace(); i++) {
            System.out.print(' ');
        }
    }

    
    /**
     * Displays vertical spacing using '\n'
     */
    private void displayVerticalSpace() {
        GameMap map = StarFreighter.currentGame().getMap();
        System.out.print('\n');
        for (int i = 0; i < map.getVerticalSpace(); i++) {
            System.out.print('\n');
        }
    }


    /**
     * Displays the top row of coordinate identifiers.
     * Called in displayMap.
     */
    private void displayTopLegend() {
        GameMap map = StarFreighter.currentGame().getMap();
        // print a single empty space to offset the legend
        System.out.print(' ');
        
        displayHorizontalSpace();
        
        for (int col = 0; col < map.getColumns(); col++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char colIdentifier = Character.toChars(65 + col)[0];
            System.out.print(colIdentifier);
            displayHorizontalSpace();
        }
        
        // print a single newline to end the legend
        System.out.print('\n');
    }


    /**
     * Displays each row.
     * Called in displayMap.
     */
    private void displayRows() {
        GameMap map = StarFreighter.currentGame().getMap();
        for (int row = 0; row < map.getRows(); row++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char rowIdentifier = Character.toChars(65 + row)[0];
            System.out.print(rowIdentifier);
            
            this.displayHorizontalSpace();
            this.displayCells(row);
            this.displayVerticalSpace();
        }
    }
    

    /**
     * Displays the cells in a specified row.
     * Called in displayRows.
     * @param row 
     */
    private void displayCells(int row) {
        GameMap map = StarFreighter.currentGame().getMap();
        for (int col = 0; col < map.getColumns(); col++) {
            System.out.print(map.getContents()[row][col]);
            this.displayHorizontalSpace();
        }
    }
}
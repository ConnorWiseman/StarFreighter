package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;

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
        MapDisplay.display();
    }
}
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;

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

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'M': {
                MapDisplay.display();
                break;
            }
            case 'T': {
                // travel
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
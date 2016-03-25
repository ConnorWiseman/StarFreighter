package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;

/**
 * The in-game menu view.
 */
public final class GameMenu extends MenuView {
    /**
     * Class properties. Additional views called by this view.
     */
    private final ShipMenu shipMenu = new ShipMenu();
    private final CrewMenu crewMenu = new CrewMenu();
    private final InventoryMenu inventoryMenu = new InventoryMenu();
    private final MapMenu mapMenu = new MapMenu();
    private final HelpMenu helpMenu = new HelpMenu();
    
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public GameMenu() {
        menuTitle = "Game Menu";
        menuItems.add(new MenuItem('S', "Ship Control"));
        menuItems.add(new MenuItem('C', "Captain and Crew"));
        menuItems.add(new MenuItem('M', "Map & Navigation"));
        menuItems.add(new MenuItem('I', "Inventory"));
        menuItems.add(new MenuItem('H', "Help"));
        menuItems.add(new MenuItem('E', "Exit to main menu"));
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S': {
                shipMenu.display();
                break;
            }
            case 'C': {
                crewMenu.display();
                break;
            }
            case 'M': {
                mapMenu.display();
                break;
            }
            case 'I': {
                inventoryMenu.display();
                break;
            }
            case 'H': {
                helpMenu.display();
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
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final JobMenu jobMenu = new JobMenu();
    private final HelpMenu helpMenu = new HelpMenu();

    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public GameMenu() {
        menuTitle = "Game Menu";
        menuItems.add(new MenuItem('S', "Ship"));
        menuItems.add(new MenuItem('C', "Crew"));
        menuItems.add(new MenuItem('T', "Travel"));
        menuItems.add(new MenuItem('I', "Inventory"));
        menuItems.add(new MenuItem('J', "Jobs"));
        menuItems.add(new MenuItem('H', "Help"));
        menuItems.add(new MenuItem('E', "Exit to main menu"));
    }

    /**
     * Displays a game over message.
     */
    private void displayGameOver() {
        TextBox.displayText(
                "Your ship was destroyed and your quest is at an end. Perhaps "
                + "your next venture will be more successful?",
                "GAME OVER"
        );
    }

    /**
     * Displays a game over message.
     */
    private void displayYouWin() {
        TextBox.displayText(
                "Congratulations! You are the first brave adventurer to make it"
                + " to the deep-space phenomenon and so its many treasures"
                + " are now yours.",
                "YOU WIN"
        );
    }

    private boolean confirm() {
        try {
            char confirm = Input.getCharSameLineUppercase("Are you sure you want to exit? (Y/N): ");
            if (confirm == 'Y') {
                return true;
            } 
            if (confirm == 'N') {
                display();
            }
            else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true; 
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
            case 'T': {
                // Display the travel view.
                TravelView.display();

                // Did the player die?
                if (ShipController.getShip().getHull() <= 0) {
                    displayGameOver();
                    return true;
                }

                if ("Endgame".equals(ShipController.getShip().getLocation().getName())) {
                    displayYouWin();
                    return true;
                }
                break;
            }
            case 'I': {
                inventoryMenu.display();
                break;
            }
            case 'J': {
                jobMenu.display();
                break;
            }
            case 'H': {
                helpMenu.display();
                break;
            }
            case 'E': {
                if (confirm())
                    return true;
            }
            default: {
                CONSOLE.println(INVALID);
                break;
            }
        }
        return false;
    }
}

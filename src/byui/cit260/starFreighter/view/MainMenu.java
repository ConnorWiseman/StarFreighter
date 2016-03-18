package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.GameController;
import byui.cit260.starFreighter.model.MenuItem;

/**
 * The game's main menu view.
 * @author Connor
 */
public final class MainMenu extends MenuView {
    /**
     * Class properties. Additional views called by this view.
     */
    private final GameMenu gameMenu = new GameMenu();

    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public MainMenu() {
        menuTitle = "Main Menu";
        menuItems.add(new MenuItem('N', "New Game"));
        menuItems.add(new MenuItem('L', "Load Game"));
        menuItems.add(new MenuItem('S', "Save Game"));
        menuItems.add(new MenuItem('E', "Exit"));
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'N': {
                GameController.newGame();
                gameMenu.display();
                break;
            }
            case 'L':
                //this.startExistingGame();
                break;
            case 'S':
                //this.saveGame();
                break;
            case 'E':
                return true;
            default:
                System.out.println(INVALID);
                break;
        }
        return false;
    }
}
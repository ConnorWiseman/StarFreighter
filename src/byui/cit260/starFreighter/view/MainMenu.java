package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.GameController;
import byui.cit260.starFreighter.exceptions.GameControlException;
import byui.cit260.starFreighter.model.MenuItem;
import java.io.IOException;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;

/**
 * The game's main menu view.
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

    /**
     * Starts a new game.
     */
    private void newGame() {
        // Prompt the player for their name and the name of their ship.
        String playerName = Input.getStringSameLine("Please enter your name: ");
        String shipName = Input.getStringSameLine("Please name your ship: ");
        GameController.newGame(playerName, shipName);
        gameMenu.display();
    }
    
    /**
     * Loads a saved game.
     */
    private void loadGame() {
        try {
            GameController.loadGame();
            out.println("File successfully loaded.");
            gameMenu.display();
        } catch (GameControlException | IOException | ClassNotFoundException error) {
            out.println("Unable to load game. Error: ");
            System.out.println(error.getMessage());
            StarFreighter.MAIN_MENU.display();
        }
    }
    
    /**
     * Saves the current game.
     */
    private void saveGame() {
        try {
            GameController.saveGame();
            out.println("File successfully saved.");
            gameMenu.display();
        } catch (GameControlException ex) {
            out.println("Unable to save game. Error: ");
            out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(StarFreighter.MAIN_MENU.getTitle()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'N': {
                this.newGame();
                break;
            }
            case 'L': {
                this.loadGame();
                break;
            }
            case 'S': {
                this.saveGame();
                break;
            }
            case 'E': {
                return true;
            }
            default: {
                System.out.println(INVALID);
                break;
            }
        }
        return false;
    }
}
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.GameController;
import byui.cit260.starFreighter.exceptions.GameControlException;
import byui.cit260.starFreighter.model.MenuItem;
import java.io.IOException;

/**
 * The game's main menu view.
 */
public final class MainMenu extends MenuView {
    /**
     * Class properties. Additional views called by this view.
     */
    private final GameMenu gameMenu = new GameMenu();

    /**
     * Class constructor. Sets menu title and defines all menu items. In this
     * case, also displays the game's startup message.
     */
    public MainMenu() {
        menuTitle = "Main Menu";
        menuItems.add(new MenuItem('N', "New Game"));
        menuItems.add(new MenuItem('L', "Load Game"));
        menuItems.add(new MenuItem('S', "Save Game"));
        menuItems.add(new MenuItem('E', "Exit"));
        
        // Display startup text.
        TextBox.displayText(
            "You are a newly dubbed captain.",
            "A deep space phenomenon has been observed which could be the key" +
                " to finding an ancient alien treasure. You're not the first" +
                " captain to hear about it, you have to hurry! There's no" +
                " chance your ship can get there first with the state it's in.",
            "You're in luck that jobs are popping up all over the galaxy." +
                " Travel to distant planets completing jobs and fighting" +
                " enemies so you can upgrade your ship. There's no time to" +
                " wait, the other captains are on their way to the treasure!",
            "Riches await you out there, it's your chance to become a legend." +
                " Do you have what it takes?"
        );
    }

    /**
     * Starts a new game.
     */
    private void newGame() {
        try {
            // Prompt the player for their name and the name of their ship.
            String playerName = Input.getStringSameLine("Please enter your name: ");
            String shipName = Input.getStringSameLine("Please name your ship: ");

            // Create a new game.
            GameController.newGame(playerName, shipName);

            // Welcome the player.
            TextBox.displayText(
                "Welcome, Captain " + playerName + " of the " + shipName + "."
            );

            // Display the game menu.
            gameMenu.display();
        } catch (IOException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
    }
    
    /**
     * Loads a saved game.
     */
    private void loadGame() {
        try {
            GameController.loadGame();
            TextBox.displayText("Welcome back, Captain. You have the bridge.");
            gameMenu.display();
        } catch (GameControlException | IOException | ClassNotFoundException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
    }
    
    /**
     * Saves the current game.
     */
    private void saveGame() {
        try {
            GameController.saveGame();
            CONSOLE.println("File successfully saved.");
            gameMenu.display();
        } catch (GameControlException | IOException saveError) {
            ErrorView.display(this.getClass().getName(), saveError.getMessage());
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'N': {
                newGame();
                break;
            }
            case 'L': {
                loadGame();
                break;
            }
            case 'S': {
                saveGame();
                break;
            }
            case 'E': {
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
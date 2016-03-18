package starfreighter;

import byui.cit260.starFreighter.model.GameInstance;
import byui.cit260.starFreighter.view.MainMenu;
import byui.cit260.starFreighter.view.TextBox;

/**
 * StarFreighter. Let's play?
 * @author Connor
 */
public class StarFreighter {
    /**
     * Class constants.
     */
    private static final TextBox TEXT_BOX = new TextBox();
    private static final MainMenu MAIN_MENU = new MainMenu();

    /**
     * Class properties.
     */
    private static GameInstance CURRENT_GAME;

    /**
     * Launches the game.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TEXT_BOX.displayText(
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
        MAIN_MENU.display();
    }

    /**
     * Retrieves the current game instance.
     * @return 
     */
    public static GameInstance currentGame() {
        return CURRENT_GAME;
    }

    /**
     * Updates the current game instance.
     * @param newGame 
     */
    public static void setCurrentGame(GameInstance newGame) {
        CURRENT_GAME = newGame;
    }
}
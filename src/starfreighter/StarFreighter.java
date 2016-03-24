package starfreighter;

import byui.cit260.starFreighter.model.GameInstance;
import byui.cit260.starFreighter.view.MainMenu;
import byui.cit260.starFreighter.view.TextBox;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * StarFreighter. Let's play?
 */
public class StarFreighter {
    /**
     * Class constants.
     */
    public static final MainMenu MAIN_MENU = new MainMenu();
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    /**
     * Class properties.
     */
    private static GameInstance CURRENT_GAME;

    /**
     * Launches the game.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            StarFreighter.inFile = new BufferedReader(new InputStreamReader(System.in));
            StarFreighter.outFile = new PrintWriter(System.out, true);
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
            MAIN_MENU.display();
        } catch (Throwable startError) {
            System.out.println("Exception: " + startError.toString()
                    + "\nCause: " + startError.getCause()
                    + "\nMessage: " + startError.getMessage());
        } 
        finally {
            try {
                if (StarFreighter.inFile != null) {
                    StarFreighter.inFile.close();
                }
                if (StarFreighter.outFile != null) {
                    StarFreighter.outFile.close();
                }
            } 
            catch (IOException ex) { 
                System.out.println("Error closing files");
                return;   
            }
        }
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
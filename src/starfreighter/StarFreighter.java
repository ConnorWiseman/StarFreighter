package starfreighter;

import byui.cit260.starFreighter.model.GameInstance;
import byui.cit260.starFreighter.view.MainMenu;
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
    private static PrintWriter logFile = null;

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
                if (StarFreighter.logFile != null) {
                    StarFreighter.logFile.close();
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
    public static GameInstance getCurrentGame() {
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
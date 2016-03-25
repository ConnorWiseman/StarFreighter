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
    public static MainMenu mainMenu;
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
            String errorPath = "log.txt";
            StarFreighter.logFile = new PrintWriter(errorPath);
            mainMenu = new MainMenu();
            mainMenu.display();
        } catch (Throwable startError) {
            System.out.println(
                "Exception: " + startError.toString() + 
                "\nCause: " + startError.getCause() + 
                "\nMessage: " + startError.getMessage()
            );
            startError.printStackTrace();
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
            catch (IOException closeError) {
                System.out.println("Error closing files.");
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

    /**
     * Gets the outfile.
     * @return 
     */
    public static PrintWriter getOutFile() {
        return outFile;
    }

    /**
     * Sets the outfile.
     * @param outFile 
     */
    public static void setOutFile(PrintWriter outFile) {
        StarFreighter.outFile = outFile;
    }

    /**
     * Gets the infile.
     * @return 
     */
    public static BufferedReader getInFile() {
        return inFile;
    }

    /**
     * Sets the infile.
     * @param inFile 
     */
    public static void setInFile(BufferedReader inFile) {
        StarFreighter.inFile = inFile;
    }

    /**
     * Gets the log file.
     * @return 
     */
    public static PrintWriter getLogFile() {
        return logFile;
    }

    /**
     * Sets the log file.
     * @param logFile 
     */
    public static void setLogFile(PrintWriter logFile) {
        StarFreighter.logFile = logFile;
    }
}
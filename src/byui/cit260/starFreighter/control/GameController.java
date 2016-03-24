package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.exceptions.GameControlException;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.GameInstance;
import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.Player;
import byui.cit260.starFreighter.model.Ship;
import byui.cit260.starFreighter.view.TextBox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import starfreighter.StarFreighter;

/**
 * Controls the GameInstance object.
 */
public class GameController {
    
    /**
     * Creates a new game.
     * @param playerName
     * @param shipName
     */
    public static void newGame(String playerName, String shipName) {
        // Create a new GameInstance object.
        GameInstance newGame = new GameInstance();

        // Create a new Player.
        Player newPlayer = PlayerController.createPlayer(playerName);

        // Welcome the player.
        TextBox.displayText(
            "Welcome, Captain " + newPlayer.name() + ".",
            "What is your ship called, sir?"
        );

        // Create a new Ship.
        Ship newShip = ShipController.createShip(shipName);

        // Create a CrewRoster for the Ship.
        CrewRoster newRoster = CrewController.createCrew(newPlayer.name());

        // Create a new Map.
        GameMap newMap = MapController.createMap(10, 10);

        // Add the created objects to the new GameInstance.
        newGame.setPlayer(newPlayer);
        newGame.setShip(newShip);
        newGame.setCrew(newRoster);
        newGame.setMap(newMap);

        /* Pass the new GameInstance up to the main program so it can be
           accessed from within the various game views. */
        StarFreighter.setCurrentGame(newGame);
    }

    /**
     * Loads an existing game.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws GameControlException 
     */
    public static void loadGame() throws IOException, ClassNotFoundException, GameControlException {
        // Create a new game instance for the loaded game.
        GameInstance loadedGame = new GameInstance();
        String saveFilePath = System.getProperty("user.home") +
                File.separator + "StarFreighter" + File.separator +
                "save.data";
        
        // Read the save file.
        try (FileInputStream fip = new FileInputStream(saveFilePath)) {
            ObjectInputStream output = new ObjectInputStream(fip);
            // Coerce the save file to the data format expected by a GameInstance.
            loadedGame = (GameInstance) output.readObject();
        } catch (FileNotFoundException error) {
            throw new GameControlException(error.getMessage());
        }

        // Set the current game instance in the main class.
        StarFreighter.setCurrentGame(loadedGame);
    }
    
    /**
     * Saves the current game.
     * @throws GameControlException
     * @throws IOException 
     */
    public static void saveGame() throws GameControlException, IOException {
        String saveFilePath = System.getProperty("user.home") +
                    File.separator + "StarFreighter" + File.separator + 
                    "save.data";
        
        // Create a new save directory.
        try {
            new File(System.getProperty("user.home") + File.separator + "StarFreighter").mkdir();
        } catch (SecurityException error) {
            System.out.println("Error while creating directory in Java:" + error);
        }

        // Save the current game instance to the directory.
        try (FileOutputStream fop = new FileOutputStream(saveFilePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fop);
            output.writeObject(StarFreighter.currentGame());
        } catch (IOException error) {
            throw new GameControlException(error.getMessage());
        }
    }
}
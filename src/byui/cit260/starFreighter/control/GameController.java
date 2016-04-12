package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.FetchJobList;
import byui.cit260.starFreighter.constants.ItemList;
import static byui.cit260.starFreighter.control.PlanetSystemController.planetNamed;
import byui.cit260.starFreighter.exceptions.GameControlException;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.GameInstance;
import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.JobRegistry;
import byui.cit260.starFreighter.model.Planet;
import byui.cit260.starFreighter.model.PlanetSystem;
import byui.cit260.starFreighter.model.Player;
import byui.cit260.starFreighter.model.Ship;
import byui.cit260.starFreighter.view.ErrorView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import starfreighter.StarFreighter;

/**
 * Controls the GameInstance object.
 */
public class GameController {
    /**
     * Class constants.
     */
    protected static final PrintWriter console = StarFreighter.getOutFile();
    
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

        // Create a new Ship.
        Ship newShip = ShipController.createShip(shipName);
        
        // Create the player's inventory and give them a little cash.
        Inventory newInventory = InventoryController.createInventory();
        newInventory.addItem(ItemList.NEW_PARTS);
        newInventory.addItem(ItemList.JUNK);
        newInventory.addItem(ItemList.NEW_PARTS);
        newInventory.addItem(ItemList.JUNK);
        newInventory.addItem(ItemList.NEW_PARTS);
        newInventory.addItem(ItemList.JUNK);
        newInventory.setCurrency(100);

        // Create a CrewRoster for the Ship.
        CrewRoster newRoster = CrewController.createCrew(newPlayer.getName());
        
        // Create a PlanetSystem for this game instance.
        PlanetSystem planets = PlanetSystemController.createSystem();
        
        // Create a JobRegistry for this game instance.
        JobRegistry jobs = JobController.createJobRegistry();

        // Add the created objects to the new GameInstance.
        newGame.setPlayer(newPlayer);
        newGame.setShip(newShip);
        newGame.setInventory(newInventory);
        newGame.setCrew(newRoster);
        newGame.setPlanetSystem(planets);
        newGame.setJobRegistry(jobs);

        /* Pass the new GameInstance up to the main program so it can be
           accessed from within the various game views. */
        StarFreighter.setCurrentGame(newGame);
        
        
        // Assign some jobs. There's probably a better way to do this...
        // I don't like including job related stuff in here, it feels out of
        // place. Any suggestions?
        JobRegistry kryta = planetNamed("Kryta").getJobRegistry();
        kryta.add(JobController.createFetchJob(FetchJobList.TRADE_NEW_PARTS));
        kryta.add(JobController.createFetchJob(FetchJobList.TRADE_OLD_PARTS));
        
                JobRegistry qualufe = planetNamed("Qualufe").getJobRegistry();
        kryta.add(JobController.createFetchJob(FetchJobList.TRADE_BIO_SEDIMENTS));
        kryta.add(JobController.createFetchJob(FetchJobList.TRADE_PEARL));
        // Set the ship's starting point. We have to do this, 'cause they're
        // generated randomly. We also have to do this here, because the controller
        // reads from the game instance- without an instance set, we'll get
        // a null pointer exception.
        Planet start = PlanetSystemController.planetNamed("Kryta");
        newShip.setLocation(start);
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
        // This check avoids saving if no game has been started.
        GameInstance currentGame = StarFreighter.getCurrentGame();
        if (currentGame == null) {
            return;
        }
        
        String saveFilePath = System.getProperty("user.home") +
                    File.separator + "StarFreighter" + File.separator + 
                    "save.data";
        
        // Create a new save directory.
        try {
            new File(System.getProperty("user.home") + File.separator + "StarFreighter").mkdir();
        } catch (SecurityException error) {
            ErrorView.display(GameController.class.getName(), error.getMessage());
        }

        // Save the current game instance to the directory.
        try (FileOutputStream fop = new FileOutputStream(saveFilePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fop);
            output.writeObject(currentGame);
        } catch (IOException error) {
            throw new GameControlException(error.getMessage());
        }
    }
}
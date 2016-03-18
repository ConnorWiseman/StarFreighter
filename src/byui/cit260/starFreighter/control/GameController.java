package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.GameInstance;
import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.Player;
import byui.cit260.starFreighter.model.Ship;
import byui.cit260.starFreighter.view.Input;
import byui.cit260.starFreighter.view.TextBox;
import starfreighter.StarFreighter;

/**
 *
 * @author Connor
 */
public class GameController {
    /**
     * Creates a new game.
     */
    public static void newGame() {
        // Create a new GameInstance object.
        GameInstance newGame = new GameInstance();

        String playerName = Input.getStringSameLine("Please enter your name: ");

        // Create a new Player.
        Player newPlayer = PlayerController.createPlayer(playerName);

        // Welcome the player.
        TextBox.displayText(
            "Welcome, Captain " + newPlayer.name() + ".",
            "What is your ship called, sir?"
        );

        // Prompt the player for the name of their ship.
        String shipName = Input.getStringSameLine("Please name your ship: ");

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
}
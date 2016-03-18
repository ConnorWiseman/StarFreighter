package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.Player;

/**
 *
 * @author Connor
 */
public class PlayerController {
    /**
     * Creates a new Player object.
     * @param playerName
     * @return 
     */
    public static Player createPlayer(String playerName) {
        // Prompt the player for their name and create a new Player object.
        return new Player(playerName);
    }
}
package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.Player;
import byui.cit260.starFreighter.view.Input;

/**
 *
 * @author Connor
 */
public class PlayerController {
    /**
     * Creates a new Player object.
     * @return 
     */
    public static Player createPlayer() {
        // Prompt the player for their name and create a new Player object.
        String playerName = Input.getStringSameLine("Please enter your name: ");
        return new Player(playerName);
    }
}
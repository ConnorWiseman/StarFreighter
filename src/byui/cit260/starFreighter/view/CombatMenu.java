package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.constants.Difficulty;
import byui.cit260.starFreighter.control.PirateController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Ship;
import byui.cit260.starFreighter.model.SpacePirate;
import java.io.IOException;

/**
 * The combat menu is used in-game to fight off space pirates.
 */
public class CombatMenu extends MenuView {
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public CombatMenu() {
        menuTitle = "Combat Menu";
        menuItems.add(new MenuItem('F', "Fight"));
        menuItems.add(new MenuItem('R', "Run"));
    }

    /**
     * Initiates combat, then displays the combat menu.
     * @param difficulty
     */
    public void initiateCombat(Difficulty difficulty) {
        SpacePirate enemyShip = PirateController.createEnemy(difficulty);
        CONSOLE.print(enemyShip);
        display();
    }
    
    /**
     * Fights the enemy.
     */
    public void engageEnemy() {
        
    }
    
    /**
     * Flees the enemy.
     * @return 
     */
    public boolean fleeEnemy() {
        try {
            // Get the player's ship.
            Ship playerShip = ShipController.getShip();

            // Warn the player about the consequences for being a coward.
            TextBox.displayText(
                "Fleeing from this fight will burn through an additional 10 units of fuel."
            );
            // Does the player want to proceed?
            char proceed = Input.getCharSameLineUppercase("Proceed? (Y/N) ");

            // If the player does, then proceed. Otherwise, cancel.
            if (proceed == 'Y') {
                // Make sure the player's ship has enough extra fuel to run.
                if (playerShip.getFuel() >= 10) {
                    // Update the player's fuel.
                    playerShip.setFuel(playerShip.getFuel() - 10);
                    
                    // Display a confirmation message.
                    TextBox.displayText(
                        "Though the " +
                        ShipController.getShip().getName() +
                        "'s engines almost overheat in the process, you manage" +
                        " to flee the space pirates and arrive at your" +
                        " destination safely."
                    );
                    return true;
                }
                else {
                    // Inform the player of the lack of fuel.
                    // Should have stocked up!
                    TextBox.displayText(
                        "The " +
                        playerShip.getName() +
                        " doesn't have enough fuel to run away! You" +
                        " must fight on!"
                    );
                    return false;
                }
            }
            else {
                // The player changed their mind. Back to the fight.
                return false;
            }
        } catch (IOException error) {
            ErrorView.display(TravelView.class.getName(), error.getMessage());
        }

        // Make Java happy; add a return value down here.
        return false;
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'F': {
                engageEnemy();
                break;
            }
            case 'R': {
                if (fleeEnemy()) {
                    return true;
                }
                break;
            }
            default: {
                CONSOLE.println(INVALID);
                break;
            }
        }
        return false;
    }
}
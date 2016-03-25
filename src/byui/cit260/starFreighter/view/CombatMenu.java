package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.constants.Difficulty;
import byui.cit260.starFreighter.constants.Role;
import byui.cit260.starFreighter.control.CombatController;
import byui.cit260.starFreighter.control.CrewController;
import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.control.PirateController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Ship;
import byui.cit260.starFreighter.model.SpacePirate;
import java.io.IOException;

/**
 * The combat menu is used in-game to fight off space pirates.
 */
public class CombatMenu extends MenuView {
    /**
     * Class members.
     */
    private SpacePirate enemy;

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
        // Update the enemy to reflect the current encounter.
        enemy = PirateController.createEnemy(difficulty);
        
        // Then display the menu.
        display();
    }
    
    /**
     * Fights the enemy.
     * @todo Implement this!
     */
    private boolean engageEnemy() {
        // Get the player and enemy ships.
        Ship playerShip = ShipController.getShip();
        Ship enemyShip = enemy.getShip();
                
        // Get the player and enemy crews.
        CrewRoster playerCrew = CrewController.getPlayerRoster();
        CrewRoster enemyCrew = enemy.getRoster();
        
        // Get the player and enemy attack pools. These are essentially the number
        // of virtual dice to roll for either party. Larger pools = more dice =
        // greater potential damage.
        // Luck could still mess you up, though, so always weight the player's
        // pool in their favor (+2).
        // Upset players = nobody plays. It's the opposite of the Las Vegas
        // house-must-win philosophy.
        int playerAttackPool = playerCrew.getCrewMemberAssignedTo(Role.FIGHTER).getStat(Role.FIGHTER) + 2;
        int enemyAttackPool = enemyCrew.getCrewMemberAssignedTo(Role.FIGHTER).getStat(Role.FIGHTER);
        
        // Calculate damage amounts.
        int playerDamage = CombatController.calculateDamage(playerAttackPool);
        int enemyDamage = CombatController.calculateDamage(enemyAttackPool);
        
        // Display battle information.
        TextBox.displayText(
            "The space pirates attack! Hull integrity drops by " +
                enemyDamage +
                " points!",
            "The " + playerShip.getName() + " returns fire! The enemy " +
                "vessel's hull integrity drops by " +
                playerDamage +
                " points!"
        );
        
        // Have each ship trade blows, as it were.
        playerShip.setHull(playerShip.getHull() - enemyDamage);
        enemyShip.setHull(enemyShip.getHull() - playerDamage);
        
        // Handle the results of this round of battle.
        if (playerShip.getHull() <= 0 && enemyShip.getHull() <= 0) {
            // Set the hull to 1.
            playerShip.setHull(1);
            
            // Display the outcome.
            TextBox.displayText(
                "The enemy's ship explodes in a fiery blast," +
                " but the " +
                playerShip.getName() +
                " has sustained crippling damage. You barely manage to drift" +
                " to safety..."
            );
            return true;
        }
        else if (playerShip.getHull() <= 0) {
            // Set the hull to 1.
            playerShip.setHull(1);
            
            // Take the player's items and half their money.
            Inventory playerInventory = InventoryController.getPlayerInventory();
            InventoryController.emptyInventory(playerInventory);
            playerInventory.setCurrency(playerInventory.getCurrency() / 2);
            
            // Display the outcome.
            TextBox.displayText(
                "The space pirates prove victorious. They board the " +
                    playerShip.getName() +
                    " and plunder your cargo, leaving nothing behind.",
                "Your battered vessel lands"
            );
            return true;
        }
        else if (enemyShip.getHull() <= 0) {
            // Take the space pirates' stuff.
            InventoryController.addInventoryToPlayerInventory(enemy.getInventory());
            
            // Display the outcome.
            TextBox.displayText(
                "You destroy the space pirates' vessel and " +
                "seize their cargo."
            );
            return true;
        }

        // Return false by default.
        return false;
    }
    
    /**
     * Flees the enemy.
     * @return 
     */
    private boolean fleeEnemy() {
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
                if (engageEnemy()) {
                    return true;
                }
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
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;

/**
 * The help menu view, accessible in-game.
 */
public class HelpMenu extends MenuView {
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public HelpMenu() {
        menuTitle = "Help Menu";
        menuItems.add(new MenuItem('G', "Objectives"));
        menuItems.add(new MenuItem('C', "Crew classes"));
        menuItems.add(new MenuItem('J', "Jobs"));
        menuItems.add(new MenuItem('N', "Navigation"));
        menuItems.add(new MenuItem('R', "Repairs and Upgrades"));
        menuItems.add(new MenuItem('T', "Trading"));
        menuItems.add(new MenuItem('E', "Exit to previous menu"));
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'G': {
                TextBox.displayText(
                    "You are a spaceship captain desiring to be the best and" +
                        " wealthiest in the galaxy. A deep-space phenomena" +
                        " has occurred which could lead you to an ancient" +
                        " alien treasure. You need to earn money by" +
                        " completing jobs and selling items to upgrade your" +
                        "ship."
                );
                break;
            }
            case 'C': {
                TextBox.displayText(
                    "There are five crew member roles.",
                    "Pilot: The better they are the faster you travel and the" +
                        " less fuel you use.",
                    "Mechanic: Upgrades are cheaper and repairs are as well." +
                        " They might even add some bonus upgrades.",
                    "Fighter: Who needs brains when you can beat anyone in a" +
                        " fight? The better the fighter the quicker you'll" +
                        " defeat your enemies.",
                    "Doctor: When your ego is hurt or you're just injured," +
                        " the doctor will have you up and going quicker than" +
                        "WebMD.",
                    "Trader: Who doesn't love some bartering? Buy low, sell" +
                        " high!"
                );
                break;
            }
            case 'J': {
                TextBox.displayText(
                    "You can access the jobs boards on any planet. You'll be" +
                        " given a task to complete and rewarded upon" +
                        " completion. You may receive parts you need for your" +
                        " ship, money, or items you can sell. Merchants can" +
                        " be accessed at any time from the game menu."
                );
                break;
            }
            case 'N': {
                TextBox.displayText(
                    "You can access the map anytime in the game menu. Each" +
                        " location has a specific distance and fuel cost. You" +
                        " don't want to run out of fuel on your way to a" +
                        " planet."
                );
                break;
            }
            case 'R': {
                TextBox.displayText(
                    "Merchants can be accessed in the game menu. You can sell" +
                        " items you don't need or buy what you need. You need" +
                        " to upgrade your ship to be able to make it to the" +
                        " phenomena. You can earn parts from jobs or buy them" +
                        " from merchants. Your ship might get damaged in your" +
                        " travels, you can use parts to repair your ship as" +
                        " well. Repairs and Upgrades options are in the game" +
                        " menu."
                );
                break;
            }
            case 'T': {
                //this.displayHelpMenu();
                break;
            }
            case 'E': {
                return true;
            }
            default: {
                CONSOLE.println(INVALID);
                break;
            }
        }
        return false;
    }
}
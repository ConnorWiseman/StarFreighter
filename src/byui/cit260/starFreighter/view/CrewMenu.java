package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.CrewController;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.MenuItem;

/**
 * The game's main menu view.
 */
public final class CrewMenu extends MenuView {
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public CrewMenu() {
        menuTitle = "Crew Menu";
        menuItems.add(new MenuItem('S', "Crew status"));
        menuItems.add(new MenuItem('D', "Details"));
        menuItems.add(new MenuItem('E', "Exit"));
    }

    /**
     * Displays the crew list and status.
     * @todo Tidy it up with printf?
     */
    private void displayCrew() {
        for (CrewMember member : CrewController.getRoster()) {
            CONSOLE.println(member.name() + ":\t\t" + member.getHitPoints() +
                "/" + member.getMaxHitPoints() + "HP");
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S': {
                displayCrew();
                break;
            }
            case 'D': {
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
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
        menuItems.add(new MenuItem('E', "Exit"));
    }

    private void displayCrew() {
        for (CrewMember member : CrewController.getRoster()) {
            console.println(member.name() + ":\t\t" + member.hitPoints() +
                "/" + member.maxHitPoints() + "HP");
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S': {
                displayCrew();
                break;
            }
            case 'E': {
                return true;
            }
            default: {
                console.println(INVALID);
                break;
            }
        }
        return false;
    }
}
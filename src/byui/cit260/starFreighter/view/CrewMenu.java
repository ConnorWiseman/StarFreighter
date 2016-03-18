package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.MenuItem;
import starfreighter.StarFreighter;

/**
 * The game's main menu view.
 * @author Connor
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
        CrewRoster crew = StarFreighter.currentGame().getCrew();
        for (CrewMember member : crew.getRoster()) {
            System.out.println(member.name() + ":\t\t" + member.hitPoints() +
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
            case 'E':
                return true;
            default:
                System.out.println(INVALID);
                break;
        }
        return false;
    }
}
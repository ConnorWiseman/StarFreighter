package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.constants.Role;
import byui.cit260.starFreighter.control.CrewController;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.MenuItem;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
        menuItems.add(new MenuItem('R', "Print report"));
        menuItems.add(new MenuItem('E', "Exit"));
    }

    /**
     * Displays the crew list and status.
     * @todo Tidy it up with printf?
     */
    private void displayCrew() {
        for (CrewMember member : CrewController.getPlayerRoster().getContents()) {
            CONSOLE.println(member.getName() + ":\t\t" + member.getHitPoints() +
                "/" + member.getMaxHitPoints() + "HP");
        }
    }
    
    
    private void printCrewReport() {
        String filePath;
        try {
            filePath = Input.getString("Filepath to save report to:");
            writeReportToFile(filePath);
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }
    
    
    private void writeReportToFile(String filePath) {
        try(PrintWriter out = new PrintWriter(filePath + File.separator + "crewreport.txt")) {
            CrewRoster crew = CrewController.getPlayerRoster();
            out.println("\n\n      Crew Report");
            out.printf("%n%-20s%20s%20s%20s%20s%20s%20s", "Name", "HitPoints", "Pilot Points", "Fighter Points", "Doctor Points", "Mechanic Points", "Trader Points");
            out.printf("%n%-20s%20s%20s%20s%20s%20s%20s", "--------------------", "-------", "-------", "-------", "-------", "-------", "-------");
            for (CrewMember current : crew.getContents()) {
                out.printf("%n%-20s%20s%20s%20s%20s%20s%20s", current.getName(), current.getHitPoints(), current.getStat(Role.PILOT), current.getStat(Role.FIGHTER), current.getStat(Role.DOCTOR), current.getStat(Role.MECHANIC), current.getStat(Role.TRADER));
            }
            CONSOLE.println("Crew report printed at " + filePath + ".");
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S': {
                displayCrew();
                break;
            }
            case 'R': {
                printCrewReport();
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
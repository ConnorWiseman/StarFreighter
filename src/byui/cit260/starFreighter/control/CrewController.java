package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.Role;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.CrewStatistics;
import starfreighter.StarFreighter;

/**
 * Controls the crew.
 */
public class CrewController {
    public static CrewRoster createCrew(String name) {
        CrewMember captain = CrewController.createCrewMember(name);
        captain.setStat(Role.FIGHTER, 4);

        CrewMember crewOne = CrewController.createCrewMember("Spock");
        crewOne.setStat(Role.TRADER, 4);

        CrewMember crewTwo = CrewController.createCrewMember("Bones");
        crewTwo.setStat(Role.DOCTOR, 4);

        CrewMember crewThree = CrewController.createCrewMember("McCoy");
        crewThree.setStat(Role.MECHANIC, 4);

        CrewMember crewFour = CrewController.createCrewMember("Sulu");
        crewFour.setStat(Role.PILOT, 4);

        CrewRoster roster = new CrewRoster();
        roster.set(Role.FIGHTER, captain);
        roster.set(Role.TRADER, crewOne);
        roster.set(Role.DOCTOR, crewTwo);
        roster.set(Role.MECHANIC, crewThree);
        roster.set(Role.PILOT, crewFour);
        return roster;
    }

    private static CrewMember createCrewMember(String name) {
        CrewStatistics stats = new CrewStatistics();
        return new CrewMember(name, stats);
    }
    
    public static CrewMember[] getRoster() {
        return StarFreighter.getCurrentGame().getCrew().getRoster();
    }
}
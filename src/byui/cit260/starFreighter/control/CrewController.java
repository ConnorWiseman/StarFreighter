package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.CrewStatistics;

/**
 *
 * @author Connor
 */
public class CrewController {
    public static CrewRoster createCrew(String name) {
        CrewMember captain = CrewController.createCrewMember(name);
        captain.setStat(CrewMember.STAT.FIGHTER, 4);

        CrewMember crewOne = CrewController.createCrewMember("Spock");
        crewOne.setStat(CrewMember.STAT.TRADER, 4);

        CrewMember crewTwo = CrewController.createCrewMember("Bones");
        crewTwo.setStat(CrewMember.STAT.DOCTOR, 4);

        CrewMember crewThree = CrewController.createCrewMember("McCoy");
        crewThree.setStat(CrewMember.STAT.MECHANIC, 4);

        CrewMember crewFour = CrewController.createCrewMember("Sulu");
        crewFour.setStat(CrewMember.STAT.PILOT, 4);

        CrewRoster roster = new CrewRoster();
        roster.set(CrewRoster.ROLE.FIGHTER, captain);
        roster.set(CrewRoster.ROLE.TRADER, crewOne);
        roster.set(CrewRoster.ROLE.DOCTOR, crewTwo);
        roster.set(CrewRoster.ROLE.MECHANIC, crewThree);
        roster.set(CrewRoster.ROLE.PILOT, crewFour);
        return roster;
    }

    private static CrewMember createCrewMember(String name) {
        CrewStatistics stats = new CrewStatistics();
        return new CrewMember(name, stats);
    }
}
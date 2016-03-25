package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.Difficulty;
import byui.cit260.starFreighter.constants.Role;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.CrewRoster;
import byui.cit260.starFreighter.model.CrewStatistics;
import starfreighter.StarFreighter;

/**
 * Controls the crew.
 */
public class CrewController {

    /**
     * Creates a crew roster, feature the player as the captain.
     * (In name only)
     * @param name
     * @return 
     */
    public static CrewRoster createCrew(String name) {
        // Create a crew of five.
        CrewMember captain = createCrewMember(name);
        captain.setStat(Role.FIGHTER, 4);

        CrewMember crewOne = createCrewMember("Spock");
        crewOne.setStat(Role.TRADER, 4);

        CrewMember crewTwo = createCrewMember("Bones");
        crewTwo.setStat(Role.DOCTOR, 4);

        CrewMember crewThree = createCrewMember("McCoy");
        crewThree.setStat(Role.MECHANIC, 4);

        CrewMember crewFour = createCrewMember("Sulu");
        crewFour.setStat(Role.PILOT, 4);

        // Create a new crew roster.
        CrewRoster roster = new CrewRoster();
        
        // Assign each crew member their initial role.
        roster.set(Role.FIGHTER, captain);
        roster.set(Role.TRADER, crewOne);
        roster.set(Role.DOCTOR, crewTwo);
        roster.set(Role.MECHANIC, crewThree);
        roster.set(Role.PILOT, crewFour);
        
        // Return the roster.
        return roster;
    }

    /**
     * Creates a crew member with the given name.
     * @param name
     * @return 
     */
    public static CrewMember createCrewMember(String name) {
        CrewStatistics stats = new CrewStatistics();
        return new CrewMember(name, stats);
    }
    
    /**
     * Gets the current crew roster.
     * @return 
     */
    public static CrewMember[] getRoster() {
        return StarFreighter.getCurrentGame().getCrew().getRoster();
    }
    
    /**
     * Gets the crew member assigned to a specific role.
     * @param role
     * @return 
     */
    public static CrewMember getCrewMemberAssignedTo(Role role) {
        return getRoster()[role.ordinal()];
    }
}
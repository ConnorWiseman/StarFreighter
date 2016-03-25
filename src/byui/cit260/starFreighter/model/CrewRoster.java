package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.Role;
import java.io.Serializable;
import java.util.Arrays;

/**
 * An abstraction layer between a Ship and its CrewMembers.
 */
public class CrewRoster implements Serializable {
    /**
     * Class members.
     */
    private final CrewMember[] roster = new CrewMember[5];

    /**
     * Gets the crew roster.
     * @return 
     */
    public CrewMember[] getContents() {
        return roster;
    }

    /**
     * Sets the specified crew member to the specified role.
     * @param index
     * @param crewMember 
     */
    public void set(Role index, CrewMember crewMember) {
        roster[index.ordinal()] = crewMember;
    }

    /**
     * Gets the crew member assigned to a specific role.
     * @param role
     * @return 
     */
    public CrewMember getCrewMemberAssignedTo(Role role) {
        return getContents()[role.ordinal()];
    }

    /**
     * Sets the specified crew member to the specified role.
     * @param index
     * @param crewMember 
     */
    public void set(int index, CrewMember crewMember) {
        roster[index] = crewMember;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Arrays.deepHashCode(this.roster);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CrewRoster other = (CrewRoster) obj;
        return Arrays.deepEquals(this.roster, other.roster);
    }

    @Override
    public String toString() {
        return "CrewRoster{" + "roster=" + Arrays.toString(roster) + '}';
    }
}
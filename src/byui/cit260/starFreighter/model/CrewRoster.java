package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.Role;
import java.io.Serializable;
import java.util.Arrays;

/**
 * An abstraction layer between a Ship and its CrewMembers.
 */
public class CrewRoster implements Serializable {
    private final CrewMember[] roster = new CrewMember[5];

    public CrewMember[] getRoster() {
        return roster;
    }

    public void set(Role index, CrewMember crewMember) {
        roster[index.ordinal()] = crewMember;
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
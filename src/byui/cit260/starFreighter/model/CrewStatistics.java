package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * An abstraction layer between a CrewMember and their StatPoints.
 */
public class CrewStatistics implements Serializable {
    private final StatPoint[] stats = new StatPoint[5];

    public CrewStatistics() {
        stats[0] = new StatPoint(0);
        stats[1] = new StatPoint(0);
        stats[2] = new StatPoint(0);
        stats[3] = new StatPoint(0);
        stats[4] = new StatPoint(0);
    }

    public StatPoint[] list() {
        return stats;
    }

    public StatPoint get(int index) {
        return stats[index];
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.stats);
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
        final CrewStatistics other = (CrewStatistics) obj;
        return Objects.equals(this.stats, other.stats);
    }

    @Override
    public String toString() {
        return "CrewStatistics{" + "stats=" + Arrays.toString(stats) + '}';
    }
}
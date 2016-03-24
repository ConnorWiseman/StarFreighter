package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.Role;
import java.io.Serializable;
import java.util.Objects;

/**
 * A class representing a crew member.
 */
public class CrewMember implements Serializable {
    private final CrewStatistics stats;
    private final String name;
    private int hitPoints = 30;
    private final int maxHitPoints = 30;
    private boolean alive = true;

    public CrewMember(String name, CrewStatistics stats) {
        this.name = name;
        this.stats = stats;
    }

    public String name() {
        return name;
    }

    public int hitPoints() {
        return hitPoints;
    }

    public int maxHitPoints() {
        return maxHitPoints;
    }

    public int stat(Role index) {
        return stats.get(index.ordinal()).value();
    }

    public void setStat(Role index, int value) {
        stats.get(index.ordinal()).setValue(value);
    }
    
    public boolean alive() {
        return alive;
    }
    
    public void setAlive(boolean status) {
        alive = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.stats);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + this.hitPoints;
        hash = 17 * hash + this.maxHitPoints;
        hash = 17 * hash + (this.alive ? 1 : 0);
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
        final CrewMember other = (CrewMember) obj;
        if (this.hitPoints != other.hitPoints) {
            return false;
        }
        if (this.maxHitPoints != other.maxHitPoints) {
            return false;
        }
        if (this.alive != other.alive) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.stats, other.stats)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CrewMember{" + "stats=" + stats + ", name=" + name + ", hitPoints=" + hitPoints + ", maxHitPoints=" + maxHitPoints + ", alive=" + alive + '}';
    }
}
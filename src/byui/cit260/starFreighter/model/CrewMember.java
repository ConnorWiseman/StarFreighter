package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.Role;
import java.io.Serializable;
import java.util.Objects;

/**
 * A class representing a crew member. Used by both player crew and those
 * dastardly space pirates.
 */
public class CrewMember implements Serializable {
    /**
     * Class members.
     */
    private final CrewStatistics stats;
    private final String name;
    private int hitPoints = 30;
    private final int maxHitPoints = 30;
    private boolean alive = true;

    /**
     * Constructor
     * @param name
     * @param stats 
     */
    public CrewMember(String name, CrewStatistics stats) {
        this.name = name;
        this.stats = stats;
    }

    /**
     * Gets the crew member's name.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the crew member's hit points.
     * @return 
     */
    public int getHitPoints() {
        return hitPoints;
    }
    
    /**
     * Sets the crew member's hit points.
     * @param value 
     */
    public void setHitPoints(int value) {
        hitPoints = value;
    }

    /**
     * Gets the crew member's max hit points.
     * @return 
     */
    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    /**
     * Gets a specified stat from the crew member.
     * @param index
     * @return 
     */
    public int getStat(Role index) {
        if (alive) {
            return stats.get(index.ordinal()).value();
        }
        // If the crew member is dead, their stats are all effectively zero.
        return 0;
    }

    /**
     * Sets the crew member's specified stat.
     * @param index
     * @param value 
     */
    public void setStat(Role index, int value) {
        stats.get(index.ordinal()).setValue(value);
    }
    
    /**
     * Gets the crew member's living status.
     * @return 
     */
    public boolean getAlive() {
        return alive;
    }
    
    /**
     * Sets the crew member's living status.
     * @param status 
     */
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
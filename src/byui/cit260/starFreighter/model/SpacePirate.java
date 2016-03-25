package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A container class for a space pirate crew and their ship.
 */
public class SpacePirate implements Serializable {
    /**
     * Class members.
     */
    private final Ship ship;
    private final CrewRoster crew;
    
    /**
     * Constructor.
     * @param ship
     * @param crew 
     */
    public SpacePirate(Ship ship, CrewRoster crew) {
        this.ship = ship;
        this.crew = crew;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ship);
        hash = 29 * hash + Objects.hashCode(this.crew);
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
        final SpacePirate other = (SpacePirate) obj;
        if (!Objects.equals(this.ship, other.ship)) {
            return false;
        }
        return Objects.equals(this.crew, other.crew);
    }

    @Override
    public String toString() {
        return "SpacePirate{" + "ship=" + ship + ", crew=" + crew + '}';
    }
}
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
    private final Inventory inventory;
    
    /**
     * Constructor.
     * @param ship
     * @param crew 
     * @param inventory 
     */
    public SpacePirate(Ship ship, CrewRoster crew, Inventory inventory) {
        this.ship = ship;
        this.crew = crew;
        this.inventory = inventory;
    }
    
    /**
     * Gets the space pirate's ship.
     * @return 
     */
    public Ship getShip() {
        return ship;
    }
    
    /**
     * Gets the space pirate's crew.
     * @return 
     */
    public CrewRoster getRoster() {
        return crew;
    }

    /**
     * Gets the space pirate's inventory.
     * @return 
     */
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.ship);
        hash = 73 * hash + Objects.hashCode(this.crew);
        hash = 73 * hash + Objects.hashCode(this.inventory);
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
        if (!Objects.equals(this.crew, other.crew)) {
            return false;
        }
        return Objects.equals(this.inventory, other.inventory);
    }

    @Override
    public String toString() {
        return "SpacePirate{" + "ship=" + ship + ", crew=" + crew + ", inventory=" + inventory + '}';
    }
}
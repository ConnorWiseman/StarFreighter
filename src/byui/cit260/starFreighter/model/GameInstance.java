package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A game instance object. Contains all necessary values for saving/loading.
 */
public class GameInstance implements Serializable {
    /**
     * Class members.
     */
    private Player player;
    private Ship ship;
    private Inventory inventory;
    private CrewRoster crew;
    private PlanetSystem planets;

    /**
     * Class constructor.
     */
    public GameInstance() {
        
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * @param ship the ship to set
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    /**
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
    
    /**
     * @param inventory the inventory to set
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * @return the crew
     */
    public CrewRoster getCrew() {
        return crew;
    }

    /**
     * @param crew the crew to set
     */
    public void setCrew(CrewRoster crew) {
        this.crew = crew;
    }
    
    /**
     * Gets the planet system.
     * @return 
     */
    public PlanetSystem getPlanetSystem() {
        return planets;
    }
    
    /**
     * Sets the planet system.
     * @param planets 
     */
    public void setPlanetSystem(PlanetSystem planets) {
        this.planets = planets;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.player);
        hash = 97 * hash + Objects.hashCode(this.ship);
        hash = 97 * hash + Objects.hashCode(this.inventory);
        hash = 97 * hash + Objects.hashCode(this.crew);
        hash = 97 * hash + Objects.hashCode(this.planets);
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
        final GameInstance other = (GameInstance) obj;
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.ship, other.ship)) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Objects.equals(this.crew, other.crew)) {
            return false;
        }
        return Objects.equals(this.planets, other.planets);
    }

    @Override
    public String toString() {
        return "GameInstance{" + "player=" + player + ", ship=" + ship + ", inventory=" + inventory + ", crew=" + crew + ", planets=" + planets + '}';
    }
}
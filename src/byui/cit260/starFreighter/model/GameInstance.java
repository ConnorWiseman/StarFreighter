package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A game instance object. Contains all necessary values for saving/loading.
 */
public class GameInstance implements Serializable {
    private Player player;
    private Ship ship;
    private CrewRoster crew;
    private GameMap map;

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
     * @return the map
     */
    public GameMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(GameMap map) {
        this.map = map;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.player);
        hash = 17 * hash + Objects.hashCode(this.ship);
        hash = 17 * hash + Objects.hashCode(this.crew);
        hash = 17 * hash + Objects.hashCode(this.map);
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
        if (!Objects.equals(this.crew, other.crew)) {
            return false;
        }
        return Objects.equals(this.map, other.map);
    }

    @Override
    public String toString() {
        return "GameInstance{" + "player=" + player + ", ship=" + ship + ", crew=" + crew + ", map=" + map + '}';
    }
}
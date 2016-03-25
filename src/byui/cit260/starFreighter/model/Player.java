package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Very simple player object.
 */
public class Player implements Serializable {
    /**
     * Class properties.
     */
    private final String name;

    /**
     * Creates a new player with the specified name.
     * @param name 
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Retrieves the player's name.
     * @return 
     */
    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
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
        final Player other = (Player) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }
}
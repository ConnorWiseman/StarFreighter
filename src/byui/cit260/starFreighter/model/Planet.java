package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a planet.
 */
public final class Planet implements Serializable {
    /**
     * Class members.
     */
    private final String name;
    private final String desc;
    private final Point coords;
    private final char symbol;

    /**
     * Class constructor.
     * @param name
     * @param desc
     * @param coords
     * @param symbol 
     */
    public Planet(String name, String desc, Point coords, char symbol) {
        this.name = name;
        this.desc = desc;
        this.coords = coords;
        this.symbol = symbol;
    }
    
    /**
     * Gets the planet's name.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the planet's description.
     * @return 
     */
    public String getDesc() {
        return desc;
    }
    
    /**
     * Gets the planet's coordinates.
     * @return 
     */
    public Point getCoords() {
        return coords;
    }
    
    /**
     * Gets the planet's map symbol.
     * @return 
     */
    public char getSymbol() {
        return symbol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.desc);
        hash = 31 * hash + Objects.hashCode(this.coords);
        hash = 31 * hash + this.symbol;
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
        final Planet other = (Planet) obj;
        if (this.symbol != other.symbol) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.desc, other.desc)) {
            return false;
        }
        return Objects.equals(this.coords, other.coords);
    }

    @Override
    public String toString() {
        return "Planet{" + "name=" + name + ", desc=" + desc + ", coords=" + coords + ", symbol=" + symbol + '}';
    }
}
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
    private final Inventory shop;

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
        this.shop = new Inventory();
        this.shop.setCurrency(10000);
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
    
    /**
     * Gets the planet's shop.
     * @return 
     */
    public Inventory getShop() {
        return shop;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.desc);
        hash = 71 * hash + Objects.hashCode(this.coords);
        hash = 71 * hash + this.symbol;
        hash = 71 * hash + Objects.hashCode(this.shop);
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
        if (!Objects.equals(this.coords, other.coords)) {
            return false;
        }
        return Objects.equals(this.shop, other.shop);
    }

    @Override
    public String toString() {
        return "Planet{" + "name=" + name + ", desc=" + desc + ", coords=" + coords + ", symbol=" + symbol + ", shop=" + shop + '}';
    }
}
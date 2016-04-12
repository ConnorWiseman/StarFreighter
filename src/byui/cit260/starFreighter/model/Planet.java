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
    private final char symbol;
    private final Point coords;
    private final Inventory shop;
    private final JobRegistry jobs;

    /**
     * Class constructor.
     * @param name
     * @param desc
     * @param symbol
     * @param coords
     */
    public Planet(String name, String desc, char symbol, Point coords) {
        this.name = name;
        this.desc = desc;
        this.symbol = symbol;
        this.coords = coords;
        this.shop = new Inventory();
        this.shop.setCurrency(10000);
        this.jobs = new JobRegistry();
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

    /**
     * Get's the planet's job list.
     * @return 
     */
    public JobRegistry getJobRegistry() {
        return jobs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.desc);
        hash = 73 * hash + this.symbol;
        hash = 73 * hash + Objects.hashCode(this.coords);
        hash = 73 * hash + Objects.hashCode(this.shop);
        hash = 73 * hash + Objects.hashCode(this.jobs);
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
        if (!Objects.equals(this.shop, other.shop)) {
            return false;
        }
        return Objects.equals(this.jobs, other.jobs);
    }

    @Override
    public String toString() {
        return "Planet{" + "name=" + name + ", desc=" + desc + ", symbol=" + symbol + ", coords=" + coords + ", shop=" + shop + ", jobs=" + jobs + '}';
    }
}
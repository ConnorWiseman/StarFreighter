package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A class representing a ship. The player has one. Space pirates have them, too.
 */
public class Ship implements Serializable {
    /**
     * Class properties.
     */
    private String name;
    // Max health/fuel.
    private int fuelCapacity;
    private int hullIntegrity;
    // Current health/fuel.
    private int fuel;
    private int hull;
    // The planetary location of this particular ship.
    private Planet location;

    /**
     * Class constructor. Sets default values.
     * @param name 
     */
    public Ship(String name) {
        this.name = name;
    }

    /**
     * Gets the Ship's name.
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Renames the Ship.
     * @param newName 
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Gets the Ship's fuel capacity.
     * @return 
     */
    public int fuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Sets the Ship's fuel capacity.
     * @param newCapacity 
     */
    public void setFuelCapacity(int newCapacity) {
        this.fuelCapacity = newCapacity;
    }

    /**
     * Gets the Ship's hull integrity.
     * @return 
     */
    public int hullIntegrity() {
        return hullIntegrity;
    }

    /**
     * Sets the Ship's hull integrity.
     * @param newIntegrity 
     */
    public void setHullIntegrity(int newIntegrity) {
        this.hullIntegrity = newIntegrity;
    }

    /**
     * Gets the Ship's fuel.
     * @return
     */
    public int fuel() {
        return fuel;
    }

    /**
     * Sets the Ship's fuel.
     * @param amount 
     */
    public void setFuel(int amount) {
        this.fuel = amount;
    }

    /**
     * Gets the Ship's hull status.
     * @return
     */
    public int hull() {
        return hull;
    }

    /**
     * Sets the Ship's hull status.
     * @param amount 
     */
    public void setHull(int amount) {
        this.hull = amount;
    }
    
    /**
     * Gets the Ship's current location.
     * @return 
     */
    public Planet getLocation() {
        return location;
    }
    
    /**
     * Sets the Ship's current location.
     * @param location 
     */
    public void setLocation(Planet location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + this.fuelCapacity;
        hash = 83 * hash + this.hullIntegrity;
        hash = 83 * hash + this.fuel;
        hash = 83 * hash + this.hull;
        hash = 83 * hash + Objects.hashCode(this.location);
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
        final Ship other = (Ship) obj;
        if (this.fuelCapacity != other.fuelCapacity) {
            return false;
        }
        if (this.hullIntegrity != other.hullIntegrity) {
            return false;
        }
        if (this.fuel != other.fuel) {
            return false;
        }
        if (this.hull != other.hull) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.location, other.location);
    }

    @Override
    public String toString() {
        return "Ship{" + "name=" + name + ", fuelCapacity=" + fuelCapacity + ", hullIntegrity=" + hullIntegrity + ", fuel=" + fuel + ", hull=" + hull + ", location=" + location + '}';
    }
}
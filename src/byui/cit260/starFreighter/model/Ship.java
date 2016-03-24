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
    public String name() {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.fuelCapacity;
        hash = 97 * hash + this.hullIntegrity;
        hash = 97 * hash + this.fuel;
        hash = 97 * hash + this.hull;
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
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Ship{" + "name=" + name + ", fuelCapacity=" + fuelCapacity + ", hullIntegrity=" + hullIntegrity + ", fuel=" + fuel + ", hull=" + hull + '}';
    }
}
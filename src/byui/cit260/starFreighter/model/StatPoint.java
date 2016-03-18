package byui.cit260.starFreighter.model;

import java.io.Serializable;

/**
 * A simple representation of a stat point.
 * @author Connor
 */
class StatPoint implements Serializable {
    /**
     * Class properties.
     */
    private int value;

    /**
     * Constructor. Assigns a value to the stat point.
     * @param value 
     */
    public StatPoint(int value) {
        this.value = value;
    }

    /**
     * Gets the stat point.
     * @return 
     */
    public int value() {
        return value;
    }

    /**
     * Sets the stat point.
     * @param newValue 
     */
    public void setValue(int newValue) {
        this.value = newValue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.value;
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
        final StatPoint other = (StatPoint) obj;
        return this.value == other.value;
    }

    @Override
    public String toString() {
        return "StatPoint{" + "value=" + value + '}';
    }
}
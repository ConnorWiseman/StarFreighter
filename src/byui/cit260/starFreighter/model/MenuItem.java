package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple representation of a menu item.
 * @author Connor
 */
public class MenuItem implements Serializable {
    /**
     * Class instance properties.
     */
    private final char symbol;
    private final String name;

    /**
     * Class constructor.
     * @param symbol
     * @param name 
     */
    public MenuItem(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    /**
     * Gets the MenuItem's one-character symbol.
     * @return 
     */
    public char symbol() {
        return this.symbol;
    }

    /**
     * Gets the MenuItem's name.
     * @return 
     */
    public String name() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.symbol;
        hash = 79 * hash + Objects.hashCode(this.name);
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
        final MenuItem other = (MenuItem) obj;
        if (this.symbol != other.symbol) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "symbol=" + symbol + ", name=" + name + '}';
    }
}

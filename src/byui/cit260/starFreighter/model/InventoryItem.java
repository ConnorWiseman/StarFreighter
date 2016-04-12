package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.ItemList;
import java.io.Serializable;
import java.util.Objects;

/**
 * A basic data structure for items in an inventory.
 */
public class InventoryItem implements Serializable {
    /**
     * Class instance members.
     */
    private String name;
    private int value;
    private int quantity;

    /**
     * Class constructor.
     * @param name
     * @param value 
     * @param quantity 
     */
    public InventoryItem(String name, int value, int quantity) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * Alternative class constructor.
     * @param item 
     */
    public InventoryItem(ItemList item) {
        this.name = item.getName();
        this.value = item.getValue();
    }

    /**
     * Gets the item's name.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the item's name.
     * @param newName 
     */
    public void setName(String newName) {
        name = newName;
    }
    
    /**
     * Gets the item's value.
     * @return 
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Sets the item's value.
     * @param newValue 
     */
    public void setValue(int newValue) {
        value = newValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + this.value;
        hash = 83 * hash + this.quantity;
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
        final InventoryItem other = (InventoryItem) obj;
        if (this.value != other.value) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "name=" + name + ", value=" + value + ", quantity=" + quantity + '}';
    }

    
   
}
package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A data model for a system of planets.
 */
public class PlanetSystem implements Serializable {
    /**
     * Class members.
     */
    private final ArrayList<Planet> contents;
    
    /**
     * Class constructor.
     */
    public PlanetSystem() {
        contents = new ArrayList<>();
    }
    
    /**
     * Gets the contents of the planetary system.
     * @return 
     */
    public ArrayList<Planet> getContents() {
        return contents;
    }
    
    /**
     * Adds a planet to the planetary system.
     * @param newPlanet 
     */
    public void addPlanet(Planet newPlanet) {
        contents.add(newPlanet);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.contents);
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
        final PlanetSystem other = (PlanetSystem) obj;
        return Objects.equals(this.contents, other.contents);
    }

    @Override
    public String toString() {
        return "PlanetSystem{" + "contents=" + contents + '}';
    }
}
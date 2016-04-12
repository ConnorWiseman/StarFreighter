package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.FetchJobList;
import java.io.Serializable;

/**
 * A basic data model for jobs that involve acquiring or trading something.
 */
public final class FetchJob extends Job implements JobInterface, Serializable {




    private final int quantity;
    /**
     * Class members.
     */
    private int acquired;

    /**
     * Class constructor.
     *
     * @param job
     */
    public FetchJob(FetchJobList job) {
        super(job);
        this.quantity = job.getQuantity();

    }

    /**
     * Gets the number of items fetched for this job.
     *
     * @return
     */
    public int getAcquired() {
        return acquired;
    }

    /**
     * Sets the number of items fetched for this job.
     *
     * @param value
     */
    public void setAcquired(int value) {
        acquired = value;
    }

    @Override
    public boolean progress(FetchJob job, Inventory otherInventory) {
        //runs through inventory of merchant
        for (InventoryItem current : otherInventory.getContents()) {
            //If the names of item and job item match 
            if (current.getName().equals(job.getName())) {
                //if quantity match, return true
                if (current.getQuantity() == job.quantity) {
                    job.setComplete(true);
                    return true; 
                }
            }
            //Set acquired to the quantity sold so far
            setAcquired(current.getQuantity());
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.quantity;
        hash = 89 * hash + this.acquired;
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
        final FetchJob other = (FetchJob) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        return this.acquired == other.acquired;
    }

    @Override
    public String toString() {
        return "FetchJob{" + "name=" + name + ", description=" + description + ", rewards=" + rewards + ", complete=" + complete + ", quantity=" + quantity + ", acquired=" + acquired + '}';
    }
}

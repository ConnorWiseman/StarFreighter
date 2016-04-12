package byui.cit260.starFreighter.model;

/**
 * An interface to ensure consistent behavior between different jobs.
 */
public interface JobInterface {
    public boolean progress(FetchJob job, Inventory otherInventory);
}
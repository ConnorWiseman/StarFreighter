package byui.cit260.starFreighter.constants;

import byui.cit260.starFreighter.model.Inventory;

/**
 * A list of the jobs in the game that involve trading something.
 */
public enum FetchJobList {
    TRADE_NEW_PARTS("New Parts",
            "Trade 1 New Parts.",
            1,
            RewardList.TRADE_NEW_PARTS.cloneReward()),
    TRADE_OLD_PARTS("Old Parts",
            "Trade 2 Old Parts.",
            2,
            RewardList.TRADE_OLD_PARTS.cloneReward()),
    TRADE_BIO_SEDIMENTS("Bio Sediments", 
            "Trade 3 Bio Sediments ", 
            3, 
            RewardList.TRADE_BIO_SEDIMENTS.cloneReward()),
    TRADE_PEARL("Pearls", 
            "Trade 2 Pearls ", 
            2, 
            RewardList.TRADE_PEARL.cloneReward());
    
    /**
     * Constants.
     */
    private final String name;
    private final String description;
    private final int quantity;
    private final Inventory rewards;
    
    /**
     * Constructor.
     * @param name
     * @param description
     * @param quantity
     * @param rewards 
     */
    FetchJobList(String name, String description, int quantity, Inventory rewards) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.rewards = rewards;
    }
    
    /**
     * Gets the job's name.
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the job's description.
     * @return 
     */
    public String getDesc() {
        return this.description;
    }
    
    /**
     * Gets the job's quantity.
     * @return 
     */
    public int getQuantity() {
        return this.quantity;
    }
    
    /**
     * Gets the job's rewards.
     * @return 
     */
    public Inventory getRewards() {
        return this.rewards;
    }
}
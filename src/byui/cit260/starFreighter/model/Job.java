package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.FetchJobList;
import java.io.Serializable;
import java.util.Objects;

/**
 * A basic data model for different types of jobs.
 */
public class Job implements Serializable {
    /**
     * Class members.
     */
    protected String name;
    protected String description;
    protected Inventory rewards;
    protected boolean complete = false;
    
    /**
     * Class constructor.
     * @param job
     */
    public Job(FetchJobList job) {
        this.name = job.getName();
        this.description = job.getDesc();
        this.rewards = job.getRewards();
    }
    
    /**
     * Gets the job's name.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the job's name.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the job's description.
     * @return 
     */
    public String getDesc() {
        return description;
    }
    
    /**
     * Sets the job's description.
     * @param description 
     */
    public void setDesc(String description) {
        this.description = description;
    }
    
    /**
     * Gets the job's rewards.
     * @return 
     */
    public Inventory getRewards() {
        return rewards;
    }
    
    /**
     * Sets the job's rewards.
     * @param rewards 
     */
    public void setRewards(Inventory rewards) {
        this.rewards = rewards;
    }

    /**
     * Checks to see whether the job is complete.
     * @return 
     */
    public boolean isComplete() {
        return complete;
    }
    
    /**
     * Sets whether the job is complete.
     * @param complete 
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.rewards);
        hash = 29 * hash + (this.complete ? 1 : 0);
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
        final Job other = (Job) obj;
        if (this.complete != other.complete) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.rewards, other.rewards);
    }

    @Override
    public String toString() {
        return "Job{" + "name=" + name + ", description=" + description + ", rewards=" + rewards + ", complete=" + complete + '}';
    }
}
package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.FetchJobList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A container object for a list of jobs. The game instance has a list of all of
 * the player's jobs; available jobs are stored in job lists at locations in the
 * game itself.
 */
public class JobRegistry implements Serializable {
    // Class constants.
    private final ArrayList<Job> jobs = new ArrayList<>();

    /**
     * Class constructor.
     */
    public JobRegistry() {
        
    }
    
    /**
     * Adds a job to the job list.
     * @param job 
     */
    public void add(Job job) {
        jobs.add(job);
    }
    
    /**
     * Adds a fetch job to the job list.
     * @param job 
     */
    public void add(FetchJob job) {
        jobs.add(job);
    }
    
    /**
     * Removes a job from the list.
     * @param job 
     */
    public void remove(Job job) {
        jobs.remove(job);
    }
    
    /**
     * Clears the job list entirely.
     */
    public void empty() {
        jobs.clear();
    }
    
    /**
     * Gets the job list.
     * @return 
     */
    public ArrayList<Job> get() {
        return jobs;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.jobs);
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
        final JobRegistry other = (JobRegistry) obj;
        return Objects.equals(this.jobs, other.jobs);
    }

    @Override
    public String toString() {
        return "JobList{" + "jobs=" + jobs + '}';
    }
}
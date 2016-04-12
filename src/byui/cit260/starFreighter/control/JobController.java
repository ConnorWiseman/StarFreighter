package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.constants.FetchJobList;
import byui.cit260.starFreighter.model.FetchJob;
import byui.cit260.starFreighter.model.Job;
import byui.cit260.starFreighter.model.JobRegistry;
import byui.cit260.starFreighter.model.Planet;
import starfreighter.StarFreighter;

/**
 * A job controller.
 */
public class JobController {
    
    /**
     * Private constructor prevents instantiation.
     */
    private JobController() {
        
    }
    
    /**
     * Creates a new job list.
     * @return 
     */
    public static JobRegistry createJobRegistry() {
        return new JobRegistry();
    }
    
    /**
     * Adds a job to a specific planet's job registry.
     * @param job
     * @param planet 
     */
    public static void addJobToPlanet(Job job, Planet planet) {
        planet.getJobRegistry().add(job);
    }
    
    /**
     * Creates a new fetch job.
     * @param job
     * @return 
     */
    public static FetchJob createFetchJob(FetchJobList job) {
        return new FetchJob(job);
    }
    
    /**
     * Gets the player's job list.
     * @return 
     */
    public static JobRegistry getJobList() {
        return StarFreighter.getCurrentGame().getJobRegistry();
    }
    
    /**
     * Accepts a specified job.
     * @param job 
     */
    public static void acceptJob(Job job) {
        JobRegistry playerJobList = getJobList();
        JobRegistry planetJobList = getAvailableJobs();
        
        planetJobList.remove(job);
        playerJobList.add(job);
    }
    
    /**
     * Progresses the player through each of their jobs. Called after acquiring
     * items to increment the number of items obtained for "fetch" jobs.
     * 
     * Might possibly see use in pirate huntin' jobs too, but dunno if there'll
     * be time.
     */
    public static void progressAllJobs() {
        // get player's job list
        // iterate through each job
        // call the job's "progress" method
    }
    
    /**
     * Gets the job list at the player's current location.
     * @return 
     */
    public static JobRegistry getAvailableJobs() {
        Planet current = StarFreighter.getCurrentGame().getShip().getLocation();
        return current.getJobRegistry();
    }
}
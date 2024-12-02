package pprog.controller;

import pprog.repository.JobRepository;
import pprog.repository.Repositories;

/**
 * Controller class responsible for registering jobs.
 */
public class RegisterJobController {

    /**
     * The repository where the job data is stored.
     */
    private JobRepository jobRepository;

    /**
     * Default constructor. Retrieves the job repository instance.
     */
    public RegisterJobController() {
        getJobRepository();
    }

    /**
     * Constructor to set a specific job repository.
     * @param jobRepository The job repository to be set.
     */
    public RegisterJobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * Retrieves the job repository instance if not already set.
     * @return The job repository instance.
     */
    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();
            jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    /**
     * Registers a new job.
     * @param name The name of the job.
     * @param description The description of the job.
     * @return True if the job was successfully registered, false otherwise.
     */
    public boolean registerJob(String name, String description) {
        try {
            getJobRepository().registerJob(name, description);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

}

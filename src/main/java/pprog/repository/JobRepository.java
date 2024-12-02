package pprog.repository;

import pprog.domain.Job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to manage jobs.
 */
public class JobRepository implements Serializable {

    /** The list of jobs stored in this repository. */
    private final List<Job> jobsList;

    /**
     * Constructs a JobRepository with an empty list of jobs.
     */
    public JobRepository() {
        jobsList = new ArrayList<>();
    }

    /**
     * Registers a new job in the repository.
     *
     * @param name                   The name of the job.
     * @param description            The description of the job.
     * @return                       The newly registered job, or null if registration fails.
     */
    public Job registerJob(String name, String description) {
        Job newJob = null;
        Job job = new Job(name, description);

        if (addJob(job)){
            newJob = job;
        }
        return newJob;
    }

    /**
     * Adds a job to the repository.
     *
     * @param job The job to be added.
     * @return True if the job is successfully added, false otherwise.
     * @throws IllegalArgumentException if the job already exists in the repository.
     */
    private boolean addJob(Job job){
        if (validateJob(job)) {
            jobsList.add(job.clone());
            return true;
        } else {
            throw new IllegalArgumentException("Job already exists in the repository.");
        }
    }

    /**
     * Validates a job before adding it to the repository.
     *
     * @param job       The job to be validated.
     * @return          True if the job is valid (not already in the repository), false otherwise.
     */
    private boolean validateJob (Job job) {
        return !jobsList.contains(job);
    }

    /**
     * Retrieves a job by its name.
     *
     * @param jobName The name of the job to retrieve.
     * @return The Job object with the specified name, or null if not found.
     * @throws IllegalArgumentException if the job with the specified name is not found.
     */
    public Job getJobByName(String jobName) {
        for (Job job : jobsList) {
            if (job.getName().equals(jobName)) {
                return job;
            }
        }
        throw new IllegalArgumentException("Job with name '" + jobName + "' not found.");
    }

    /**
     * Gets the list of all jobs stored in this repository.
     * @return The list of jobs.
     */
    public List<Job> getJobsList() {
        return jobsList;
    }

    /**
     * Returns a string representation of this JobRepository.
     * @return A string representation containing all jobs.
     */
    @Override
    public String toString() {
        return "Jobs= " + jobsList;
    }

}

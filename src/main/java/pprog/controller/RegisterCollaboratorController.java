package pprog.controller;

import pprog.domain.Job;
import pprog.repository.CollaboratorRepository;
import pprog.repository.JobRepository;
import pprog.repository.Repositories;

import java.util.Date;
import java.util.List;

/**
 * Controller class responsible for registering collaborators.
 */
public class RegisterCollaboratorController {

    /**
     * The repository where the collaborator data is stored.
     */
    private CollaboratorRepository collaboratorRepository;

    /**
     * The repository where the job data is stored.
     */
    private JobRepository jobRepository;

    /**
     * Constructor. Retrieves the collaborator and job repository instances.
     */
    public RegisterCollaboratorController() {
        getCollaboratorRepository();
        getJobRepository();
    }

    /**
     * Constructor that receives instances of CollaboratorRepository and JobRepository.
     *
     * @param collaboratorRepository the collaborator repository
     * @param jobRepository          the job repository
     */
    public RegisterCollaboratorController(CollaboratorRepository collaboratorRepository, JobRepository jobRepository) {
        this.collaboratorRepository = collaboratorRepository;
        this.jobRepository = jobRepository;
    }

    /**
     * Gets the Collaborator repository.
     * If not initialized, retrieves it from Repositories.
     * @return Collaborator repository instance
     */
    private CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    /**
     * Gets the Job repository.
     * If not initialized, retrieves it from Repositories.
     * @return Job repository instance
     */
    private JobRepository getJobRepository() {
        if (jobRepository == null) {
            Repositories repositories = Repositories.getInstance();
            jobRepository = repositories.getJobRepository();
        }
        return jobRepository;
    }

    /**
     * Registers a new collaborator.
     *
     * @param name          the name of the collaborator
     * @param birthday      the birthday of the collaborator
     * @param admissionDate the admission date of the collaborator
     * @param address       the address of the collaborator
     * @param phoneNumber   the phone number of the collaborator
     * @param email         the email of the collaborator
     * @param idDocType     the ID document type of the collaborator
     * @param idNumber      the ID number of the collaborator
     * @param jobName       the job name of the collaborator
     * @return True if the collaborator was successfully registered, false otherwise
     */
    public boolean registerCollaborator(String name, Date birthday, Date admissionDate, String[] address, int phoneNumber, String email, int idDocType, int idNumber, String jobName) {
        try {
            getCollaboratorRepository().registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, getJobByName(jobName));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

    /**
     * Gets a job by name.
     *
     * @param jobName the job name
     * @return The job object corresponding to the given name
     */
    private Job getJobByName(String jobName) {
        return getJobRepository().getJobByName(jobName);
    }

    /**
     * Gets the list of all available jobs.
     * @return The list of all available jobs
     */
    public List<Job> getJobsList() {
        return getJobRepository().getJobsList();
    }

}

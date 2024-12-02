package pprog.repository;

import pprog.domain.*;
import pprog.domain.Collaborator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repository class to manage collaborators.
 */
public class CollaboratorRepository implements Serializable {

    /**
     * The list of collaborators managed by the repository.
     */
    private final List<Collaborator> collaboratorsList;

    /**
     * Constructs a new CollaboratorRepository object.
     */
    public CollaboratorRepository() {
        collaboratorsList = new ArrayList<>();
    }

    /**
     * Registers a new collaborator.
     *
     * @param name          The name of the collaborator.
     * @param birthday      The birthday of the collaborator.
     * @param admissionDate The admission date of the collaborator.
     * @param address       The address of the collaborator.
     * @param phoneNumber   The phone number of the collaborator.
     * @param email         The email of the collaborator.
     * @param idDocType     The identification document type of the collaborator.
     * @param idNumber      The identification number of the collaborator.
     * @param job           The job of the collaborator.
     * @return The newly registered collaborator, or null if registration fails.
     */
    public Collaborator registerCollaborator(String name, Date birthday, Date admissionDate, String[] address, int phoneNumber, String email, int idDocType, int idNumber, Job job) {
        Collaborator newCollaborator = null;
        Collaborator collaborator = new Collaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);

        if (addCollaborator(collaborator)) {
            newCollaborator = collaborator;
        }
        return newCollaborator;
    }

    /**
     * Retrieves a collaborator by name.
     *
     * @param collaboratorName The name of the collaborator to retrieve.
     * @return The collaborator with the specified name, or null if not found.
     * @throws IllegalArgumentException if no collaborator with the specified name is found.
     */
    public Collaborator getCollaboratorByName(String collaboratorName) {
        for (Collaborator collaborator : collaboratorsList) {
            if (collaborator.getName().equals(collaboratorName)) {
                return collaborator;
            }
        }
        throw new IllegalArgumentException("Collaborator with name '" + collaboratorName + "' not found.");
    }

    /**
     * Adds a collaborator to the repository.
     *
     * @param collaborator The collaborator to add.
     * @return true if the collaborator was added successfully, false otherwise.
     * @throws IllegalArgumentException if the collaborator is under 18 years old or already exists in the repository.
     */
    private boolean addCollaborator(Collaborator collaborator) {
        if (!collaborator.validateBirthdayIsOver18()) {
            throw new IllegalArgumentException("Collaborator must be at least 18 years old.");
        } else if (validateCollaborator(collaborator)) {
            collaboratorsList.add(collaborator);
            return true;
        } else {
            throw new IllegalArgumentException("Collaborator already exists in the repository.");
        }
    }

    /**
     * Validates whether a collaborator is unique.
     *
     * @param collaborator The collaborator to validate.
     * @return true if the collaborator is unique, false otherwise.
     */
    private boolean validateCollaborator(Collaborator collaborator) {
        return !collaboratorsList.contains(collaborator);
    }

    /**
     * Gets the list of all collaborators.
     *
     * @return The list of collaborators.
     */
    public List<Collaborator> getCollaboratorsList() {
        return collaboratorsList;
    }

    /**
     * Returns a string representation of the CollaboratorRepository.
     *
     * @return A string representation of the CollaboratorRepository.
     */
    @Override
    public String toString() {
        return "Collaborators=" + collaboratorsList + '}';
    }

}

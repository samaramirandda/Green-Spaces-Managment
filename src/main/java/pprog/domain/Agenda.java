package pprog.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an agenda containing entries.
 */
public class Agenda implements Serializable {

    /**
     * The list of entries.
     */
    private final List<Entry> entriesList;

    /**
     * Constructs a new Agenda object.
     */
    public Agenda() {
        entriesList = new ArrayList<>();
    }


    /**
     * Adds a new entry to the agenda.
     *
     * @param startingDate    The starting date of the entry.
     * @param task            The task associated with the entry.
     * @param gsmFromSession  The Green Spaces Manager associated with the session.
     * @return                The newly added entry.
     */
    public Entry addEntryAgenda(Date startingDate, Task task, String gsmFromSession) {
        Entry newEntry = null;
        Entry entry = new Entry(startingDate, task);

        if (addEntry(gsmFromSession, entry)) {
            newEntry = entry;
        }
        return newEntry;
    }


    /**
     * Retrieves an entry from the agenda by index.
     *
     * @param index  The index of the entry to retrieve.
     * @return       The entry at the specified index.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public Entry getEntryByIndex(int index) {
        if (index < 1 || index > entriesList.size()) {
            throw new IllegalArgumentException("Entry not found in Agenda.");
        }
        return entriesList.get(index - 1);
    }


    /**
     * Adds an entry to the agenda if it passes validation checks.
     *
     * @param gsmFromSession  The Green Spaces Manager associated with the session.
     * @param entry           The entry to be added.
     * @return                True if the entry is successfully added, false otherwise.
     * @throws IllegalArgumentException if the entry already exists in the agenda.
     */
    private boolean addEntry(String gsmFromSession, Entry entry) {
        if (validateEntry(entry) && validateUser(gsmFromSession, entry)) {
            entry.getTask().changeStatus(TaskStatus.PROCESSED);
            entriesList.add(entry);
            return true;
        } else {
            throw new IllegalArgumentException("Entry already exists in the Agenda.");
        }
    }

    /**
     * Postpones the starting date of an entry and changes its status to postponed.
     *
     * @param entry           The entry to be postponed.
     * @param newStartingDate The new starting date for the entry.
     */
    public void postponeEntry(Entry entry, Date newStartingDate, String gsmFromSession) {
        if (validateUser(gsmFromSession, entry)) {
            if (entry.getStartingDate().after(newStartingDate)) {
                throw new IllegalArgumentException("The new date must be later than the date initially assigned to the task.");
            } else {
                entry.setStartingDate(newStartingDate);
                entry.changeStatus(AgendaStatus.POSTPONED);
            }
        }
    }

    /**
     * Cancels an entry and changes its status to canceled.
     *
     * @param entry  The entry to be canceled.
     */
    public void cancelEntry(Entry entry, String gsmFromSession) {
        if (!entriesList.contains(entry)) {
            throw new IllegalArgumentException("Entry does not exist in the Agenda.");
        }
        else if (validateUser(gsmFromSession, entry)) {
            entry.changeStatus(AgendaStatus.CANCELED);
        }
    }

    /**
     * Completes an entry and changes its status to done.
     *
     * @param entry  The entry to be completed.
     */
    public void completeEntry(Entry entry, String collaboratorFromSession) {
        if (!entriesList.contains(entry)) {
            throw new IllegalArgumentException("Entry does not exist in the Agenda.");
        }
        if (verifyCollaborator(entry, collaboratorFromSession)) {
            entry.changeStatus(AgendaStatus.DONE);
            List<Vehicle> vehicles = entry.getVehiclesAssign();
            for (Vehicle vehicle : vehicles) {
                vehicle.setOccupiedVehicle(false);
            }
        }
    }

    /**
     * Validates if an entry already exists in the agenda.
     *
     * @param entry  The entry to validate.
     * @return       True if the entry is not in the agenda, false otherwise.
     */
    private boolean validateEntry(Entry entry) {
        return !entriesList.contains(entry);
    }

    /**
     * Validates if the Green Spaces Manager associated with the session manages the green space associated with the entry.
     *
     * @param gsmFromSession  The Green Spaces Manager associated with the session.
     * @param entry           The entry to validate.
     * @return                True if the user is authorized to add the entry, false otherwise.
     * @throws IllegalArgumentException if the logged-in Green Space Manager does not manage the green space associated with the entry.
     */
    private boolean validateUser(String gsmFromSession, Entry entry) {
        if (entry.getGreenSpacesManager().getEmail().equals(gsmFromSession)) {
            return true;
        } else {
            throw new IllegalArgumentException("The logged in Green Space Manager does not manage the green space associated with this entrance.");
        }
    }

    /**
     * Retrieves a list of tasks for a collaborator between specified dates and with a specific task status.
     *
     * @param collaboratorEmail  The collaborator for whom to retrieve tasks.
     * @param startDate     The start date for the task retrieval period.
     * @param endDate       The end date for the task retrieval period.
     * @return              A list of tasks matching the specified criteria.
     */
    public List<Entry> getTasksForCollaboratorBetweenDates(String collaboratorEmail, Date startDate, Date endDate) {
        List<Entry> tasks = new ArrayList<>();

        for (Entry entry : entriesList) {
            if (entry.getStartingDate().after(startDate) && entry.getStartingDate().before(endDate)) {
                if (entry.getTeamAssign() != null) {
                    for (Collaborator c : entry.getTeamAssign().getTeam()) {
                        if (c.getEmail().equalsIgnoreCase(collaboratorEmail)){
                            tasks.add(entry);
                            break;
                        }
                    }
                }
            }
        }
        return tasks;
    }

    /**
     * Verifies if the collaborator from the session is part of the team assigned to the given entry.
     *
     * @param entry The entry which contains the team assignment.
     * @param collaboratorFromSession The email of the collaborator from the session.
     * @return true if the collaborator is part of the team assigned to the entry.
     * @throws IllegalArgumentException if the collaborator is not part of the team assigned to the entry.
     */
    public boolean verifyCollaborator(Entry entry, String collaboratorFromSession) {
        if (entry.getTeamAssign() != null) {
            for (Collaborator c : entry.getTeamAssign().getTeam()) {
                if (collaboratorFromSession.equalsIgnoreCase(c.getEmail())) {
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("You don't have permission to complete an entry.");
    }




    /**
     * Retrieves the list of entries in the agenda.
     *
     * @return The list of entries.
     */
    public List<Entry> getEntriesList() {
        return entriesList;
    }

    /**
     * Returns a string representation of the list of entries.
     *
     * @return A string representation of the list of entries.
     */
    @Override
    public String toString() {
        return entriesList.toString();
    }


}

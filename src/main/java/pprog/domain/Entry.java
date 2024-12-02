package pprog.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an entry in the agenda.
 */
public class Entry implements Serializable {

    /**
     * The starting date of the agenda entry.
     */
    private Date startingDate;

    /**
     * The status of the agenda entry.
     */
    private AgendaStatus status;

    /**
     * The task associated with the agenda entry.
     */
    private Task task;

    /**
     * The team assigned to the agenda entry.
     */
    private Team teamAssign;

    /**
     * The Green Spaces Manager associated with the agenda entry.
     */
    private GreenSpacesManager greenSpacesManager;

    /**
     * The list of vehicles assigned to the agenda entry.
     */
    private List<Vehicle> vehiclesAssign;


    /**
     * Constructs an Entry with the specified starting date and task.
     *
     * @param startingDate the starting date of the entry
     * @param task         the task associated with the entry
     */
    public Entry(Date startingDate, Task task) {
        this.startingDate = startingDate;
        this.status = AgendaStatus.PLANNED;
        this.task = task;
        this.greenSpacesManager = task.getGreenSpacesManager();
        this.teamAssign = null;
        this.vehiclesAssign = new ArrayList<>();
    }

    /**
     * Checks if this Entry is equal to another object.
     *
     * @param anotherObject the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || getClass() != anotherObject.getClass()) {
            return false;
        }
        Entry anotherEntry = (Entry) anotherObject;
        return task.equals(anotherEntry.task);
    }

    /**
     * Gets the starting date of the entry.
     *
     * @return the starting date
     */
    public Date getStartingDate() {
        return startingDate;
    }

    /**
     * Sets the starting date of the entry.
     *
     * @param startingDate the starting date to set
     */
    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    /**
     * Gets the status of the entry.
     *
     * @return the status
     */
    public AgendaStatus getStatus() {
        return status;
    }

    /**
     * Changes the status of the entry.
     *
     * @param status the new status
     */
    public void changeStatus(AgendaStatus status) {
        this.status = status;
    }

    /**
     * Gets the task associated with the entry.
     *
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the task associated with the entry.
     *
     * @param task the task to set
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * Gets the green spaces manager associated with the entry.
     *
     * @return the green spaces manager
     */
    public GreenSpacesManager getGreenSpacesManager() {
        return greenSpacesManager;
    }

    /**
     * Sets the green spaces manager associated with the entry.
     *
     * @param greenSpacesManager the green spaces manager to set
     */
    public void setGreenSpacesManager(GreenSpacesManager greenSpacesManager) {
        this.greenSpacesManager = greenSpacesManager;
    }

    /**
     * Gets the team assigned to the entry.
     *
     * @return the assigned team
     */
    public Team getTeamAssign() {
        return teamAssign;
    }

    /**
     * Assigns a team to the entry.
     *
     * @param teamAssign the team to assign
     */
    public void assignTeam(Team teamAssign) {
        this.teamAssign = teamAssign;
    }

    /**
     * Gets the list of vehicles assigned to the entry.
     *
     * @return the list of assigned vehicles
     */
    public List<Vehicle> getVehiclesAssign() {
        return vehiclesAssign;
    }

    /**
     * Assigns vehicles to the entry.
     *
     * @param vehiclesToAdd the vehicles to assign
     * @throws IllegalArgumentException if a vehicle is already assigned or is busy
     */
    public void assignVehicles(List<Vehicle> vehiclesToAdd) throws IllegalArgumentException {
        boolean allVehiclesAvailable = true;
        for (Vehicle vehicle : vehiclesToAdd) {
            if (this.vehiclesAssign.contains(vehicle)) {
                throw new IllegalArgumentException("The vehicle you are trying to assign was already assigned!");
            }
            if (vehicle.isOccupiedVehicle()) {
                allVehiclesAvailable = false;
                break;
            }
        }

        if (allVehiclesAvailable) {
            for (Vehicle vehicle : vehiclesToAdd) {
                this.vehiclesAssign.add(vehicle);
                vehicle.setOccupiedVehicle(true);
            }
        } else {
            throw new IllegalArgumentException("Vehicle you are trying to assign is busy!");
        }
    }

    /**
     * Returns a string representation of the entry.
     *
     * @return a string representing the entry
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Starting Date: %s\n%sStatus: %s", startingDate, task, status));

        if (teamAssign != null) {
            sb.append(String.format("\nTeam Assigned: %s", teamAssign));
        }

        if (vehiclesAssign != null && !vehiclesAssign.isEmpty()) {
            sb.append("\nVehicles Assigned:");
            for (Vehicle vehicle : vehiclesAssign) {
                sb.append(String.format("\n%s", vehicle));
            }
        }

        return sb.toString();
    }
}

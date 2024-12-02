package pprog.domain;

import java.io.Serializable;

/**
 * Represents a task related to a green space.
 */
public class Task implements Serializable {

    /**
     * The title of the task.
     */
    private String title;

    /**
     * The description of the task.
     */
    private String description;

    /**
     * The degree of urgency of the task.
     */
    private EmergencyDegree degreeOfUrgency;

    /**
     * The expected duration of the task in minutes.
     */
    private int expectedDuration;

    /**
     * The type of the task.
     */
    private TaskType type;

    /**
     * The green space associated with the task.
     */
    private GreenSpace greenSpace;

    /**
     * The status of the task.
     */
    private TaskStatus status;

    /**
     * The green spaces manager associated with the task.
     */
    private GreenSpacesManager greenSpacesManager;


    /**
     * Constructs a Task object with the specified parameters.
     *
     * @param title           The title of the task.
     * @param description     The description of the task.
     * @param degreeOfUrgency The degree of urgency of the task.
     * @param expectedDuration The expected duration of the task.
     * @param type            The type of the task.
     * @param greenSpace      The green space associated with the task.
     */
    public Task (String title, String description, int degreeOfUrgency, int expectedDuration, int type, GreenSpace greenSpace) {
        this.title = title;
        this.description = description;
        this.degreeOfUrgency = EmergencyDegree.fromInt(degreeOfUrgency);
        this.expectedDuration = expectedDuration;
        this.type = TaskType.fromInt(type);
        this.greenSpace = greenSpace;
        this.status = TaskStatus.PENDING;
        this.greenSpacesManager = greenSpace.getGreenSpacesManager();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param otherObject The reference object with which to compare.
     * @return True if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        Task outraTask = (Task) otherObject;
        return title.equalsIgnoreCase(outraTask.title) && greenSpace.equals(outraTask.greenSpace);
    }

    /**
     * Retrieves the title of the task.
     *
     * @return The title of the task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the task.
     *
     * @param title The title to be set for the task.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The description to be set for the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the degree of urgency of the task.
     *
     * @return The degree of urgency of the task.
     */
    public EmergencyDegree getDegreeOfUrgency() {
        return degreeOfUrgency;
    }

    /**
     * Sets the degree of urgency of the task.
     *
     * @param degreeOfUrgency The degree of urgency to be set for the task.
     */
    public void setDegreeOfUrgency(EmergencyDegree degreeOfUrgency) {
        this.degreeOfUrgency = degreeOfUrgency;
    }

    /**
     * Retrieves the expected duration of the task.
     *
     * @return The expected duration of the task.
     */
    public int getExpectedDuration() {
        return expectedDuration;
    }

    /**
     * Sets the expected duration of the task.
     *
     * @param expectedDuration The expected duration to be set for the task.
     */
    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    /**
     * Retrieves the type of the task.
     *
     * @return The type of the task.
     */
    public TaskType getType() {
        return type;
    }

    /**
     * Sets the type of the task.
     *
     * @param type The type to be set for the task.
     */
    public void setType(TaskType type) {
        this.type = type;
    }

    /**
     * Retrieves the green space associated with the task.
     *
     * @return The green space associated with the task.
     */
    public GreenSpace getGreenSpace() {
        return greenSpace;
    }

    /**
     * Sets the green space associated with the task.
     *
     * @param greenSpace The green space to be associated with the task.
     */
    public void setGreenSpace(GreenSpace greenSpace) {
        this.greenSpace = greenSpace;
    }

    /**
     * Retrieves the status of the task.
     *
     * @return The status of the task.
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Changes the status of the task.
     *
     * @param status The new status to be set for the task.
     */
    public void changeStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Retrieves the green spaces manager associated with the task.
     *
     * @return The green spaces manager associated with the task.
     */
    public GreenSpacesManager getGreenSpacesManager() {
        return greenSpacesManager;
    }

    /**
     * Sets the green spaces manager associated with the task.
     *
     * @param greenSpacesManager The green spaces manager to be associated with the task.
     */
    public void setGreenSpacesManager(GreenSpacesManager greenSpacesManager) {
        this.greenSpacesManager = greenSpacesManager;
    }


    /**
     * Returns a string representation of the task.
     *
     * @return A string representation containing details of the task.
     */
    @Override
    public String toString() {
        return String.format("Title: %s\nDescription: %s\nDegree of Urgency: %s\nExpected Duration: %d\nType: %s\nGreen Space: %s\nManaged by: %s\n", title, description, degreeOfUrgency, expectedDuration, type, greenSpace.getName(), greenSpacesManager);
    }
}

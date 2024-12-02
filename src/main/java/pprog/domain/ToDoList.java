package pprog.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a to-do list containing tasks.
 */
public class ToDoList implements Serializable {

    /**
     * The list of tasks.
     */
    private final List<Task> tasksList;

    /**
     * Constructs a new ToDoList object.
     */
    public ToDoList() {
        tasksList = new ArrayList<>();
    }

    /**
     * Adds a task to the to-do list.
     *
     * @param title              the title of the task
     * @param description        the description of the task
     * @param degreeOfUrgency    the degree of urgency of the task
     * @param expectedDurantionTime the expected duration time of the task
     * @param taskType           the type of the task
     * @param greenSpace         the green space associated with the task
     * @param gsmFromSession     the email of the logged-in Green Spaces Manager
     * @return the newly added task
     */
    public Task addTaskToDoList(String title, String description, int degreeOfUrgency, int expectedDurantionTime, int taskType, GreenSpace greenSpace, String gsmFromSession) {
        Task newTask = null;
        Task task = new Task(title, description, degreeOfUrgency, expectedDurantionTime, taskType, greenSpace);

        if (addTask(gsmFromSession, task)) {
            newTask = task;
        }

        return newTask;
    }

    /**
     * Retrieves a task from the to-do list by index.
     *
     * @param index the index of the task
     * @return the task at the specified index
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public Task getTaskByIndex(int index) {
        if (index < 1 || index > tasksList.size()) {
            throw new IllegalArgumentException("Task not found in To-Do List.");
        }
        return tasksList.get(index - 1);
    }

    private boolean addTask(String gsmFromSession, Task task) {
        if (validateTask(task) && validateUser(gsmFromSession, task)) {
            return tasksList.add(task);
        } else {
            throw new IllegalArgumentException("Task already exists in the To-Do List.");
        }
    }

    private boolean validateTask(Task task) {
        return !tasksList.contains(task);
    }

    /**
     * Validates if the logged-in user manages the green space associated with the task.
     *
     * @param gsmFromSession the email of the logged-in Green Spaces Manager
     * @param task           the task to validate
     * @return true if the user is valid, false otherwise
     * @throws IllegalArgumentException if the logged-in user does not manage the associated green space
     */
    public boolean validateUser(String gsmFromSession, Task task) {
        if (task.getGreenSpacesManager().getEmail().equals(gsmFromSession)) {
            return true;
        } else {
            throw new IllegalArgumentException("The logged-in Green Space Manager does not manage the green space associated with this task.");
        }
    }

    /**
     * Retrieves the list of tasks in the to-do list.
     *
     * @return the list of tasks
     */
    public List<Task> getTasksList() {
        return tasksList;
    }

    /**
     * Returns a string representation of the to-do list.
     *
     * @return a string representation of the to-do list
     */
    @Override
    public String toString() {
        return tasksList.toString();
    }
}

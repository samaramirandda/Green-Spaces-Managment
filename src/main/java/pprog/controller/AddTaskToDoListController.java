package pprog.controller;

import pprog.domain.GreenSpace;
import pprog.domain.Task;
import pprog.repository.AuthenticationRepository;
import pprog.repository.GreenSpaceRepository;
import pprog.repository.Repositories;
import pprog.domain.ToDoList;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * Controller class for adding tasks to the to-do list.
 */
public class AddTaskToDoListController {

    /**
     * The to-do list instance.
     */
    private ToDoList toDoList;

    /**
     * The green space repository instance.
     */
    private GreenSpaceRepository greenSpacesRepository;

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a new AddTaskToDoListController and initializes the to-do list, green space repository, and authentication repository.
     */
    public AddTaskToDoListController() {
        getToDoList();
        getGreenSpacesRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs a new AddTaskToDoListController with the specified to-do list, green space repository, and authentication repository.
     *
     * @param toDoList                The to-do list instance.
     * @param greenSpacesRepository   The green space repository instance.
     * @param authenticationRepository The authentication repository instance.
     */
    public AddTaskToDoListController(ToDoList toDoList, GreenSpaceRepository greenSpacesRepository, AuthenticationRepository authenticationRepository) {
        this.toDoList = toDoList;
        this.greenSpacesRepository = greenSpacesRepository;
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the to-do list instance.
     *
     * @return The to-do list instance.
     */
    private ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    /**
     * Retrieves the green space repository instance.
     *
     * @return The green space repository instance.
     */
    private GreenSpaceRepository getGreenSpacesRepository() {
        if (greenSpacesRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpacesRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpacesRepository;
    }

    /**
     * Retrieves the authentication repository instance.
     *
     * @return The authentication repository instance.
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Adds a task to the to-do list.
     *
     * @param title              The title of the task.
     * @param descritpion        The description of the task.
     * @param degreeOfUrgency    The degree of urgency of the task.
     * @param expectedDurantionTime   The expected duration time of the task.
     * @param taskType           The type of the task.
     * @param greenSpace         The name of the green space associated with the task.
     * @return A message indicating the result of adding the task to the to-do list.
     */
    public String addTaskToDoList(String title, String descritpion, int degreeOfUrgency, int expectedDurantionTime, int taskType, String greenSpace) {
        try {
            getToDoList().addTaskToDoList(title, descritpion, degreeOfUrgency, expectedDurantionTime, taskType, getGreenSpaceByName(greenSpace), getGSMFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Retrieves the green space by its name.
     *
     * @param name The name of the green space.
     * @return The green space instance.
     */
    private GreenSpace getGreenSpaceByName(String name) {
        return getGreenSpacesRepository().getGreenSpaceByName(name);
    }

    /**
     * Retrieves the email of the Green Spaces Manager (GSM) from the current session.
     *
     * @return The email of the GSM.
     */
    private String getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    /**
     * Retrieves the list of green spaces.
     *
     * @return The list of green spaces.
     */
    public List<GreenSpace> getGreenSpacesList() {
        return getGreenSpacesRepository().getGreenSpacesList();
    }

    /**
     * Retrieves the most recently added task from the to-do list.
     *
     * @return The most recently added task.
     */
    public Task getTaskAdded() {
        List<Task> tasksList = getToDoList().getTasksList();
        return tasksList.get(tasksList.size() - 1);
    }

}

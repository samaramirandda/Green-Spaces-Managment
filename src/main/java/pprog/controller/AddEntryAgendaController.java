package pprog.controller;

import pprog.domain.Agenda;
import pprog.domain.Entry;
import pprog.domain.Task;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pprog.domain.ToDoList;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Date;
import java.util.List;

/**
 * Controller class for managing entries in the agenda.
 */
public class AddEntryAgendaController {

    /**
     * The agenda instance.
     */
    private Agenda agenda;

    /**
     * The to-do list instance.
     */
    private ToDoList toDoList;

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a new AddEntryAgendaController and initializes agenda, to-do list, and authentication repository.
     */
    public AddEntryAgendaController() {
        getAgenda();
        getToDoList();
        getAuthenticationRepository();
    }

    /**
     * Constructs a new AddEntryAgendaController with the specified agenda, to-do list, and authentication repository.
     *
     * @param agenda                   The agenda instance to work with.
     * @param toDoList                 The to-do list instance to work with.
     * @param authenticationRepository The authentication repository instance to work with.
     */
    public AddEntryAgendaController(Agenda agenda, ToDoList toDoList, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.toDoList = toDoList;
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the agenda instance.
     *
     * @return The agenda instance.
     */
    private Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
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
     * Adds an entry to the agenda.
     *
     * @param startingDate The starting date of the entry.
     * @param index        The index of the task to add to the agenda.
     * @return A message indicating the result of adding the entry to the agenda.
     */
    public String addEntryAgenda(Date startingDate, int index) {
        try {
            getAgenda().addEntryAgenda(startingDate, getTaskByIndex(index), getGSMFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Retrieves the task from the to-do list at the specified index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     */
    private Task getTaskByIndex(int index) {
        return getToDoList().getTaskByIndex(index);
    }

    /**
     * Retrieves the list of tasks from the to-do list.
     *
     * @return The list of tasks from the to-do list.
     */
    public List<Task> getTasksList() {
        return getToDoList().getTasksList();
    }

    /**
     * Retrieves the Green Spaces Manager (GSM) email from the current session.
     *
     * @return The email of the Green Spaces Manager from the current session.
     */
    private String getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    /**
     * Retrieves the most recently added entry from the agenda.
     *
     * @return The most recently added entry.
     */
    public Entry getEntryAdded() {
        List<Entry> entries = getAgenda().getEntriesList();
        return entries.get(entries.size() - 1);
    }

}

package pprog.controller;

import pprog.domain.Entry;
import pprog.domain.Agenda;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Date;
import java.util.List;

/**
 * Controller for postponing an entry in the agenda.
 */
public class PostponeEntryAgendaController {

    /**
     * The agenda instance.
     */
    private Agenda agenda;

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a PostponeEntryAgendaController and initializes the agenda.
     */
    public PostponeEntryAgendaController() {
        getAgenda();
        getAuthenticationRepository();
    }

    /**
     * Constructs a new PostponeEntryAgendaController with the specified agenda and authentication repository.
     *
     * @param agenda                   The agenda instance to work with.
     * @param authenticationRepository The authentication repository instance to work with.
     */
    public PostponeEntryAgendaController(Agenda agenda, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the agenda from the repositories if it is not already initialized.
     *
     * @return the agenda instance
     */
    private Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
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
     * Postpones an entry in the agenda to a new starting date.
     *
     * @param entryIndex the index of the entry to be postponed.
     * @param newStartingDate the new starting date for the entry.
     * @return null if the postponement is successful, or the error message if an IllegalArgumentException occurs.
     */
    public String postponeEntry(int entryIndex, Date newStartingDate) {
        try {
            getAgenda().postponeEntry(getEntryByIndex(entryIndex), newStartingDate, getGSMFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Retrieves an entry from the agenda by its index.
     *
     * @param index the position of the entry in the agenda.
     * @return the entry at the specified index.
     */
    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    /**
     * Retrieves the list of all entries in the agenda.
     *
     * @return a list of all entries in the agenda.
     */
    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    /**
     * Retrieves the email address of the currently authenticated user from the session.
     *
     * @return the email address of the current user session.
     */
    private String getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    /**
     * Retrieves an entry from the agenda by its index, intended for postponement purposes.
     *
     * @param index the position of the entry in the agenda.
     * @return the entry at the specified index.
     */
    public Entry getEntryPostpone(int index) {
        return getEntryByIndex(index);
    }
}
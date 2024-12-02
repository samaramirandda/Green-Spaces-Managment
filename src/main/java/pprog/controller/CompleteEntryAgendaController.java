package pprog.controller;

import pprog.domain.Agenda;
import pprog.domain.Entry;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * Controller class for completing agenda entries.
 */
public class CompleteEntryAgendaController {

    /**
     * The agenda instance.
     */
    private Agenda agenda;

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a new CompleteEntryAgendaController with the specified agenda and authentication repository.
     *
     * @param agenda                   The agenda instance to work with.
     * @param authenticationRepository The authentication repository instance to work with.
     */
    public CompleteEntryAgendaController(Agenda agenda, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Constructs a new CompleteEntryAgendaController.
     */
    public CompleteEntryAgendaController() {
        getAgenda();
        getAuthenticationRepository();
    }

    /**
     * Retrieves the agenda instance.
     *
     * @return The agenda instance.
     */
    public Agenda getAgenda() {
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
     * Marks an entry as completed.
     *
     * @param entryIndex The index of the entry to be marked as completed.
     * @return True if the entry was successfully marked as completed, false otherwise.
     */
    public String completeEntry(int entryIndex) {
        try {
            getAgenda().completeEntry(getEntryByIndex(entryIndex), getEmailCollaboratorFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Retrieves the entry at the specified index.
     *
     * @param index The index of the entry to retrieve.
     * @return The entry at the specified index.
     */
    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    /**
     * Retrieves the list of entries.
     *
     * @return The list of entries.
     */
    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    /**
     * Retrieves the email of the collaborator from the current session.
     *
     * @return The email of the collaborator from the current session.
     */
    private String getEmailCollaboratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    /**
     * Retrieves a complete entry from the collection by its index.
     *
     * @param index the position of the entry in the collection.
     * @return the complete entry at the specified index.
     */
    public Entry getEntryComplete(int index) {
        return getEntryByIndex(index);
    }
}

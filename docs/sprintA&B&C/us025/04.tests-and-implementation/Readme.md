# US025 - Cancel an entry in the Agenda 

## 4. Tests

**Test 1:** Ensure that the entry exist and the status changes to 'CANCELED' 

    @Test
        public void ensureEntryStatusChangesToCanceled() {
        Agenda agenda = new Agenda();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
        Entry entry = new Entry(new Date(), task);
        entry.setGreenSpacesManager(gsm);
        agenda.getEntriesList().add(entry);
        
        assertTrue(agenda.getEntriesList().contains(entry));

        agenda.cancelEntry(entry, gsm.getEmail());
    
        assertEquals(AgendaStatus.CANCELED, entry.getStatus());
    }


## 5. Construction (Implementation)

### Class CancelEntryAgendaController 

```java
package pprog.controller;

import pprog.domain.Entry;
import pprog.domain.Agenda;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * Controller for canceling an entry in the agenda.
 */
public class CancelEntryAgendaController {

    /**
     * The agenda instance.
     */
    private Agenda agenda;

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a CancelEntryAgendaController and initializes the agenda.
     */
    public CancelEntryAgendaController() {
        getAgenda();
        getAuthenticationRepository();
    }

    /**
     * Constructs a CancelEntryAgendaController with a given agenda.
     *
     * @param agenda the agenda to be used by this controller
     * @param authenticationRepository the authentication repository to be used by this controller
     */
    public CancelEntryAgendaController(Agenda agenda, AuthenticationRepository authenticationRepository) {
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
     * Cancels an entry in the agenda at the specified index.
     *
     * @param entryIndex the index of the entry to be canceled.
     * @return null if the cancellation is successful, or the error message if an IllegalArgumentException occurs.
     */
    public String cancelEntry(int entryIndex) {
        try {
            getAgenda().cancelEntry(getEntryByIndex(entryIndex), getGSMFromSession());
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
     * Gets the list of entries in the agenda.
     *
     * @return the list of entries
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
     * Retrieves an entry from the collection by its index.
     *
     * @param index the position of the entry in the collection.
     * @return the entry at the specified index.
     */
    public Entry getEntryCancel(int index) {
        return getEntryByIndex(index);
    }
}

```

### Class Agenda

```java
package pprog.domain;

import java.util.List;

public class Agenda {

    private List<Entry> entriesList;

    public List<Entry> getEntriesList() {
        return entriesList;
    }

    public Entry getEntryByIndex(int index) {
        if (index < 0 || index >= entriesList.size()) {
            throw new IllegalArgumentException("Entry not found in Agenda.");
        }
        return entriesList.get(index);
    }

    public void cancelEntry(Entry entry, String gsmEmail) {
        if (!entry.getGreenSpacesManager().getEmail().equals(gsmEmail)) {
            throw new IllegalArgumentException("You don't have permission to cancel this entry.");
        }
        entry.setStatus(AgendaStatus.CANCELED);
    }
}

```


## 6. Integration and Demo 


* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a
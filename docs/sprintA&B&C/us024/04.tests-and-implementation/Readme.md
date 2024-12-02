# US024 - Postpone a Date

## 4. Tests 

**Test 1:** Check that it is not possible to postpone an entry with an invalid date.

	@Test
        public void postponeEntry_InvalidDate() {
        // Arrange
        Agenda agenda = new Agenda();
        // Crie uma entrada com uma data de início válida
        Entry entry = new Entry(new Date(), new Task("Title", "Description", 1, 60, 1, new GreenSpace("Park", new String[]{"Address"}, 1, 100.0, new GreenSpacesManager("gsm@example.com"))));
        agenda.getEntriesList().add(entry);

        // Act
        Date newStartingDate = new Date(System.currentTimeMillis() - 100000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.postponeEntry(entry, newStartingDate, "gsm@example.com");
        });
    
        // Assert
        assertEquals("The new date must be later than the date initially assigned to the task.", exception.getMessage());
    }



**Test 2:** Check that it is possible to postpone an entry with a valid date.

	@Test
        public void postponeEntry_ValidDate() {
        // Arrange
        Agenda agenda = new Agenda();
        // Crie uma entrada com uma data de início válida
        Entry entry = new Entry(new Date(), new Task("Title", "Description", 1, 60, 1, new GreenSpace("Park", new String[]{"Address"}, 1, 100.0, new GreenSpacesManager("gsm@example.com"))));
        agenda.getEntriesList().add(entry);
        
        // Act
        Date newStartingDate = new Date(System.currentTimeMillis() + 100000);
        agenda.postponeEntry(entry, newStartingDate, "gsm@example.com");
    
        // Assert
        assertEquals(newStartingDate, entry.getStartingDate());
        assertEquals(AgendaStatus.POSTPONED, entry.getStatus());
    }


## 5. Construction (Implementation)

### Class PostponeEntryAgendaController

```java
public class PostponeEntryAgendaController {

    private Agenda agenda;
    private AuthenticationRepository authenticationRepository;

    public PostponeEntryAgendaController() {
        getAgenda();
        getAuthenticationRepository();
    }

    // Methods getAgenda and getAuthenticationRepository here...

    public void postponeEntry(Entry entry, Date newStartingDate, String gsmFromSession) {
        if (!validateUser(gsmFromSession, entry)) {
            throw new IllegalArgumentException("The logged in Green Space Manager does not manage the green space associated with this entry.");
        }
        if (entry.getStartingDate().after(newStartingDate)) {
            throw new IllegalArgumentException("The new date must be later than the date initially assigned to the task.");
        }
        entry.setStartingDate(newStartingDate);
        entry.changeStatus(AgendaStatus.POSTPONED);
    }

    private boolean validateUser(String gsmFromSession, Entry entry) {
        return entry.getGreenSpacesManager().getEmail().equals(gsmFromSession);
    }
}

```

### Class Agenda

```java
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

```


## 6. Integration and Demo 

* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a
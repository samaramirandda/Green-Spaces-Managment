# US028  - Consulte the Task Between Two Dates

## 4. Tests 

**Test 1:** Verify that it's possible to consult the tasks assigned to a collaborator between two dates.

	@Test
    public void getTasksForCollaboratorBetweenDates() {
    Date startDate = new Date(); 
    Date endDate = new Date(System.currentTimeMillis() + 86400000); // End date (24 hours after start date)

    List<Entry> tasks = consultTasksController.getTasksForCollaboratorBetweenDates(startDate, endDate);
    
    assertFalse(tasks.isEmpty());
    
    for (Entry task : tasks) {
        assertTrue(task.getStartingDate().after(startDate) || task.getStartingDate().equals(startDate));
        assertTrue(task.getStartingDate().before(endDate) || task.getStartingDate().equals(endDate));
    }
}

**Test 2:** Verify if the collaborator name is valid. 

    @Test
    void verifyCollaborator_InvalidCollaborator() {
    Agenda agenda = new Agenda();
    GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
    String[] address = {"123 Green St", "City", "Country"};
    GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
    Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
    Entry entry = new Entry(new Date(), task);
    String[] collabAddress = {"456 Blue St", "City", "Country"};
    Collaborator collaborator = new Collaborator("Collaborator Name", new Date(), new Date(), collabAddress, 123456789, "collaborator@example.com", 1, 12345, new Job("Emprego", "descricao"));
    List<Collaborator> collaborators = new ArrayList<>();
    collaborators.add(collaborator);
    Team team = new Team(collaborators);
    entry.assignTeam(team);

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        agenda.verifyCollaborator(entry, "different@example.com");
    });
    assertEquals("You don't have permission to complete an entry.", exception.getMessage());
    }



## 5. Construction (Implementation)

### Class ConsultTasksController 

```java
    public ConsultTasksController(Agenda agenda, AuthenticationRepository authenticationRepository) {
    this.agenda = agenda;
    this.authenticationRepository = authenticationRepository;
}

```

### Class Agenda

```java
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

```


## 6. Integration and Demo 


* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a
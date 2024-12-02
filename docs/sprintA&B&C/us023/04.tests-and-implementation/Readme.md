# US023 - Assign a Team to an entry in the Agenda

## 4. Tests 

**Test 1:** Check if the team is being assigned correctly.

    @Test
    void assignTeam() {
        Collaborator collaborator1 = new Collaborator("John Doe", new Date(), new Date(), new String[]{"123 Green St", "City", "Country"}, 123456789, "john@example.com", 1, 12345, new Job("Job Title", "a"));
        Collaborator collaborator2 = new Collaborator("Jane Doe", new Date(), new Date(), new String[]{"123 Green St", "City", "Country"}, 987654321, "jane@example.com", 1, 67890, new Job("Job Title", "a"));

        List<Collaborator> members = new ArrayList<>();
        members.add(collaborator1);
        members.add(collaborator2);
        Team team = new Team(members);

        Task task = new Task("Task", "Description", 1, 2, 1, new GreenSpace("Park", new String[]{"123 Green St", "City", "Country"}, 1, 1000.0, new GreenSpacesManager("email@this.app")));
        Entry entry = new Entry(new Date(), task);

        entry.assignTeam(team);

        assertEquals(team, entry.getTeamAssign());
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class AssignTeamController 

```java
    public String assignTeamToEntry(int agendaIndex, int teamIndex) {
    try {
        Entry entry = getEntryByIndex(agendaIndex);
        Team team = getTeamByIndex(teamIndex);
        entry.assignTeam(team);
        for (Collaborator c : team.getTeam()) {
            sendTheEmailToTeam(getEmailGSMFromSession(), c.getEmail(), c.getName(), entry.toString());
        }
        return null;
    } catch (IllegalArgumentException e) {
        return e.getMessage();
    }
}

```

### Class Entry

```java
    public void assignTeam(Team teamAssign) {
        this.teamAssign = teamAssign;
}
```


## 6. Integration and Demo 

* A new option on the Employee menu options was added.

* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a
# US022 - Add a entry in the Agenda

## 4. Tests 

**Test 1:** Check if the entry is being registered correctly, being stored in the agenda and if it is not possible to register an entry already registered - AC05/AC06.

    @Test
    void addEntryAgenda() {
        Agenda agenda = new Agenda();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
        String gsmEmail = gsm.getEmail();

        Entry entry = new Entry(new Date(), task);
        entry.setGreenSpacesManager(gsm);

        Entry newEntry = agenda.addEntryAgenda(entry.getStartingDate(), task, gsmEmail);

        assertNotNull(newEntry);
        List<Entry> entries = agenda.getEntriesList();
        assertEquals(entries.get(entries.size() - 1), newEntry);
    }
	

**Test 2:** Check whether the chosen task list option is being searched correctly - AC02.

    @Test
    void getTaskByIndex() {
        ToDoList toDoList = new ToDoList();
        GreenSpacesManager gsm = new GreenSpacesManager("test@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);

        Task task1 = toDoList.addTaskToDoList("Task 1", "Description 1", 1, 60, 1, greenSpace, "test@example.com");
        Task task2 = toDoList.addTaskToDoList("Task 2", "Description 2", 2, 30, 2, greenSpace, "test@example.com");

        Task retrievedTask1 = toDoList.getTaskByIndex(1);

        assertNotNull(retrievedTask1);
        assertEquals(task1, retrievedTask1);
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class AddEntryAgendaController 

```java
    public String addEntryAgenda(Date startingDate, int index) {
    try {
        getAgenda().addEntryAgenda(startingDate, getTaskByIndex(index), getGSMFromSession());
        return null;
    } catch (IllegalArgumentException e) {
        return e.getMessage();
    }
}
```

### Class Organization

```java
public Optional<Task> createTask(String reference, String description, String informalDescription,
                                 String technicalDescription, Integer duration, Double cost, TaskCategory taskCategory,
                                 Employee employee) {
    
    Task task = new Task(reference, description, informalDescription, technicalDescription, duration, cost,
                         taskCategory, employee);

    addTask(task);
        
    return task;
}
```


## 6. Integration and Demo 

* A new option on the Employee menu options was added.

* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a
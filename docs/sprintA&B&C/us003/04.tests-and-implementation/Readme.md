# US003 - Register collaborator with job and fundamental characteristics

## 4. Tests 

**Test 1:** Check if the collaborator is being registered correctly, being stored in the repository and if it is not possible to register an already registered collaborator - AC01/AC15.

    @Test
    void registerCollaborator() {

        CollaboratorRepository repository = new CollaboratorRepository();

        Collaborator collaborator = new Collaborator("Daniel Silva", new Date(90,5,31),
                new Date(), "123 Street", 123456789, "daniel.silva@example.com", IdDocType.PASSPORT, 123456, new Job("Software Engineer", "Developing software applications"));

        Collaborator registeredCollaborator = repository.registerCollaborator(collaborator.getName(), collaborator.getBirthday(),
                collaborator.getAdmissionDate(), collaborator.getAddress(), collaborator.getPhoneNumber(),
                collaborator.getEmail(), collaborator.getIdDocType(), collaborator.getIdNumber(), collaborator.getJob());

        assertNotNull(registeredCollaborator);
        assertEquals(collaborator, registeredCollaborator);

        List<Collaborator> collaboratorsList = repository.getCollaboratorsList();

        assertTrue(collaboratorsList.contains(registeredCollaborator));

        assertThrows(IllegalArgumentException.class, () ->
                repository.registerCollaborator(collaborator.getName(), collaborator.getBirthday(),
                        collaborator.getAdmissionDate(), collaborator.getAddress(), collaborator.getPhoneNumber(),
                        collaborator.getEmail(), collaborator.getIdDocType(), collaborator.getIdNumber(), collaborator.getJob()));
    }
	

**Test 2:** Check that it is not possible to register a collaborator under 18 years old - AC05.

    @Test
    void validateBirthdayIsOver18() {

        Collaborator collaborator = new Collaborator("Daniel Silva", new Date(90, 5, 31),
                new Date(), "123 Street", 123456789, "daniel.silva@example.com", IdDocType.PASSPORT, 123456, new Job("Software Engineer", "Developing software applications"));

        assertTrue(collaborator.validateBirthdayIsOver18());

        Collaborator underageCollaborator = new Collaborator("Daniel Silva", new Date(120, 5, 31),
                new Date(), "456 Avenue", 987654321, "daniel.silva@example.com", IdDocType.PASSPORT, 654321, new Job("Software Engineer", "Developing software applications"));

        assertFalse(underageCollaborator.validateBirthdayIsOver18());
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class RegisterCollaboratorController 

```java
    public Collaborator registerCollaborator(String name, Date birthday, Date admissionDate, String address, int phoneNumber, String email, IdDocType idDocType, int idNumber, String jobName) {
    Job job = getJobByName(jobName);
    if (job == null) {
        return null;
    }
    return collaboratorRepository.registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job);
}
```

### Class Agenda

```java
    public Entry addEntryAgenda(Date startingDate, Task task, String gsmFromSession) {
    Entry newEntry = null;
    Entry entry = new Entry(startingDate, task);

    if (addEntry(gsmFromSession, entry)) {
        newEntry = entry;
    }
    return newEntry;
}
```


## 6. Integration and Demo 

* A new option on the HRM menu options was added.

* For demo purposes a collaborator are bootstrapped while system starts.


## 7. Observations

n/a
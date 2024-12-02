# US002 - Register a job

## 4. Tests

**Test 1:** Check if the job is being registered correctly, being stored in the repository and if it is not possible to register an already registered job - AC01/AC09.

    @Test
    void registerJob() {

        JobRepository jobRepository = new JobRepository();

        String name = "Programmer";
        String description = "Develop software applications";
       
        Job registeredJob = jobRepository.registerJob(name, description);

        assertNotNull(registeredJob);
        assertEquals(name, registeredJob.getName());

        List<Job> jobsList = jobRepository.getJobsList();

        assertTrue(jobsList.contains(registeredJob));

        assertThrows(IllegalArgumentException.class, () -> {
            jobRepository.registerJob(name, description);
        });
    }


**Test 2:** Check that the job is identified by its name and that it is not possible for there to be jobs with the same name - AC03/AC04.

    @Test
    void getJobByName() {

        JobRepository jobRepository = new JobRepository();
        String name = "Manager";
        String description = "Coordinate project teams";
        
        jobRepository.registerJob(name, description);

        Job retrievedJob = jobRepository.getJobByName(name);

        assertNotNull(retrievedJob);
        assertEquals(name, retrievedJob.getName());
        assertEquals(description, retrievedJob.getDescription());
    }



## 5. Construction (Implementation)

### Class RegisterJobController

```java
    public Job registerJob(String name, String description) {
    return jobRepository.registerJob(name, description);
}

```

### Class JobRepository

```java
    public Job registerJob (String name, String description) {
    Job newJob = null;
    Job job = new Job(name, description);
    if (addJob(job)) {
        newJob = job;
    }
    return newJob;
}

```


## 6. Integration and Demo 

* A new option on the HRM menu options was added.

* For demo purposes a job are bootstrapped while system starts.


## 7. Observations

n/a
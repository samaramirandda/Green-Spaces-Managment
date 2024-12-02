package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Job;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobRepositoryTest {

    @Test
    void registerJob() {

        JobRepository jobRepository = new JobRepository();
        String jobName = "Software Engineer";
        String jobDescription = "Develop software applications";

        Job registeredJob = jobRepository.registerJob(jobName, jobDescription);

        assertNotNull(registeredJob);
        assertEquals(jobName, registeredJob.getName());
        assertEquals(jobDescription, registeredJob.getDescription());

        List<Job> jobsList = jobRepository.getJobsList();

        assertTrue(jobsList.contains(registeredJob));

        assertThrows(IllegalArgumentException.class, () -> {
            jobRepository.registerJob(jobName, jobDescription);
        });
    }

    @Test
    void getJobByName() {

        JobRepository jobRepository = new JobRepository();
        String jobName = "Data Scientist";
        String jobDescription = "Analyze and interpret complex data sets";

        jobRepository.registerJob(jobName, jobDescription);

        Job retrievedJob = jobRepository.getJobByName(jobName);

        assertNotNull(retrievedJob);
        assertEquals(jobName, retrievedJob.getName());
        assertEquals(jobDescription, retrievedJob.getDescription());
    }
}

package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void testEquals() {

        Job job1 = new Job("Software Engineer", "Developing software applications");
        Job job2 = new Job("Software Engineer", "Developing software applications");

        assertTrue(job1.equals(job2));

        Job job3 = new Job("Software Engineer", "Developing software applications");
        Job job4 = new Job("Data Analyst", "Analyzing data trends");

        assertFalse(job3.equals(job4));
    }

    @Test
    void testClone() {

        Job originalJob = new Job("Software Engineer", "Developing software applications");

        Job clonedJob = originalJob.clone();

        assertEquals(originalJob, clonedJob);

        assertNotSame(originalJob, clonedJob);

        clonedJob.setName("Data Analyst");
        assertNotEquals(originalJob.getName(), clonedJob.getName());
    }
}

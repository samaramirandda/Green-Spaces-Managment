package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testEquals() {
        GreenSpace greenSpace = new GreenSpace("Park", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, new GreenSpacesManager("gsm@this.app"));
        Task task1 = new Task("Title", "Description", 1, 2, 3, greenSpace);
        Task task2 = new Task("Title", "Description", 1, 2, 3, greenSpace);

        assertEquals(task1, task2);
    }

    @Test
    void changeStatus() {
        GreenSpace greenSpace = new GreenSpace("Park", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, new GreenSpacesManager("gsm@this.app"));
        Task task = new Task("Title", "Description", 1, 2, 3, greenSpace);

        task.changeStatus(TaskStatus.PROCESSED);

        assertEquals(TaskStatus.PROCESSED, task.getStatus());
    }
}

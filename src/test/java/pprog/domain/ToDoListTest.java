package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @Test
    void addTaskToDoList() {
        ToDoList toDoList = new ToDoList();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Task 1", "Description", 1, 60, 1, greenSpace);
        Task taskAdd = toDoList.addTaskToDoList("Task 1", "Description", 1, 60, 1, greenSpace, "gsm@example.com");
        assertNotNull(taskAdd);
        List<Task> tasks = toDoList.getTasksList();
        assertEquals(tasks.get(tasks.size() - 1), task);
    }

    @Test
    void getTaskByIndex() {
        ToDoList toDoList = new ToDoList();
        GreenSpacesManager gsm = new GreenSpacesManager("test@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);

        Task task1 = toDoList.addTaskToDoList("Task 1", "Description 1", 1, 60, 1, greenSpace, "test@example.com");
        Task task2 = toDoList.addTaskToDoList("Task 2", "Description 2", 2, 30, 2, greenSpace, "test@example.com");

        Task retrievedTask1 = toDoList.getTaskByIndex(1);
        Task retrievedTask2 = toDoList.getTaskByIndex(2);

        assertNotNull(retrievedTask1);
        assertEquals(task1, retrievedTask1);
        assertNotNull(retrievedTask2);
        assertEquals(task2, retrievedTask2);
    }


    @Test
    void validateUser() {
        ToDoList toDoList = new ToDoList();
        GreenSpacesManager gsm = new GreenSpacesManager("test@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);

        Task task = toDoList.addTaskToDoList("Task", "Description", 1, 60, 1, greenSpace, "test@example.com");

        assertTrue(toDoList.validateUser("test@example.com", task));
        assertThrows(IllegalArgumentException.class, () -> toDoList.validateUser("wrong@example.com", task));
    }
}

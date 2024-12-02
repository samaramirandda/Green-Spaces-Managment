package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {

    @Test
    void testEquals() {

        Task task1 = new Task("Task 1", "Description 1", 1, 2, 1, new GreenSpace("Park", new String[]{"123 Green St", "City", "Country"}, 1, 1000.0, new GreenSpacesManager("email@this.app")));
        Task task2 = new Task("Task 1", "Description 1", 1, 2, 1, new GreenSpace("Park", new String[]{"123 Green St", "City", "Country"}, 1, 1000.0, new GreenSpacesManager("email@this.app")));

        Entry entry1 = new Entry(new Date(), task1);
        Entry entry2 = new Entry(new Date(), task2);

        assertEquals(entry1, entry2);
    }

    @Test
    void changeStatus() {
        Task task = new Task("Task", "Description", 1, 2, 1, new GreenSpace("Park", new String[]{"123 Green St", "City", "Country"}, 1, 1000.0, new GreenSpacesManager("email@this.app")));
        Entry entry = new Entry(new Date(), task);

        assertEquals(AgendaStatus.PLANNED, entry.getStatus());

        entry.changeStatus(AgendaStatus.DONE);

        assertEquals(AgendaStatus.DONE, entry.getStatus());
    }

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

    @Test
    void assignVehicles() {

        Vehicle vehicle1 = new Vehicle("Brand", "Model", 1000, 2000, 50000, new Date(), new Date(), 5000, "PlateNumber1", 1);
        Vehicle vehicle2 = new Vehicle("Brand", "Model", 1000, 2000, 50000, new Date(), new Date(), 5000, "PlateNumber2", 1);

        Task task = new Task("Task", "Description", 1, 2, 1, new GreenSpace("Park", new String[]{"123 Green St", "City", "Country"}, 1, 1000.0, new GreenSpacesManager("email@this.app")));
        Entry entry = new Entry(new Date(), task);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        entry.assignVehicles(vehicles);

        assertEquals(vehicles, entry.getVehiclesAssign());
    }
}

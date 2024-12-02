package pprog.domain;

import org.junit.jupiter.api.Test;
import pprog.controller.ConsultTasksController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

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


    @Test
    void getEntryByIndex_InvalidIndex() {
        Agenda agenda = new Agenda();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.getEntryByIndex(1);
        });
        assertEquals("Entry not found in Agenda.", exception.getMessage());
    }

    @Test
    void postponeEntry() {
        Agenda agenda = new Agenda();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
        Entry entry = new Entry(new Date(), task);
        entry.setGreenSpacesManager(gsm);
        agenda.getEntriesList().add(entry);

        Date newStartingDate = new Date(System.currentTimeMillis() + 100000);
        agenda.postponeEntry(entry, newStartingDate, gsm.getEmail());

        assertEquals(newStartingDate, entry.getStartingDate());
        assertEquals(AgendaStatus.POSTPONED, entry.getStatus());
    }

    @Test
    void postponeEntry_InvalidDate() {
        Agenda agenda = new Agenda();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
        Entry entry = new Entry(new Date(), task);
        entry.setGreenSpacesManager(gsm);
        agenda.getEntriesList().add(entry);

        Date newStartingDate = new Date(System.currentTimeMillis() - 100000);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.postponeEntry(entry, newStartingDate, gsm.getEmail());
        });
        assertEquals("The new date must be later than the date initially assigned to the task.", exception.getMessage());
    }

        @Test
        void cancelEntry() {
            Agenda agenda = new Agenda();
            GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
            String[] address = {"123 Green St", "City", "Country"};
            GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
            Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
            Entry entry = new Entry(new Date(), task);
            entry.setGreenSpacesManager(gsm);
            agenda.getEntriesList().add(entry);

            assertTrue(agenda.getEntriesList().contains(entry));

            agenda.cancelEntry(entry, gsm.getEmail());

            assertEquals(AgendaStatus.CANCELED, entry.getStatus());
        }

    @Test
    void completeEntry() {
        Agenda agenda = new Agenda();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
        Entry entry = new Entry(new Date(), task);

        String[] collabAddress = {"456 Blue St", "City", "Country"};
        Job job = new Job("Gardener", "Maintains the green space");
        Collaborator collaborator = new Collaborator("Collaborator Name", new Date(), new Date(), collabAddress, 123456789, "collaborator@example.com", 1, 12345, job);
        List<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(collaborator);
        Team team = new Team(collaborators);
        entry.assignTeam(team);

        String brand = "Brand";
        String model = "Model";
        int tare = 1500;
        int grossWeight = 2500;
        int currentKm = 20000;
        Date registerDate = new Date();
        Date acquisitionDate = new Date();
        int maintenanceCheckUpFrequency = 12;
        String plateNumber = "XYZ-1234";
        int vehicleTypeValue = 1;

        Vehicle vehicle = new Vehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, vehicleTypeValue);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        entry.assignVehicles(vehicles);

        agenda.getEntriesList().add(entry);

        agenda.completeEntry(entry, collaborator.getEmail());

        assertEquals(AgendaStatus.DONE, entry.getStatus());
        assertFalse(vehicle.isOccupiedVehicle());
    }

    @Test
    void getTasksForCollaboratorBetweenDates() {
        Agenda agenda = new Agenda();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
        Entry entry = new Entry(new Date(), task);

        String[] collabAddress = {"456 Blue St", "City", "Country"};
        Job job = new Job("Gardener", "Maintains the green space");
        Collaborator collaborator = new Collaborator("Collaborator Name", new Date(), new Date(), collabAddress, 123456789, "collaborator@example.com", 1, 12345, job);
        List<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(collaborator);
        Team team = new Team(collaborators);
        entry.assignTeam(team);

        agenda.getEntriesList().add(entry);

        Date startDate = new Date(System.currentTimeMillis() - 100000);
        Date endDate = new Date(System.currentTimeMillis() + 100000);

        List<Entry> tasks = agenda.getTasksForCollaboratorBetweenDates(collaborator.getEmail(), startDate, endDate);

        assertEquals(1, tasks.size());
        assertEquals(entry, tasks.get(0));
    }


    @Test
    void verifyCollaborator() {
        Agenda agenda = new Agenda();
        GreenSpacesManager gsm = new GreenSpacesManager("gsm@example.com");
        String[] address = {"123 Green St", "City", "Country"};
        GreenSpace greenSpace = new GreenSpace("Central Park", address, 1, 500.0, gsm);
        Task task = new Task("Title", "Description", 1, 60, 1, greenSpace);
        Entry entry = new Entry(new Date(), task);

        String[] collabAddress = {"456 Blue St", "City", "Country"};
        Job job = new Job("Gardener", "Maintains the green space");
        Collaborator collaborator = new Collaborator("Collaborator Name", new Date(), new Date(), collabAddress, 123456789, "collaborator@example.com", 1, 12345, job);
        List<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(collaborator);
        Team team = new Team(collaborators);
        entry.assignTeam(team);

        assertTrue(agenda.verifyCollaborator(entry, collaborator.getEmail()));
    }

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

}
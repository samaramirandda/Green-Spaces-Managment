package pprog.ui.console;

import pprog.controller.AddEntryAgendaController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Represents the user interface for adding an entry to the agenda.
 */
public class AddEntryAgendaUI implements Runnable {
    private final AddEntryAgendaController controller;

    private int index;
    private Date date;

    /**
     * Constructs an AddEntryAgendaUI object.
     */
    public AddEntryAgendaUI() {
        controller = new AddEntryAgendaController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return the AddEntryAgendaController instance
     */
    public AddEntryAgendaController getController() {
        return controller;
    }

    /**
     * Runs the UI, allowing the user to add an entry to the agenda.
     */
    public void run() {
        System.out.println("\n\n--- Add an Entry in the Agenda ------------------------");

        listAllTasks();
        requestData();
        submitData();
    }

    /**
     * Submits the data to the controller to add the entry.
     */
    private void submitData() {
        String result = getController().addEntryAgenda(date, index);
        if (result == null) {
            System.out.println("\nTask successfully added!");
            System.out.println(getController().getEntryAdded());
        } else {
            System.out.println("Task not added!\n" + result);
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        index = requestTask();
        date = requestDate();
    }

    /**
     * Requests the task index from the user.
     *
     * @return the index of the selected task
     */
    private int requestTask() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Task: ");
                if (input.hasNextInt()) {
                    int task = input.nextInt();
                    if (task > 0 && task <= controller.getTasksList().size()) {
                        return task;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the starting date from the user.
     *
     * @return the starting date
     */
    private Date requestDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Starting Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestDate();
        }
    }

    /**
     * Lists all tasks available for selection.
     */
    private void listAllTasks() {
        if (controller.getTasksList().isEmpty()) {
            System.out.println("To-Do List is empty!");
        } else {
            System.out.println(controller.getTasksList());
        }
    }
}

package pprog.ui.console;

import pprog.controller.CompleteEntryAgendaController;
import pprog.domain.Entry;

import java.util.List;
import java.util.Scanner;

/**
 * Represents the user interface for completing a task in the agenda.
 */
public class CompleteEntryAgendaUI implements Runnable {

    private final CompleteEntryAgendaController controller;

    private int taskIndex;

    /**
     * Constructs a CompleteEntryAgendaUI object.
     */
    public CompleteEntryAgendaUI() {
        controller = new CompleteEntryAgendaController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return the CompleteEntryAgendaController instance
     */
    public CompleteEntryAgendaController getController() {
        return controller;
    }

    /**
     * Runs the UI, allowing the user to complete a task.
     */
    public void run() {
        System.out.println("\n\n--- Complete a Task ------------------------");

        listAllEntries();
        requestData();
        submitData();
    }

    /**
     * Submits the data to the controller to complete the task.
     */
    private void submitData() {
        String result = getController().completeEntry(taskIndex);
        if (result == null) {
            System.out.println("\nTask registered as completed successfully!");
            System.out.println(getController().getEntryComplete(taskIndex));
        } else {
            System.out.println("Task not completed!\n" + result);
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        taskIndex = requestTask();
    }

    /**
     * Requests the task entry from the user.
     *
     * @return the task entry index
     */
    private int requestTask() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Task: ");
                if (input.hasNextInt()) {
                    int type = input.nextInt();
                    if (type > 0 && type <= getController().getEntriesList().size()) {
                        return type;
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
     * Lists all task entries available for completion.
     */
    private void listAllEntries() {
        List<Entry> entries = getController().getEntriesList();
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                Entry entry = entries.get(i);
                System.out.println((i + 1) + ". " + entry.getTask().getTitle() + " - " + entry.getStartingDate() + " - " + entry.getStatus());
            }
        }
    }
}

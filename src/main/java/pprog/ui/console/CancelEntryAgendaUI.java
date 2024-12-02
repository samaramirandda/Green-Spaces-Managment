package pprog.ui.console;

import pprog.controller.CancelEntryAgendaController;
import pprog.domain.Entry;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for canceling an entry in the agenda.
 */
public class CancelEntryAgendaUI implements Runnable{

    private final CancelEntryAgendaController controller;

    private int taskIndex;

    /**
     * Constructs a new CancelEntryAgendaUI instance with a default controller.
     */
    public CancelEntryAgendaUI() {
        controller = new CancelEntryAgendaController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return The CancelEntryAgendaController instance.
     */
    public CancelEntryAgendaController getController() {
        return controller;
    }

    /**
     * Runs the UI to cancel a task.
     */
    public void run() {
        System.out.println("\n\n--- Cancel an Entry ------------------------");

        listAllEntries();
        requestData();
        submitData();
    }

    /**
     * Submits data to cancel the selected task.
     */
    private void submitData() {
        String result = getController().cancelEntry(taskIndex);
        if (result == null) {
            System.out.println("\nTask successfully canceled!");
            System.out.println(getController().getEntryCancel(taskIndex));
        } else {
            System.out.println("Task not canceled!\n" + result);
        }
    }

    /**
     * Requests data from the user to select the task to cancel.
     */
    private void requestData() {
        taskIndex = requestTask();
    }

    private int requestTask() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Task: ");
                if (input.hasNextInt()) {
                    int type = input.nextInt();
                    if (type > 0 && type <= controller.getEntriesList().size()) {
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
     * Lists all entries in the agenda.
     */
    private void listAllEntries() {
        List<Entry> entries = controller.getEntriesList();
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

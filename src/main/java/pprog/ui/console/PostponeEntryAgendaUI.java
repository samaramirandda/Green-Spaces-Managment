package pprog.ui.console;

import pprog.controller.PostponeEntryAgendaController;
import pprog.domain.Entry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * UI class for postponing an entry in the agenda.
 */
public class PostponeEntryAgendaUI implements Runnable {

    private final PostponeEntryAgendaController controller;

    private int index;
    private Date date;

    /**
     * Constructs a PostponeEntryAgendaUI object.
     */
    public PostponeEntryAgendaUI() {
        controller = new PostponeEntryAgendaController();
    }

    public PostponeEntryAgendaController getController() {
        return controller;
    }

    /**
     * Runs the UI for postponing an entry.
     */
    public void run() {
        System.out.println("\n\n--- Postpone an Entry ------------------------");
        listAllEntries();
        requestData();
        submitData();
    }

    private void submitData() {
        String result = getController().postponeEntry(index, date);
        if (result == null) {
            System.out.println("\nEntry postponed successfully!");
            System.out.println(getController().getEntryPostpone(index));
        } else {
            System.out.println("Failed to postpone the entry!\n" + result);
        }
    }

    private void requestData() {
        index = requestTask();
        date = requestDate();
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

    private Date requestDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("New Start Date (format: dd/MM/yyyy): ");
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
}
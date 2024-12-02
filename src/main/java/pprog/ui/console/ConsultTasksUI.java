package pprog.ui.console;

import pprog.controller.ConsultTasksController;
import pprog.domain.Entry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the user interface for consulting tasks.
 */
public class ConsultTasksUI implements Runnable{

    private final ConsultTasksController controller;

    private Date startDate;
    private Date endDate;

    /**
     * Constructs a new ConsultTasksUI object.
     */
    public ConsultTasksUI() {
        controller = new ConsultTasksController();
    }

    private ConsultTasksController getController() {
        return controller;
    }


    public void run() {
        System.out.println("\n\n--- Consult a Task ------------------------");

        requestData();
        submitData();
    }

    private void submitData() {

        List<Entry> tasks = getController().getTasksForCollaboratorBetweenDates(startDate, endDate);

        if (tasks.isEmpty()) {
            System.out.println("No tasks were assigned to you during this period.");
        } else {
            for (Entry entry : tasks) {
                System.out.println(entry.getTask().getTitle() + " - " + entry.getStartingDate());
            }
        }
    }

    private void requestData() {
        startDate = requestStartDate();
        endDate = requestEndDate(startDate);
    }

    private Date requestStartDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the start date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestStartDate();
        }
    }

    private Date requestEndDate(Date startDate) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        while (true) {
            try {
                System.out.print("Enter the end date (format: dd/MM/yyyy): ");
                String dateStr = input.nextLine();
                Date endDate = dateFormat.parse(dateStr);
                if (endDate.before(startDate)) {
                    throw new IllegalArgumentException("End date cannot be before the start date.");
                }
                return endDate;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

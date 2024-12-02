package pprog.ui.console;

import pprog.controller.AssignTeamController;

import java.util.Scanner;

/**
 * Represents the user interface for assigning a team to a task.
 */
public class AssignTeamUI implements Runnable {
    private final AssignTeamController controller;

    private int entry;
    private int team;

    /**
     * Constructs an AssignTeamUI object.
     */
    public AssignTeamUI() {
        controller = new AssignTeamController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return the AssignTeamController instance
     */
    public AssignTeamController getController() {
        return controller;
    }

    /**
     * Runs the UI, allowing the user to assign a team to a task.
     */
    public void run() {
        System.out.println("\n\n--- Assign a Team to a Task------------------------");

        listAllTeams();
        listAllEntries();
        requestData();
        submitData();
    }

    /**
     * Submits the data to the controller to assign the team.
     */
    private void submitData() {
        String result = getController().assignTeamToEntry(entry, team);
        if (result == null) {
            System.out.println("\nSuccessfully assigned team!");
            System.out.println(getController().getEntryWithTeam(entry));
        } else {
            System.out.println("Unassigned team!\n" + result);
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        entry = requestTask();
        team = requestTeam();
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
     * Requests the team from the user.
     *
     * @return the team index
     */
    private int requestTeam() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Team: ");
                if (input.hasNextInt()) {
                    int team = input.nextInt();
                    if (team > 0 && team <= controller.getTeamsList().size()) {
                        return team;
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
     * Lists all teams available for selection.
     */
    private void listAllTeams() {
        if (controller.getTeamsList().isEmpty()) {
            System.out.println("Team List is empty!");
        } else {
            System.out.println(controller.getTeamsList());
        }
    }

    /**
     * Lists all task entries available for selection.
     */
    private void listAllEntries() {
        if (controller.getEntriesList().isEmpty()) {
            System.out.println("Agenda is empty!");
        } else {
            System.out.println(controller.getEntriesList());
        }
    }
}

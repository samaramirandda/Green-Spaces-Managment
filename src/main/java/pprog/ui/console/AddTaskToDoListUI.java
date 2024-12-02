package pprog.ui.console;

import pprog.controller.AddTaskToDoListController;

import java.util.Scanner;

/**
 * Represents the user interface for adding a task to the to-do list.
 */
public class AddTaskToDoListUI implements Runnable {

    private final AddTaskToDoListController controller;
    private String title;
    private String description;
    private int degreeOfUrgency;
    private int expectedDuration;
    private int type;
    private String greenSpace;

    /**
     * Constructs an AddTaskToDoListUI object.
     */
    public AddTaskToDoListUI() {
        controller = new AddTaskToDoListController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return the AddTaskToDoListController instance
     */
    private AddTaskToDoListController getController() {
        return controller;
    }

    /**
     * Runs the UI, allowing the user to add a task to the to-do list.
     */
    public void run() {
        System.out.println("\n\n--- Add Task to To-Do List ------------------------");

        listAllGreenSpaces();
        requestData();
        submitData();
    }

    /**
     * Submits the data to the controller to add the task.
     */
    private void submitData() {
        String result = getController().addTaskToDoList(title, description, degreeOfUrgency, expectedDuration, type, greenSpace);
        if (result == null) {
            System.out.println("\nTask successfully added!");
            System.out.println(getController().getTaskAdded());
        } else {
            System.out.println("Task not added!\n" + result);
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        title = requestTitle();
        description = requestDescription();
        degreeOfUrgency = requestDegreeOfUrgency();
        expectedDuration = requestExpectedDuration();
        type = requestType();
        greenSpace = requestGreenSpace();
    }

    /**
     * Requests the task title from the user.
     *
     * @return the task title
     */
    private String requestTitle() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Title: ");
                String name = input.nextLine().trim();
                if (name.matches("[a-zA-Z0-9\\s]+")) {
                    return name;
                } else {
                    throw new IllegalArgumentException("Invalid title. Please enter a valid title.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Requests the task description from the user.
     *
     * @return the task description
     */
    private String requestDescription() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Description: ");
                String description = input.nextLine().trim();
                if (description.matches("[a-zA-Z0-9\\s]+")) {
                    return description;
                } else {
                    throw new IllegalArgumentException("Invalid description. Please enter a valid description.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Requests the degree of urgency from the user.
     *
     * @return the degree of urgency
     */
    private int requestDegreeOfUrgency() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Degree of Urgency: ");
                System.out.println("1 - High");
                System.out.println("2 - Medium");
                System.out.println("3 - Low");
                if (input.hasNextInt()) {
                    int degree = input.nextInt();
                    if (degree > 0 && degree < 4) {
                        return degree;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2 or 3).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2 or 3).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the expected duration from the user.
     *
     * @return the expected duration
     */
    private int requestExpectedDuration() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Expected Duration: ");
                if (input.hasNextDouble()) {
                    int duration = input.nextInt();
                    if (duration > 0) {
                        return duration;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please insert a valid duration (greater than 0).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please enter numbers.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the task type from the user.
     *
     * @return the task type
     */
    private int requestType() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Type: ");
                System.out.println("1 - Regular");
                System.out.println("2 - Occasional");
                if (input.hasNextInt()) {
                    int degree = input.nextInt();
                    if (degree > 0 && degree < 3) {
                        return degree;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the green space name from the user.
     *
     * @return the green space name
     */
    private String requestGreenSpace() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Green Space: ");
                String greenSpace = input.nextLine().trim();
                if (greenSpace.matches("[a-zA-Z0-9\\s]+")) {
                    return greenSpace;
                } else {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Lists all green spaces available for selection.
     */
    private void listAllGreenSpaces() {
        if (controller.getGreenSpacesList().isEmpty()) {
            System.out.println("No Green Spaces found!");
        } else {
            System.out.println(controller.getGreenSpacesList());
        }
    }

}

package pprog.ui.console;

import pprog.controller.AssignVehiclesController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the user interface for assigning vehicles to a task.
 */
public class AssignVehiclesUI implements Runnable {

    private final AssignVehiclesController controller;

    private int entry;
    private List<String> vehiclesPlateNumber;

    /**
     * Constructs an AssignVehiclesUI object.
     */
    public AssignVehiclesUI() {
        controller = new AssignVehiclesController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return the AssignVehiclesController instance
     */
    public AssignVehiclesController getController() {
        return controller;
    }

    /**
     * Runs the UI, allowing the user to assign vehicles to a task.
     */
    public void run() {
        System.out.println("\n\n--- Assign vehicles to a task------------------------");

        listAllVehicles();
        listAllEntries();
        requestData();
        submitData();
    }

    /**
     * Submits the data to the controller to assign the vehicles.
     */
    private void submitData() {
        String result = getController().assignVehiclesToEntry(entry, vehiclesPlateNumber);
        if (result == null) {
            System.out.println("\nSuccessfully assigned vehicles!");
            System.out.println(getController().getEntryWithVehicles(entry));
        } else {
            System.out.println("Unassigned vehicles!\n" + result);
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        entry = requestTask();
        vehiclesPlateNumber = requestVehicles();
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
     * Requests the vehicle plate numbers from the user.
     *
     * @return a list of vehicle plate numbers
     */
    private List<String> requestVehicles() {
        ArrayList<String> vehiclesList = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Vehicle Plate Number (format: XX XX XX): ");
                Scanner input = new Scanner(System.in);
                String plateNumber = input.nextLine();

                if (plateNumber.matches("[A-Z0-9]{2} [A-Z0-9]{2} [A-Z0-9]{2}")) {
                    vehiclesList.add(plateNumber);
                } else {
                    throw new IllegalArgumentException("Please enter a plate number in the format XX XX XX.");
                }

                System.out.print("Do you want to add another vehicle? (yes/no): ");
                String choice = input.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    if (!choice.equalsIgnoreCase("no")) {
                        throw new IllegalArgumentException("Please enter 'yes' to add another vehicle or 'no' to finish.");
                    }
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String[] vehiclesToAssign = vehiclesList.toArray(new String[0]);

        return List.of(vehiclesToAssign);
    }

    /**
     * Lists all vehicles available for selection.
     */
    private void listAllVehicles() {
        if (controller.getVehiclesList().isEmpty()) {
            System.out.println("Vehicles List is empty!");
        } else {
            System.out.println(controller.getVehiclesList());
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

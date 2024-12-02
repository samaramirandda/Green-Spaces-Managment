package pprog.ui.console;

import pprog.controller.VehicleNeedingMaintenanceController;

import java.util.List;

/**
 * User interface for producing a list of vehicles needing maintenance.
 */
public class VehicleNeedingMaintenanceUI implements Runnable {

    /**
     * The controller for managing vehicle needing maintenance operations.
     */
    private final VehicleNeedingMaintenanceController controller;

    /**
     * Constructs a VehicleNeedingMaintenanceUI with a new instance of VehicleNeedingMaintenanceController.
     */
    public VehicleNeedingMaintenanceUI() {
        controller = new VehicleNeedingMaintenanceController();
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    private VehicleNeedingMaintenanceController getController() {
        return controller;
    }

    /**
     * Runs the UI.
     */
    public void run() {
        System.out.println("\n\n--- Produce a list of vehicles needing maintenance ------------------------");

        submitData();
    }

    /**
     * Submits data to produce the list of vehicles needing maintenance.
     */
    private void submitData() {

        List<String> vehiclesNeedingMaintenanceList = getController().getVehiclesNeedingMaintenanceList();
        if (vehiclesNeedingMaintenanceList != null) {
            System.out.printf("%-15s%-15s%-15s%-10s%-10s%-10s%-10s%n",
                    "Plate", "Brand", "Model", "Curr.Kms", "Freq", "Last", "Next");
            System.out.println(vehiclesNeedingMaintenanceList);
        } else {
            System.out.println("No vehicle needs maintenance");
        }

    }
}

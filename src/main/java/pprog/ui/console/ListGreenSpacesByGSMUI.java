package pprog.ui.console;

import pprog.controller.ListGreenSpacesByGSMController;
import pprog.domain.GreenSpace;

import java.util.List;

/**
 * Represents the user interface for listing green spaces managed by the current GSM (Green Space Manager).
 */
public class ListGreenSpacesByGSMUI implements Runnable {

    private final ListGreenSpacesByGSMController controller;

    /**
     * Constructs a ListGreenSpacesByGSMUI object.
     */
    public ListGreenSpacesByGSMUI() {
        controller = new ListGreenSpacesByGSMController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return the ListGreenSpacesByGSMController instance
     */
    private ListGreenSpacesByGSMController getController() {
        return controller;
    }

    /**
     * Runs the UI, displaying the list of green spaces managed by the current GSM.
     */
    public void run() {
        System.out.println("\n\n--- List of Green Spaces Managed by GSM ------------------------");

        List<GreenSpace> sortedGreenSpaces = getController().sortListByAlgorithm();

        if (sortedGreenSpaces.isEmpty()) {
            System.out.println("No green spaces managed by the current GSM.");
        } else {
            for (GreenSpace gs : sortedGreenSpaces) {
                System.out.println(gs);
            }
        }
    }
}

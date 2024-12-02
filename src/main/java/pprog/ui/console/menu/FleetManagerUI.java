package pprog.ui.console.menu;


import pprog.ui.console.RegisterCheckUpUI;
import pprog.ui.console.RegisterVehicleUI;
import pprog.ui.console.VehicleNeedingMaintenanceUI;
import pprog.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class FleetManagerUI implements Runnable {
    public FleetManagerUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register a Vehicle", new RegisterVehicleUI()));
        options.add(new MenuItem("Register a vehicle’s maintenance", new RegisterCheckUpUI()));
        options.add(new MenuItem("Produce a list of vehicles needing maintenance", new VehicleNeedingMaintenanceUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- VEHICLE AND EQUIPMENT FLEET MANAGER MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}

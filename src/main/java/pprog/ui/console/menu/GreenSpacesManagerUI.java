package pprog.ui.console.menu;

import pprog.ui.console.*;
import pprog.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GreenSpacesManagerUI implements Runnable {
    public GreenSpacesManagerUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
            options.add(new MenuItem("Register a Green Space", new RegisterGreenSpaceUI()));
            options.add(new MenuItem("Add Task to To-Do List", new AddTaskToDoListUI()));
            options.add(new MenuItem("Add a Entry in the Agenda", new AddEntryAgendaUI()));
            options.add(new MenuItem("Assign a Team to a Task", new AssignTeamUI()));
            options.add(new MenuItem("Postpone an Entry in the Agenda", new PostponeEntryAgendaUI()));
            options.add(new MenuItem("Cancel an Entry in the Agenda", new CancelEntryAgendaUI()));
            options.add(new MenuItem("Assign vehicles to a task", new AssignVehiclesUI()));
            options.add(new MenuItem("List of Green Spaces Managed by me", new ListGreenSpacesByGSMUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- GREEN SPACES MANAGER MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}

package pprog.ui.console.menu;

import pprog.ui.console.CompleteEntryAgendaUI;
import pprog.ui.console.ConsultTasksUI;
import pprog.ui.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorUI implements Runnable {
    public CollaboratorUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
            options.add(new MenuItem("Consult the Tasks assigned to me", new ConsultTasksUI()));
            options.add(new MenuItem("Record the Completion of a Task", new CompleteEntryAgendaUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- COLLABORATOR MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}

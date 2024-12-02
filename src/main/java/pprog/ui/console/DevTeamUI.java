package pprog.ui.console;

/**
 * Represents the user interface for the development team information.
 */
public class DevTeamUI implements Runnable {

    /**
     * Constructs a new DevTeamUI object.
     */
    public DevTeamUI() {

    }

    /**
     * Displays the development team information.
     */
    public void run() {
        System.out.println("\n");
        System.out.println("--- DEVELOPMENT TEAM -------------------");
        System.out.println("  Daniel Silva - 1231046@isep.ipp.pt");
        System.out.println("  Igor Coutinho - 1230543@isep.ipp.pt");
        System.out.println("  Rafael Barbosa - 1230544@isep.ipp.pt");
        System.out.println("  Samara Miranda - 1230432@isep.ipp.pt");
        System.out.println("\n");
    }
}

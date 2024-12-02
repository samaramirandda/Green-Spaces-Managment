package pprog.ui.console;

import pprog.controller.GenerateTeamController;
import pprog.domain.Team;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for generating teams.
 */
public class GenerateTeamUI implements Runnable {

    /**
     * The controller for managing team generation.
     */
    private final GenerateTeamController controller;

    /**
     * The minimum size of the team.
     */
    private int minSize;

    /**
     * The maximum size of the team.
     */
    private int maxSize;

    /**
     * The list of required skills for the team.
     */
    private List<String> requiredSkills;

    /**
     * Constructs a new GenerateTeamUI with default values.
     */
    public GenerateTeamUI() {
        controller = new GenerateTeamController();
    }

    /**
     * Retrieves the GenerateTeamController associated with this UI.
     *
     * @return The GenerateTeamController.
     */
    private GenerateTeamController getController() {
        return controller;
    }

    /**
     * Runs the GenerateTeamUI.
     */
    public void run() {
        System.out.println("\n\n--- Generate a team proposal automatically ------------------------");

        requestData();
        displaySkills();
        requiredSkills = requestRequiredSkills();
        submitData();
    }

    /**
     * Submits the entered data for team generation.
     */
    private void submitData() {

        if (getController().team(minSize, maxSize, requiredSkills)) {

            System.out.println("\nTeam generated successfully!");
            List<Team> teams = getController().getTeamsList();
            System.out.println(teams.get(teams.size() - 1));

        } else {
            System.out.println("Team generation failed!");
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        minSize = requestMinSize();
        maxSize = requestMaxSize();
    }

    /**
     * Requests the minimum size of the team from the user.
     *
     * @return The minimum size of the team.
     */
    private int requestMinSize() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Minimum Size: ");
                if (input.hasNextInt()) {
                    int minSize = input.nextInt();
                    if (minSize > 0) {
                        return minSize;
                    } else {
                        throw new IllegalArgumentException("Please enter a number greater than 1.");
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
     * Requests the maximum size of the team from the user.
     *
     * @return The maximum size of the team.
     */
    private int requestMaxSize() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Maximum Size: ");
                if (input.hasNextInt()) {
                    int maxSize = input.nextInt();
                    if (maxSize > 0) {
                        return maxSize;
                    } else {
                        throw new IllegalArgumentException("Please enter a number greater than 1.");
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
     * Requests the required skills for the team from the user.
     *
     * @return The list of required skills.
     */
    private List<String> requestRequiredSkills() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter required skills for the team (comma-separated): ");
        String skillNamesInput = input.nextLine();
        String[] skillNames = skillNamesInput.split(",");
        return List.of(skillNames);
    }

    /**
     * Displays the list of available skills to the user.
     */
    private void displaySkills() {

        System.out.println("List of existing skills: ");
        System.out.println(getController().getSkillList());

    }
}

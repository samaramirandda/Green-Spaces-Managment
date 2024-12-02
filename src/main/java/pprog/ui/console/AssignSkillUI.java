package pprog.ui.console;

import pprog.controller.AssignSkillController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the user interface for assigning skills to a collaborator.
 */
public class AssignSkillUI implements Runnable {

    /**
     * The controller for assigning skills.
     */
    private final AssignSkillController controller;

    /**
     * The collaborator to whom skills will be assigned.
     */
    private String collaborator;

    /**
     * The list of skills to be assigned.
     */
    private List<String> skillsToAssign;

    /**
     * Constructs a new AssignSkillUI object.
     */
    public AssignSkillUI() {
        controller = new AssignSkillController();
    }

    /**
     * Gets the AssignSkillController associated with this UI.
     *
     * @return the AssignSkillController
     */
    private AssignSkillController getController() {
        return controller;
    }

    /**
     * Runs the AssignSkillUI.
     */
    public void run() {
        System.out.println("\n\n--- Assign one or more skills to a Collaborator ------------------------");

        displayCollaborators();
        displaySkills();
        requestData();
        submitData();
    }

    /**
     * Submits the data to assign skills to the collaborator.
     */
    private void submitData() {

        if (getController().assignSkillToCollaborator(collaborator, skillsToAssign)) {
            System.out.println("\nSkills successfully assigned to the collaborator!");
        } else {
            System.out.println("Skills were not assigned!");
        }

    }

    /**
     * Requests collaborator and skills data from the user.
     */
    private void requestData() {
        collaborator = requestCollaborator();
        skillsToAssign = requestSkillsToAssign();
    }

    /**
     * Requests the collaborator name from the user and retrieves the corresponding collaborator.
     *
     * @return the selected collaborator
     */
    private String requestCollaborator() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the collaborator: ");
        return input.nextLine();
    }

    /**
     * Requests the skills to assign from the user and retrieves the corresponding skills.
     *
     * @return the list of skills to assign
     */
    private List<String> requestSkillsToAssign() {
        ArrayList<String> skillNames = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Enter skill name to assign to the collaborator: ");
                Scanner input = new Scanner(System.in);
                String skill = input.nextLine();

                if (skill.matches("^[a-zA-Z ]+$")) {
                    skillNames.add(skill);
                } else {
                    throw new IllegalArgumentException("Please enter a valid skill name.");
                }

                System.out.print("Do you want to assign another skill? (yes/no): ");
                String choice = input.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    if (!choice.equalsIgnoreCase("no")) {
                        throw new IllegalArgumentException("Please enter 'yes' to assign another skill or 'no' to finish.");
                    }
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String[] skillsToAssign = skillNames.toArray(new String[0]);

        return List.of(skillsToAssign);
    }

    /**
     * Displays the list of existing collaborators.
     */
    private void displayCollaborators() {

        System.out.println("List of existing collaborators: ");
        System.out.println(getController().getCollaboratorList());

    }

    /**
     * Displays the list of existing skills.
     */
    private void displaySkills() {

        System.out.println("List of existing skills: ");
        System.out.println(getController().getSkillsList());

    }
}

package pprog.ui.console;

import pprog.controller.RegisterSkillController;

import java.util.Scanner;

/**
 * User interface for registering a skill.
 */
public class RegisterSkillUI implements Runnable {

    /**
     * The controller for managing skill registration.
     */
    private final RegisterSkillController controller;

    /**
     * The name of the skill to be registered.
     */
    private String name;

    /**
     * Constructs a new RegisterSkillUI with default values.
     */
    public RegisterSkillUI() {
        controller = new RegisterSkillController();
    }

    /**
     * Retrieves the RegisterSkillController associated with this UI.
     *
     * @return The RegisterSkillController.
     */
    private RegisterSkillController getController() {
        return controller;
    }

    /**
     * Runs the RegisterSkillUI.
     */
    public void run() {
        System.out.println("\n\n--- Register a Skill ------------------------");

        requestData();
        submitData();

    }

    /**
     * Submits the entered data for skill registration.
     */
    private void submitData() {
        if (getController().registerSkill(name)) {
            System.out.println("\nSkill successfully registered!");
        } else {
            System.out.println("Skill not registered!");
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        name = requestName();
    }

    /**
     * Requests the name of the skill from the user.
     *
     * @return The name of the skill.
     */
    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        return input.nextLine();
    }
}

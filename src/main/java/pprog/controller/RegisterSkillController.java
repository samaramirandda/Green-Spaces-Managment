package pprog.controller;

import pprog.repository.Repositories;
import pprog.repository.SkillRepository;

/**
 * Controller for registering skills.
 */
public class RegisterSkillController {

    /**
     * The skill repository used for registering skills.
     */
    private SkillRepository skillRepository;

    /**
     * Constructs a RegisterSkillController with the given skill repository.
     *
     * @param skillRepository the skill repository to use
     */
    public RegisterSkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     * Constructs a RegisterSkillController using the global skill repository.
     */
    public RegisterSkillController() {
        getSkillRepository();
    }

    /**
     * Gets the skill repository.
     * If not already initialized, initializes it using the global repository.
     *
     * @return the skill repository
     */
    public SkillRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    /**
     * Registers a new skill.
     *
     * @param skillName the name of the skill to register
     * @return true if the skill is registered successfully, false otherwise
     */
    public boolean registerSkill(String skillName) {
        try {
            getSkillRepository().registerSkill(skillName);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }

}

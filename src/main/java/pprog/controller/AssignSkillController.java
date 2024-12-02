package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.Skill;
import pprog.repository.CollaboratorRepository;
import pprog.repository.Repositories;
import pprog.repository.SkillRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The AssignSkillController class provides methods for assigning skills to collaborators.
 */
public class AssignSkillController {

    /**
     * The skill repository instance.
     */
    private SkillRepository skillRepository;

    /**
     * The collaborator repository instance.
     */
    private CollaboratorRepository collaboratorRepository;

    /**
     * Constructs a new AssignSkillController object with the specified repositories.
     *
     * @param skillRepository       The repository for skills.
     * @param collaboratorRepository The repository for collaborators.
     */
    public AssignSkillController(SkillRepository skillRepository, CollaboratorRepository collaboratorRepository) {
        this.skillRepository = skillRepository;
        this.collaboratorRepository = collaboratorRepository;
    }

    /**
     * Constructs a new AssignSkillController object with default repositories obtained from Repositories singleton.
     */
    public AssignSkillController() {
        getSkillRepository();
        getCollaboratorRepository();
    }

    /**
     * Retrieves the skill repository from the Repositories singleton, initializing it if necessary.
     *
     * @return The skill repository.
     */
    public SkillRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    /**
     * Retrieves the collaborator repository from the Repositories singleton, initializing it if necessary.
     *
     * @return The collaborator repository.
     */
    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }

    /**
     * Retrieves a collaborator by their name.
     *
     * @param collaboratorName The name of the collaborator.
     * @return The collaborator object, or null if not found.
     */
    public Collaborator getCollaboratorByName(String collaboratorName) {
        return getCollaboratorRepository().getCollaboratorByName(collaboratorName);
    }

    /**
     * Retrieves a list of all collaborators.
     *
     * @return A list of all collaborators.
     */
    public List<Collaborator> getCollaboratorList() {
        return getCollaboratorRepository().getCollaboratorsList();
    }

    /**
     * Retrieves a skill by its name.
     *
     * @param skillName The name of the skill.
     * @return The skill object, or null if not found.
     */
    private Skill getSkillByName(String skillName) {
        return getSkillRepository().getSkillByName(skillName);
    }

    /**
     * Retrieves a list of all skills.
     *
     * @return A list of all skills.
     */
    public List<Skill> getSkillsList() {
        return getSkillRepository().getSkillsList();
    }

    /**
     * Assigns skills to a collaborator.
     *
     * @param nameCollaborator The name of the collaborator to whom skills are to be assigned.
     * @param skillNames       The names of the skills to assign.
     * @return true if the assignment is successful, false otherwise.
     */
    public boolean assignSkillToCollaborator(String nameCollaborator, List<String> skillNames) {
        List<Skill> skillsToAssign = new ArrayList<>();
        try {
            for (String skillName : skillNames) {
                skillsToAssign.add(getSkillByName(skillName.trim()));
            }
            getCollaboratorByName(nameCollaborator).assignSkills(skillsToAssign);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
    }
}

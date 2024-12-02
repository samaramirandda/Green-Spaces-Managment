package pprog.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the generation of a team based on specific criteria.
 */
public class Team implements Serializable {

    /**
     * List of collaborators needed for the team.
     */
    private List<Collaborator> collaborators;

    /**
     * Constructs a team with the given list of collaborators.
     *
     * @param members The list of collaborators.
     */
    public Team(List<Collaborator> members) {
        collaborators = members;
    }

    /**
     * Retrieves the list of collaborators with the required skills.
     *
     * @param collaboratorList The list of available collaborators.
     * @param skillsNeeded     The list of skills needed for the team.
     * @return The list of collaborators with the required skills.
     */
    public static List<Collaborator> seeColaboratorsWithSkillsNeeded(List<Collaborator> collaboratorList, List<Skill> skillsNeeded) {
        List<Collaborator> collaboratorWithTheSkills = new ArrayList<>();
        List<Skill> skillsAdded = new ArrayList<>();
        for (Collaborator c : collaboratorList) {
            List<Skill> cSkills = c.getSkillAssign();
            boolean collaboratorAdded = false;
            for (Skill cskill : cSkills) {
                if (skillsNeeded.contains(cskill)) {
                    if (!collaboratorAdded) {
                        collaboratorWithTheSkills.add(c);
                        collaboratorAdded = true;
                    }
                    skillsAdded.add(cskill);
                }
            }
            if (skillsAdded.containsAll(skillsNeeded)) {
                break;
            }
        }
        return collaboratorWithTheSkills;
    }

    /**
     * Validates the team size based on specified criteria.
     *
     * @param minSize         The minimum size of the team.
     * @param maxSize         The maximum size of the team.
     * @param requiredSkills  The list of required skills for the team.
     * @param collaboratorList The list of available collaborators.
     * @return true if the team meets the desired size and skill requirements, false otherwise.
     * @throws IllegalArgumentException if max is less than or equal to min.
     */
    public boolean teamValidations(int minSize, int maxSize, List<Skill> requiredSkills, List<Collaborator> collaboratorList) {
        int teamSize = seeColaboratorsWithSkillsNeeded(collaboratorList, requiredSkills).size();
        if (minSize > maxSize) {
            throw new IllegalArgumentException("Max must be greater than min.");
        } else if (teamSize > maxSize || teamSize < minSize) {
            throw new IllegalArgumentException("The team size does not meet the desired size.");
        }
        return true;
    }

    /**
     * Retrieves the list of collaborators in the team.
     *
     * @return The list of collaborators.
     */
    public List<Collaborator> getTeam() {
        return collaborators;
    }

    /**
     * Sets the list of collaborators in the team.
     *
     * @param team The list of collaborators to set.
     */
    public void setTeam(List<Collaborator> team) {
        this.collaborators = team;
    }

    /**
     * Creates a deep copy of the Team object.
     *
     * @return A deep copy of the Team object.
     */
    public Team clone() {
        return new Team(this.collaborators);
    }

    /**
     * Returns a string representation of the team.
     *
     * @return A string representation of the team.
     */
    @Override
    public String toString() {
        StringBuilder team = new StringBuilder();

        for (Collaborator member : this.collaborators) {
            team.append(member);
            team.append("\n");
        }

        return team.toString();
    }
}

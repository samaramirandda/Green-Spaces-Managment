package pprog.repository;

import pprog.domain.Collaborator;
import pprog.domain.Team;
import pprog.domain.Skill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing teams generated by the GenerateTeam class.
 */
public class TeamRepository implements Serializable {

    /**
     * List to store the generated teams.
     */
    private final List<Team> teamList;

    /**
     * Constructs a new GenerateTeamRepository with an empty list of teams.
     */
    public TeamRepository() {
        teamList = new ArrayList<>();
    }

    public Team getTeamByIndex(int index) {
        if (index < 1 || index > teamList.size()) {
            throw new IllegalArgumentException("Team not found.");
        }
        return teamList.get(index - 1);
    }

    /**
     * Generates a team based on the given criteria.
     *
     * @param minSize          The minimum size of the team.
     * @param maxSize          The maximum size of the team.
     * @param requiredSkills   The list of required skills for the team.
     * @param collaboratorList The list of available collaborators.
     * @return A list of collaborators forming the generated team.
     */
    public Team team(int minSize, int maxSize, List<Skill> requiredSkills, List<Collaborator> collaboratorList) {
        Team newTeam = null;
        Team team = new Team(Team.seeColaboratorsWithSkillsNeeded(collaboratorList, requiredSkills));

        if (team.teamValidations(minSize, maxSize, requiredSkills, collaboratorList)) {
            if (addTeam(team)) {
                newTeam = team;
            }
        }
        return newTeam;
    }

    /**
     * Adds a team to the repository if it passes validation.
     *
     * @param team The team to be added.
     * @return True if the team was added successfully, false otherwise.
     */
    private boolean addTeam(Team team) {
        if (validateTeam(team)) {
            teamList.add(team.clone());
            return true;
        } else {
            throw new IllegalArgumentException("Team already exists in the repository.");
        }
    }

    /**
     * Validates whether a team can be added to the repository.
     *
     * @param team The team to be validated.
     * @return True if the team is valid and can be added, false otherwise.
     */
    private boolean validateTeam(Team team) {
        return !teamList.contains(team);
    }

    /**
     * Retrieves the list of teams stored in this repository.
     *
     * @return The list of teams.
     */
    public List<Team> getTeamList() {
        return teamList;
    }

    /**
     * Returns a string representation of this GenerateTeamRepository.
     * @return A string representation containing all teams.
     */
    @Override
    public String toString() {
        return "Teams= " + teamList;
    }
}

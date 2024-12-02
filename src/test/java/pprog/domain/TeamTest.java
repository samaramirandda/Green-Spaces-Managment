package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamTest {

    @Test
    void seeCollaboratorsWithSkillsNeeded() {
        // Create some skills
        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Python");
        Skill skill3 = new Skill("SQL");

        // Create some collaborators with different sets of skills
        Collaborator collaborator1 = new Collaborator("John", null, null, new String[]{"123 Street", "12345", "City"}, 0, "john@this.app", 1, 0, null);
        collaborator1.getSkillAssign().add(skill1);
        collaborator1.getSkillAssign().add(skill2);

        Collaborator collaborator2 = new Collaborator("Alice", null, null, new String[]{"123 Street", "12345", "City"}, 0, "alice@this.app", 1, 0, null);
        collaborator2.getSkillAssign().add(skill2);

        Collaborator collaborator3 = new Collaborator("Bob", null, null, new String[]{"123 Street", "12345", "City"}, 0, "bob@this.app", 1, 0, null);
        collaborator3.getSkillAssign().add(skill1);
        collaborator3.getSkillAssign().add(skill3);

        // List of available collaborators
        List<Collaborator> collaboratorList = new ArrayList<>();
        collaboratorList.add(collaborator1);
        collaboratorList.add(collaborator2);
        collaboratorList.add(collaborator3);

        // Call the method to find collaborators with the necessary skills
        List<Collaborator> collaboratorsWithSkills = Team.seeColaboratorsWithSkillsNeeded(collaboratorList, List.of(skill1, skill3));

        // Verify the result
        assertEquals(2, collaboratorsWithSkills.size());
        assertTrue(collaboratorsWithSkills.contains(collaborator1));
        assertTrue(collaboratorsWithSkills.contains(collaborator3));
    }

    @Test
    void teamValidations() {
        // Create some skills
        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Python");
        Skill skill3 = new Skill("SQL");

        // Create some collaborators with different sets of skills
        Collaborator collaborator1 = new Collaborator("John", null, null, new String[]{"123 Street", "12345", "City"}, 0, "john@this.app", 1, 0, null);
        collaborator1.getSkillAssign().add(skill1);
        collaborator1.getSkillAssign().add(skill2);

        Collaborator collaborator2 = new Collaborator("Alice", null, null, new String[]{"123 Street", "12345", "City"}, 0, "alice@this.app", 1, 0, null);
        collaborator2.getSkillAssign().add(skill2);
        collaborator2.getSkillAssign().add(skill3);

        Collaborator collaborator3 = new Collaborator("Bob", null, null, new String[]{"123 Street", "12345", "City"}, 0, "bob@this.app", 1, 0, null);
        collaborator3.getSkillAssign().add(skill1);
        collaborator3.getSkillAssign().add(skill3);

        // List of available collaborators
        List<Collaborator> collaboratorList = new ArrayList<>();
        collaboratorList.add(collaborator1);
        collaboratorList.add(collaborator2);
        collaboratorList.add(collaborator3);

        // Create a Team object
        Team team = new Team(collaboratorList);

        // Define minSize and maxSize
        int minSize = 1;
        int maxSize = 3;

        // Define required skills
        List<Skill> requiredSkills = List.of(skill1, skill3);

        // Test team validation
        boolean isValid = team.teamValidations(minSize, maxSize, requiredSkills, collaboratorList);

        // Verify the result
        assertTrue(isValid);
    }

    @Test
    void testClone() {
        // Create some skills
        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Python");
        Skill skill3 = new Skill("SQL");

        // Create some collaborators with different sets of skills
        Collaborator collaborator1 = new Collaborator("John", null, null, new String[]{"123 Street", "12345", "City"}, 0, "john@this.app", 1, 0, null);
        collaborator1.getSkillAssign().add(skill1);
        collaborator1.getSkillAssign().add(skill2);

        Collaborator collaborator2 = new Collaborator("Alice", null, null, new String[]{"123 Street", "12345", "City"}, 0, "alice@this.app", 1, 0, null);
        collaborator2.getSkillAssign().add(skill2);
        collaborator2.getSkillAssign().add(skill3);

        Collaborator collaborator3 = new Collaborator("Bob", null, null, new String[]{"123 Street", "12345", "City"}, 0, "bob@this.app", 1, 0, null);
        collaborator3.getSkillAssign().add(skill1);
        collaborator3.getSkillAssign().add(skill3);

        // List of available collaborators
        List<Collaborator> collaboratorList = new ArrayList<>();
        collaboratorList.add(collaborator1);
        collaboratorList.add(collaborator2);
        collaboratorList.add(collaborator3);

        // Create a Team object
        Team team = new Team(collaboratorList);

        // Clone the Team object
        Team clonedTeam = team.clone();

        // Verify that the cloned team is a separate object
        assertEquals(team.getTeam(), clonedTeam.getTeam());
        assertEquals(team.toString(), clonedTeam.toString());
        assertTrue(team != clonedTeam);
    }
}

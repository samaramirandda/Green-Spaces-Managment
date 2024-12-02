package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Collaborator;
import pprog.domain.Skill;
import pprog.domain.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamRepositoryTest {

    @Test
    void team() {
        // Create skills
        Skill programmingSkill = new Skill("Programming");
        Skill designSkill = new Skill("Design");
        String[] address = new String[]{"123 Street", "12345", "City"};

        // Create collaborators with skills
        Collaborator john = new Collaborator("John", new Date(), new Date(), address, 123456789, "john@example.com", 1, 123456789, null);
        john.getSkillAssign().add(programmingSkill);

        Collaborator alice = new Collaborator("Alice", new Date(), new Date(), address, 987654321, "alice@example.com", 2, 987654321, null);
        alice.getSkillAssign().add(designSkill);

        Collaborator bob = new Collaborator("Bob", new Date(), new Date(), address, 555555555, "bob@example.com", 3, 555555555, null);
        bob.getSkillAssign().add(programmingSkill);
        bob.getSkillAssign().add(designSkill);

        // Add collaborators to the list
        List<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(john);
        collaborators.add(alice);
        collaborators.add(bob);

        // Create GenerateTeamRepository instance
        TeamRepository repository = new TeamRepository();

        // Generate a team
        Team generatedTeam = repository.team(1, 3, List.of(programmingSkill, designSkill), collaborators);

        // Assert that the generated team is not null and has at least one member
        assertNotNull(generatedTeam);
        assertFalse(generatedTeam.getTeam().isEmpty());
    }
}

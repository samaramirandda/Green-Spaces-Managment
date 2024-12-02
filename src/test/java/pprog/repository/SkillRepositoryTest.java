package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Skill;

import static org.junit.jupiter.api.Assertions.*;

class SkillRepositoryTest {

    @Test
    void getSkillByName() {
        // Arrange
        Skill javaSkill = new Skill("Java");
        SkillRepository repository = new SkillRepository();
        repository.addSkill(javaSkill);

        // Act
        Skill retrievedSkill = repository.getSkillByName("Java");

        // Assert
        assertNotNull(retrievedSkill);
        assertEquals("Java", retrievedSkill.getSkill());
    }

    @Test
    void addSkill() {
        // Arrange
        SkillRepository repository = new SkillRepository();
        Skill javaSkill = new Skill("Java");

        // Act
        boolean addedSuccessfully = repository.addSkill(javaSkill);

        // Assert
        assertTrue(addedSuccessfully);
        assertTrue(repository.getSkillsList().contains(javaSkill));
    }

    @Test
    void isSkillInList() {
        // Arrange
        Skill javaSkill = new Skill("Java");
        SkillRepository repository = new SkillRepository();
        repository.addSkill(javaSkill);

        // Act
        boolean isInList = repository.isSkillInList(javaSkill);
        Skill nonExistingSkill = new Skill("Python");
        boolean isNotInList = repository.isSkillInList(nonExistingSkill);

        // Assert
        assertTrue(isInList);
        assertFalse(isNotInList);
    }

    @Test
    void registerSkill() {
        // Arrange
        SkillRepository repository = new SkillRepository();

        // Act
        boolean addedSuccessfully = repository.registerSkill("Java");

        // Assert
        assertTrue(addedSuccessfully);
        assertTrue(repository.getSkillsList().stream().anyMatch(skill -> skill.getSkill().equals("Java")));
    }
}

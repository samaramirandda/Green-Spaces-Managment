package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkillTest {

    @Test
    void validateSkill() {
        // Test case: valid skill
        Skill skill1 = new Skill("Java Programming");
        assertTrue(skill1.validateSkill());

        // Test case: invalid skill (contains digits)
        Skill skill2 = new Skill("Python 3");
        assertFalse(skill2.validateSkill());

        // Test case: invalid skill (special characters)
        Skill skill3 = new Skill("C++");
        assertFalse(skill3.validateSkill());

        // Test case: invalid skill (empty)
        Skill skill4 = new Skill("");
        assertFalse(skill4.validateSkill());
    }

    @Test
    void testEquals() {
        // Test case: equal skills
        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Java");
        assertEquals(skill1, skill2);

        // Test case: different skills
        Skill skill3 = new Skill("Python");
        assertNotEquals(skill1, skill3);
    }

    @Test
    void testClone() {
        // Create an instance of Skill
        Skill originalSkill = new Skill("Java");

        // Clone the instance
        Skill clonedSkill = originalSkill.clone();

        // Verify if the values were copied correctly
        assertEquals(originalSkill.getSkill(), clonedSkill.getSkill());
        assertNotSame(originalSkill, clonedSkill);
    }
}

package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanResourcesManagerTest {

    @Test
    void testEquals() {

        HumanResourcesManager hrm1 = new HumanResourcesManager("hrm@example.com");
        HumanResourcesManager hrm2 = new HumanResourcesManager("hrm@example.com");

        assertEquals(hrm1, hrm2);
    }
}

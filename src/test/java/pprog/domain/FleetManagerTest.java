package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FleetManagerTest {

    @Test
    void testEquals() {
        FleetManager fleetManager1 = new FleetManager("fleetmanager@example.com");
        FleetManager fleetManager2 = new FleetManager("fleetmanager@example.com");

        assertEquals(fleetManager1, fleetManager2);
    }
}

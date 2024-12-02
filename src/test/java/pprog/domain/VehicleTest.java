package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testEquals() {

        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 1200, 1500, 10000,
                new Date(), new Date(), 5000, "ABC1234", 121);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", 1100, 1400, 9000,
                new Date(), new Date(), 5000, "ABC1234", 121);

        assertEquals(vehicle1, vehicle2);

        vehicle2.setPlateNumber("DEF5678");

        assertNotEquals(vehicle1, vehicle2);
    }

}

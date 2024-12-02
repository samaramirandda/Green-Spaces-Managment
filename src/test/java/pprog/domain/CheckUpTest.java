package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CheckUpTest {

    @Test
    void testEquals() {
        // Create two CheckUp objects with the same attributes
        Date date = new Date();
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1500, 2000, 10000, new Date(), new Date(), 5000, "ABC123", 121);
        int kms = 10000;
        CheckUp checkUp1 = new CheckUp(date, vehicle, kms);
        CheckUp checkUp2 = new CheckUp(date, vehicle, kms);

        // Test if the two CheckUp objects are equal
        assertEquals(checkUp1, checkUp2);
    }

    @Test
    void testClone() {
        // Create a CheckUp object
        Date date = new Date();
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1500, 2000, 10000, new Date(), new Date(), 5000, "ABC123", 121);
        int kms = 10000;
        CheckUp originalCheckUp = new CheckUp(date, vehicle, kms);

        // Clone the CheckUp object
        CheckUp clonedCheckUp = originalCheckUp.clone();

        // Test if the cloned CheckUp object is equal to the original CheckUp object
        assertEquals(originalCheckUp, clonedCheckUp);

        // Test if the cloned CheckUp object is a separate instance
        assertNotSame(originalCheckUp, clonedCheckUp);
    }
}

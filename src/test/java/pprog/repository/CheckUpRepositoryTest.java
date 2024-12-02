package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.CheckUp;
import pprog.domain.Vehicle;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CheckUpRepositoryTest {

    @Test
    void registerCheckUp_validCheckUp_returnCheckUp() {
        // Arrange
        CheckUpRepository repository = new CheckUpRepository();
        Date date = new Date();
        Vehicle vehicle = new Vehicle("Brand", "Model", 1000, 2000, 0, new Date(), new Date(), 5000, "AB-12-CD", 121);
        int kms = 10000;

        // Act
        CheckUp result = repository.registerCheckUp(date, vehicle, kms);

        // Assert
        assertNotNull(result);
        assertEquals(date, result.getDate());
        assertEquals(vehicle, result.getVehicle());
        assertEquals(kms, result.getKMS());
        assertTrue(repository.getCheckUpList().contains(result));
    }
}

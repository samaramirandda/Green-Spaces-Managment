package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.CheckUp;
import pprog.domain.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleNeedingMaintenanceRepositoryTest {

    @Test
    void getVehiclesNeedingMaintenanceList() {
        // Arrange
        List<Vehicle> allVehicles = new ArrayList<>();
        List<CheckUp> allCheckUps = new ArrayList<>();

        // Create vehicles
        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 1500, 2000, 52000, new Date(), new Date(), 5000, "123ABC", 121);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", 1600, 2100, 64000, new Date(), new Date(), 6000, "456DEF", 212);
        Vehicle vehicle3 = new Vehicle("Ford", "Focus", 1700, 2200, 72000, new Date(), new Date(), 7000, "789GHI", 111);

        // Create check-ups
        CheckUp checkUp1 = new CheckUp(new Date(), vehicle1, 1000);
        CheckUp checkUp2 = new CheckUp(new Date(), vehicle2, 1000);
        CheckUp checkUp3 = new CheckUp(new Date(), vehicle3, 1000);

        // Add vehicles and check-ups to lists
        allVehicles.add(vehicle1);
        allVehicles.add(vehicle2);
        allVehicles.add(vehicle3);

        allCheckUps.add(checkUp1);
        allCheckUps.add(checkUp2);
        allCheckUps.add(checkUp3);

        // Create repository
        VehicleNeedingMaintenanceRepository repository = new VehicleNeedingMaintenanceRepository();

        // Act
        List<String> vehiclesNeedingMaintenanceList = repository.getVehiclesNeedingMaintenanceList(allVehicles, allCheckUps);

        // Assert
        assertNotNull(vehiclesNeedingMaintenanceList);
        assertFalse(vehiclesNeedingMaintenanceList.isEmpty());
        assertEquals(3, vehiclesNeedingMaintenanceList.size());
    }
}

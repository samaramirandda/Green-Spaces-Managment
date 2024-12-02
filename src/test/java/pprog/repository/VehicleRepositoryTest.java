package pprog.repository;

import pprog.domain.Vehicle;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryTest {

    @Test
    void registerVehicle() {

        VehicleRepository vehicleRepository = new VehicleRepository();

        String plateNumber = "ABC1234";
        String brand = "Toyota";
        String model = "Corolla";
        int tare = 1500;
        int grossWeight = 2000;
        int currentKm = 50000;
        Date registerDate = new Date();
        Date acquisitionDate = new Date();
        int maintenanceCheckUpFrequency = 10000;
        int type = 121;

        Vehicle registeredVehicle = vehicleRepository.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);

        assertNotNull(registeredVehicle);
        assertEquals(plateNumber, registeredVehicle.getPlateNumber());

        List<Vehicle> vehiclesList = vehicleRepository.getVehiclesList();

        assertTrue(vehiclesList.contains(registeredVehicle));

        assertThrows(IllegalArgumentException.class, () -> {
            vehicleRepository.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
        });
    }

    @Test
    void getVehicleByPlateNumber() {

        VehicleRepository vehicleRepository = new VehicleRepository();
        String plateNumber = "DEF5678";
        String brand = "Honda";
        String model = "Civic";
        int tare = 1450;
        int grossWeight = 1950;
        int currentKm = 60000;
        Date registerDate = new Date();
        Date acquisitionDate = new Date();
        int maintenanceCheckUpFrequency = 12000;
        int type = 121;

        vehicleRepository.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);

        Vehicle retrievedVehicle = vehicleRepository.getVehicleByPlateNumber(plateNumber);

        assertNotNull(retrievedVehicle);
        assertEquals(brand, retrievedVehicle.getBrand());
        assertEquals(model, retrievedVehicle.getModel());
        assertEquals(tare, retrievedVehicle.getTare());
        assertEquals(grossWeight, retrievedVehicle.getGrossWeight());
        assertEquals(currentKm, retrievedVehicle.getCurrentKm());
        assertEquals(registerDate, retrievedVehicle.getRegisterDate());
        assertEquals(acquisitionDate, retrievedVehicle.getAcquisitionDate());
        assertEquals(maintenanceCheckUpFrequency, retrievedVehicle.getMaintenanceCheckUpFrequency());
        assertEquals(plateNumber, retrievedVehicle.getPlateNumber());
    }
}

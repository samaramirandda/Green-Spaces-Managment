# US006 - Register a vehicle 

## 4. Tests 

**Test 1:** Check if the vehicle is being registered correctly, being stored in the repository and if it is not possible to register an already registered collaborator - AC01/AC09.

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
        VehicleType type = new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.LIGHT, VehicleType.Transport.OPEN_BOX);

        Vehicle registeredVehicle = vehicleRepository.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);

        assertNotNull(registeredVehicle);
        assertEquals(plateNumber, registeredVehicle.getPlateNumber());

        List<Vehicle> vehiclesList = vehicleRepository.getVehiclesList();

        assertTrue(vehiclesList.contains(registeredVehicle));

        assertThrows(IllegalArgumentException.class, () -> {
            vehicleRepository.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
        });
    }
	

**Test 2:** Check that the vehicle is identified by its plate number and that it is not possible for there to be vehicles with the same plate number - AC03/AC04. 

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
        VehicleType type = new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.LIGHT, VehicleType.Transport.OPEN_BOX);

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
        assertEquals(type, retrievedVehicle.getType());
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class RegisterVehicleController 

```java
    public Vehicle registerVehicle(String brand, String model, int tare, int grossWeight, int currentKm, Date registerDate, Date acquisitionDate, int maintenanceCheckUpFrequency, String plateNumber, VehicleType type) {
    return vehicleRepository.registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
}
```

### Class VehicleRepository

```java
    public Vehicle registerVehicle (String brand, String model, int tare, int grossWeight, int currentKm, Date registerDate, Date acquisitonDate, int maintenanceCheckUpFrequency, String idNumber, VehicleType type) {
    Vehicle newVehicle = null;
    Vehicle vehicle = new Vehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitonDate, maintenanceCheckUpFrequency, idNumber, type);
    if (addVehicle(vehicle)) {
        newVehicle = vehicle;
    }
    return newVehicle;
}
```


## 6. Integration and Demo 

* A new option on the VFM menu options was added.

* For demo purposes a vehicle are bootstrapped while system starts.


## 7. Observations

n/a
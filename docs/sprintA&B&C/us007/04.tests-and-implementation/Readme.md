# US007 - Register a Check-Up

## 4. Tests

**Test 1:** Check if the check-up is being registered correctly, being stored in the repository and if it is not possible to register an already registered check-up - AC01.

    @Test
    void registerCheckUp() {

        CheckUpRepository repository = new CheckUpRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1500, 2000, 50000, new Date(), new Date(), 10000, "ABC1234", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.LIGHT, VehicleType.Transport.OPEN_BOX));
        vehicleRepository.registerVehicle("Toyota", "Corolla", 1500, 2000, 50000, new Date(), new Date(), 10000, "ABC1234", new VehicleType(VehicleType.TypeTransport.PASSENGERS, VehicleType.PackageWeight.LIGHT, VehicleType.Transport.OPEN_BOX));

        CheckUp checkUp = new CheckUp(new Date(), vehicle, 55000);

        CheckUp registeredCheckUp = repository.registerCheckUp(checkUp.getDate(), checkUp.getVehicle(), checkUp.getKMS());

        assertNotNull(registeredCheckUp);
        assertEquals(checkUp, registeredCheckUp);

        List<CheckUp> checkUpsList = repository.getCheckUpList();

        assertTrue(checkUpsList.contains(registeredCheckUp));

        assertThrows(IllegalArgumentException.class, () ->
                repository.registerCheckUp(checkUp.getDate(), checkUp.getVehicle(), checkUp.getKMS()));
    }



## 5. Construction (Implementation)

### Class RegisterCheckUpController

```java
    public CheckUp registerCheckUp(Date date, String vehiclePlateNumber, int KMS) {
    Vehicle vehicle = getVehicleByPlateNumber(vehiclePlateNumber);
    return checkUpRepository.registerCheckUp(date, vehicle, KMS);
}

```

### Class CheckUpRepository

```java
    public CheckUp registerCheckUp(Date date, Vehicle vehicle, int KMS) {
    CheckUp newCheckUp = null;
    CheckUp checkUp = new CheckUp(date, vehicle, KMS);

    if (addCheckUp(checkUp)) {
        newCheckUp = checkUp;
    }
    return newCheckUp;
}

```


## 6. Integration and Demo 

* A new option on the VFM menu options was added.

* For demo purposes a check-up is bootstrapped while system starts.


## 7. Observations

n/a
# US026 - Assign Vehicles to an entry in the Agenda

## 4. Tests 

**Test 1:** Check if the vehicles is being assigned correctly.

    @Test
    void assignVehicles() {

        Vehicle vehicle1 = new Vehicle("Brand", "Model", 1000, 2000, 50000, new Date(), new Date(), 5000, "PlateNumber1", 1);
        Vehicle vehicle2 = new Vehicle("Brand", "Model", 1000, 2000, 50000, new Date(), new Date(), 5000, "PlateNumber2", 1);

        Task task = new Task("Task", "Description", 1, 2, 1, new GreenSpace("Park", new String[]{"123 Green St", "City", "Country"}, 1, 1000.0, new GreenSpacesManager("email@this.app")));
        Entry entry = new Entry(new Date(), task);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        entry.assignVehicles(vehicles);

        assertEquals(vehicles, entry.getVehiclesAssign());
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class AssignVehiclesController 

```java
    public String assignVehiclesToEntry(int agendaIndex, List<String> vehiclesPlateNumbers) {
    List<Vehicle> vehiclesToAdd = new ArrayList<>();
    try {
        for (String vehiclePlateNumber : vehiclesPlateNumbers) {
            vehiclesToAdd.add(getVehicleByPlateNumber(vehiclePlateNumber.trim()));
        }
        getEntryByIndex(agendaIndex).assignVehicles(vehiclesToAdd);
        return null;
    } catch (IllegalArgumentException e) {
        return e.getMessage();
    }
}
```

### Class Entry

```java
    public void assignVehicles(List<Vehicle> vehiclesToAdd) throws IllegalArgumentException {
    boolean allVehiclesAvailable = true;
    for (Vehicle vehicle : vehiclesToAdd) {
        if (this.vehiclesAssign.contains(vehicle)) {
            throw new IllegalArgumentException("The vehicle you are trying to assign was already assigned!");
        }
        if (vehicle.isOccupiedVehicle()) {
            allVehiclesAvailable = false;
            break;
        }
    }

    if (allVehiclesAvailable) {
        for (Vehicle vehicle : vehiclesToAdd) {
            this.vehiclesAssign.add(vehicle);
            vehicle.setOccupiedVehicle(true);
        }
    } else {
        throw new IllegalArgumentException("Vehicle you are trying to assign is busy!");
    }
}
```


## 6. Integration and Demo 

* A new option on the Employee menu options was added.

* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a
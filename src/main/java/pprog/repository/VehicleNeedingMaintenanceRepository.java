package pprog.repository;

import pprog.domain.CheckUp;
import pprog.domain.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to manage vehicles needing maintenance.
 * This repository handles the retrieval of vehicles requiring maintenance based on their check-up history and maintenance frequency.
 */
public class VehicleNeedingMaintenanceRepository implements Serializable {
    /**
     * List to store vehicles needing maintenance.
     */
    private final List<String> vehiclesNeedingMaintenanceList;

    /**
     * Constructs a new VehicleNeedingMaintenanceRepository with an empty list of vehicles needing maintenance.
     */
    public VehicleNeedingMaintenanceRepository() {
        vehiclesNeedingMaintenanceList = new ArrayList<>();
    }

    /**
     * Retrieves the list of vehicles needing maintenance based on all vehicles and their check-ups.
     *
     * @param allVehicles the list of all vehicles
     * @param allCheckUps the list of all check-ups
     * @return the list of vehicles needing maintenance
     */
    public List<String> getVehiclesNeedingMaintenanceList(List<Vehicle> allVehicles, List<CheckUp> allCheckUps) {
        vehiclesNeedingMaintenanceList.clear();

        for (Vehicle vehicle : allVehicles) {
            if (needsCheckUp(vehicle, allCheckUps)) {
                int nextCheckUpKms = getLastCheckUpKms(vehicle, allCheckUps) + vehicle.getMaintenanceCheckUpFrequency();

                String line = String.format("%-15s%-15s%-15s%-10d%-10d%-10d%-10d\n",
                        vehicle.getPlateNumber(), vehicle.getBrand(), vehicle.getModel(), vehicle.getCurrentKm(), vehicle.getMaintenanceCheckUpFrequency(), getLastCheckUpKms(vehicle, allCheckUps), nextCheckUpKms);

                vehiclesNeedingMaintenanceList.add(line);
            }
        }

        return vehiclesNeedingMaintenanceList;
    }

    /**
     * Checks if a vehicle needs maintenance based on its check-up history and maintenance frequency.
     *
     * @param vehicle    the vehicle to check
     * @param allCheckUps the list of all check-ups
     * @return true if the vehicle needs maintenance, false otherwise
     */
    private boolean needsCheckUp(Vehicle vehicle, List<CheckUp> allCheckUps) {
        int lastCheckUpKms = getLastCheckUpKms(vehicle, allCheckUps);
        int maintenanceCheckUpFrequency = vehicle.getMaintenanceCheckUpFrequency();
        int currentKms = vehicle.getCurrentKm();
        int nextCheckUpKms = lastCheckUpKms + maintenanceCheckUpFrequency;

        return currentKms >= nextCheckUpKms;
    }

    /**
     * Retrieves the last check-up kilometers for a specific vehicle.
     *
     * @param vehicle    the vehicle to retrieve the last check-up kilometers for
     * @param allCheckUps the list of all check-ups
     * @return the last check-up kilometers for the vehicle
     */
    private int getLastCheckUpKms(Vehicle vehicle, List<CheckUp> allCheckUps) {
        int lastCheckUpKms = 0;
        for (CheckUp checkUp : allCheckUps) {
            if (checkUp.getVehicle().equals(vehicle)) {
                if (checkUp.getKMS() > lastCheckUpKms) {
                    lastCheckUpKms = checkUp.getKMS();
                }
            }
        }
        return lastCheckUpKms;
    }

    /**
     * Provides a string representation of the VehicleNeedingMaintenanceRepository.
     *
     * @return A string representation of the VehicleNeedingMaintenanceRepository.
     */
    @Override
    public String toString() {
        return "Vehicles Needing Maintenance = " + vehiclesNeedingMaintenanceList+'}';
    }

}
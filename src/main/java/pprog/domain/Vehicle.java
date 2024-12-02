package pprog.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Represents a vehicle.
 */
public class Vehicle implements Serializable {

    /**
     * The brand of the vehicle.
     */
    private String brand;

    /**
     * The model of the vehicle.
     */
    private String model;

    /**
     * The tare weight of the vehicle.
     */
    private int tare;

    /**
     * The gross weight of the vehicle.
     */
    private int grossWeight;

    /**
     * The current kilometers of the vehicle.
     */
    private int currentKm;

    /**
     * The date when the vehicle was registered.
     */
    private Date registerDate;

    /**
     * The date when the vehicle was acquired.
     */
    private Date acquisitionDate;

    /**
     * The frequency of maintenance check-ups for the vehicle.
     */
    private int maintenanceCheckUpFrequency;

    /**
     * The plate number of the vehicle.
     */
    private String plateNumber;

    /**
     * The type of the vehicle.
     */
    private VehicleType type;

    private boolean occupiedVehicle;

    /**
     * Constructs a new Vehicle object.
     *
     * @param brand The brand of the vehicle.
     * @param model The model of the vehicle.
     * @param tare The tare weight of the vehicle.
     * @param grossWeight The gross weight of the vehicle.
     * @param currentKm The current kilometers of the vehicle.
     * @param registerDate The date when the vehicle was registered.
     * @param acquisitionDate The date when the vehicle was acquired.
     * @param maintenanceCheckUpFrequency The frequency of maintenance check-ups.
     * @param plateNumber The plate number of the vehicle.
     * @param vehicleTypeValue The type of the vehicle.
     */
    public Vehicle(String brand, String model, int tare, int grossWeight, int currentKm, Date registerDate, Date acquisitionDate, int maintenanceCheckUpFrequency, String plateNumber, int vehicleTypeValue) {
        this.brand = brand;
        this.model = model;
        this.tare = tare;
        this.grossWeight = grossWeight;
        this.currentKm = currentKm;
        this.registerDate = registerDate;
        this.acquisitionDate = acquisitionDate;
        this.maintenanceCheckUpFrequency = maintenanceCheckUpFrequency;
        this.plateNumber = plateNumber;
        this.type = new VehicleType(vehicleTypeValue);
        this.occupiedVehicle = false;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two vehicles are considered equal if they have the same plate number.
     *
     * @param outroObjeto The reference object with which to compare.
     * @return True if this vehicle is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Vehicle outroVehicle = (Vehicle) outroObjeto;
        return plateNumber.equalsIgnoreCase(outroVehicle.plateNumber);
    }

    /**
     * Gets the brand of the vehicle.
     * @return The brand of the vehicle.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the vehicle.
     * @param brand The brand to set.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the model of the vehicle.
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the vehicle.
     * @param model The model to set.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the tare weight of the vehicle.
     * @return The tare weight of the vehicle.
     */
    public int getTare() {
        return tare;
    }

    /**
     * Sets the tare weight of the vehicle.
     * @param tare The tare weight to set.
     */
    public void setTare(int tare) {
        this.tare = tare;
    }

    /**
     * Gets the gross weight of the vehicle.
     * @return The gross weight of the vehicle.
     */
    public int getGrossWeight() {
        return grossWeight;
    }

    /**
     * Sets the gross weight of the vehicle.
     * @param grossWeight The gross weight to set.
     */
    public void setGrossWeight(int grossWeight) {
        this.grossWeight = grossWeight;
    }

    /**
     * Gets the current kilometers of the vehicle.
     * @return The current kilometers of the vehicle.
     */
    public int getCurrentKm() {
        return currentKm;
    }

    /**
     * Sets the current kilometers of the vehicle.
     * @param currentKm The current kilometers to set.
     */
    public void setCurrentKm(int currentKm) {
        this.currentKm = currentKm;
    }

    /**
     * Gets the registration date of the vehicle.
     * @return The registration date of the vehicle.
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * Sets the registration date of the vehicle.
     * @param registerDate The registration date to set.
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * Gets the acquisition date of the vehicle.
     * @return The acquisition date of the vehicle.
     */
    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    /**
     * Sets the acquisition date of the vehicle.
     * @param acquisitionDate The acquisition date to set.
     */
    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    /**
     * Gets the maintenance check-up frequency of the vehicle.
     * @return The maintenance check-up frequency of the vehicle.
     */
    public int getMaintenanceCheckUpFrequency() {
        return maintenanceCheckUpFrequency;
    }

    /**
     * Sets the maintenance check-up frequency of the vehicle.
     * @param maintenanceCheckUpFrequency The maintenance check-up frequency to set.
     */
    public void setMaintenanceCheckUpFrequency(int maintenanceCheckUpFrequency) {
        this.maintenanceCheckUpFrequency = maintenanceCheckUpFrequency;
    }

    /**
     * Gets the plate number of the vehicle.
     * @return The plate number of the vehicle.
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Sets the plate number of the vehicle.
     * @param plateNumber The plate number to set.
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * Gets the type of the vehicle.
     * @return The type of the vehicle.
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * Sets the type of the vehicle.
     * @param type The type to set.
     */
    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean isOccupiedVehicle() {
        return occupiedVehicle;
    }

    public void setOccupiedVehicle(boolean occupiedVehicle) {
        this.occupiedVehicle = occupiedVehicle;
    }

    /**
     * Returns a string representation of the vehicle.
     * @return A string representation of the vehicle.
     */
    @Override
    public String toString() {
        return String.format("Brand: %s\nModel: %s\nTare: %d\nGross Weight: %d\nCurrent Km: %d\nRegister Date: %s\nAcquisition Date: %s\nMaintenance CheckUp Frequency: %d\nPlate Number: %s\n%s",
                brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, type);
    }
}


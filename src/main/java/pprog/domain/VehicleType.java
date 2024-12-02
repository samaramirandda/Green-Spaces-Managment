package pprog.domain;

import java.io.Serializable;

/**
 * Represents the type of a vehicle.
 */
public class VehicleType implements Serializable {

    /**
     * Enum representing types of transport.
     */
    public enum TypeTransport {

        /** Passengers. */
        PASSENGERS,

        /** Mixed. */
        MIXED;

        /**
         * Overrides the toString method to provide a formatted string representation.
         * @return The formatted string representation of the enum.
         */
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }

    /**
     * Enum representing package weight.
     */
    public enum PackageWeight {
        LIGHT, HEAVY;

        /**
         * Overrides the toString method to provide a formatted string representation.
         * @return The formatted string representation of the enum.
         */
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }

    /**
     * Enum representing types of transport.
     */
    public enum Transport {
        OPEN_BOX, CLOSED_VANS, TRUCKS;

        /**
         * Overrides the toString method to provide a formatted string representation.
         * @return The formatted string representation of the enum.
         */
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
    }

    /**
     * The type of transport associated with the package.
     */
    private TypeTransport typeTransport;

    /**
     * The weight category of the package.
     */
    private PackageWeight packageWeight;

    /**
     * The transport information for the package.
     */
    private Transport transport;


    /**
     * Constructs a VehicleType object from a single integer value representing the vehicle type.
     *
     * @param vehicleTypeValue The integer value representing the vehicle type.
     */
    public VehicleType(int vehicleTypeValue) {
        int typeTransportValue = vehicleTypeValue / 100;
        int packageWeightValue = (vehicleTypeValue % 100) / 10;
        int transportValue = vehicleTypeValue % 10;

        this.typeTransport = getTypeTransportFromInt(typeTransportValue);
        this.packageWeight = getPackageWeightFromInt(packageWeightValue);
        this.transport = getTransportFromInt(transportValue);
    }

    /**
     * Converts an integer to TypeTransport enum.
     *
     * @param value The integer value to convert.
     * @return The corresponding TypeTransport enum.
     */
    private TypeTransport getTypeTransportFromInt(int value) {
        switch (value) {
            case 1:
                return TypeTransport.PASSENGERS;
            case 2:
                return TypeTransport.MIXED;
        }
        return null;
    }

    /**
     * Converts an integer to PackageWeight enum.
     *
     * @param value The integer value to convert.
     * @return The corresponding PackageWeight enum.
     */
    private PackageWeight getPackageWeightFromInt(int value) {
        switch (value) {
            case 1:
                return PackageWeight.LIGHT;
            case 2:
                return PackageWeight.HEAVY;
        }
        return null;
    }

    /**
     * Converts an integer to Transport enum.
     *
     * @param value The integer value to convert.
     * @return The corresponding Transport enum.
     */
    private Transport getTransportFromInt(int value) {
        switch (value) {
            case 1:
                return Transport.OPEN_BOX;
            case 2:
                return Transport.CLOSED_VANS;
            case 3:
                return Transport.TRUCKS;
        }
        return null;
    }

    /**
     * Gets the type of transport.
     * @return The type of transport.
     */
    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    /**
     * Sets the type of transport.
     * @param typeTransport The type of transport to set.
     */
    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    /**
     * Gets the package weight.
     * @return The package weight.
     */
    public PackageWeight getPackageWeight() {
        return packageWeight;
    }

    /**
     * Sets the package weight.
     * @param packageWeight The package weight to set.
     */
    public void setPackageWeight(PackageWeight packageWeight) {
        this.packageWeight = packageWeight;
    }

    /**
     * Gets the transport type.
     * @return The transport type.
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * Sets the transport type.
     * @param transport The transport type to set.
     */
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    /**
     * Overrides the toString method to provide a formatted string representation.
     * @return The formatted string representation of the VehicleType object.
     */
    @Override
    public String toString() {
        return String.format("Type Transport: %s\nPackage Weight: %s\nTransport: %s",
                typeTransport, packageWeight, transport);
    }
}


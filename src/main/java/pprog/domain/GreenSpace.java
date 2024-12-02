package pprog.domain;

import java.io.Serializable;

/**
 * Represents a green space.
 */
public class GreenSpace implements Serializable {

    /**
     * The name of the green space.
     */
    private String name;

    /**
     * The address of the green space.
     */
    private Address address;

    /**
     * The type of the green space.
     */
    private GreenSpaceType type;

    /**
     * The area of the green space.
     */
    private double area;

    /**
     * The manager of the green space.
     */
    private GreenSpacesManager greenSpacesManager;

    /**
     * Constructs a GreenSpace object.
     *
     * @param name              the name of the green space
     * @param address           the address of the green space
     * @param type              the type of the green space
     * @param area              the area of the green space
     * @param greenSpacesManager the manager of the green space
     */
    public GreenSpace(String name, String[] address, int type, double area, GreenSpacesManager greenSpacesManager) {
        this.name = name;
        this.address = new Address(address);
        this.type = GreenSpaceType.fromInt(type);
        this.area = area;
        this.greenSpacesManager = greenSpacesManager;
    }

    /**
     * Compares this green space with the specified object for equality.
     *
     * @param outroObjeto The object to be compared for equality with this green space.
     * @return True if the specified object is equal to this green space, false otherwise.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        GreenSpace outroGreenSpace = (GreenSpace) outroObjeto;
        return name.equalsIgnoreCase(outroGreenSpace.name);
    }

    /**
     * Retrieves the name of the green space.
     *
     * @return The name of the green space.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the green space.
     *
     * @param name The name to be set for the green space.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the address of the green space.
     *
     * @return The address of the green space.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the green space.
     *
     * @param address The address to be set for the green space.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Retrieves the type of the green space.
     *
     * @return The type of the green space.
     */
    public GreenSpaceType getType() {
        return type;
    }

    /**
     * Sets the type of the green space.
     *
     * @param type The type to be set for the green space.
     */
    public void setType(GreenSpaceType type) {
        this.type = type;
    }

    /**
     * Retrieves the area of the green space.
     *
     * @return The area of the green space.
     */
    public double getArea() {
        return area;
    }

    /**
     * Sets the area of the green space.
     *
     * @param area The area to be set for the green space.
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Retrieves the manager of the green space.
     *
     * @return The manager of the green space.
     */
    public GreenSpacesManager getGreenSpacesManager() {
        return greenSpacesManager;
    }

    /**
     * Sets the manager of the green space.
     *
     * @param greenSpacesManager The manager to be set for the green space.
     */
    public void setGreenSpacesManager(GreenSpacesManager greenSpacesManager) {
        this.greenSpacesManager = greenSpacesManager;
    }

    /**
     * Returns a string representation of the green space.
     *
     * @return A string representation of the green space.
     */
    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nType: %s\nArea: %.2f\nManaged by: %s\n", name, address, type, area, greenSpacesManager);
    }

}

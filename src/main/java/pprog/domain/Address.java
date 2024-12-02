package pprog.domain;

import java.io.Serializable;

/**
 * Class representing an address with street, zipcode, and city.
 */
public class Address implements Serializable {

    /**
     * The street of the address.
     */
    private String street;

    /**
     * The zipcode of the address.
     */
    private String zipcode;

    /**
     * The city of the address.
     */
    private String city;

    /**
     * Constructs an Address object with the specified details.
     *
     * @param addressArray an array containing the street, zipcode, and city.
     */
    public Address(String[] addressArray) {
        this.street = addressArray[0];
        this.zipcode = addressArray[1];
        this.city = addressArray[2];
    }

    /**
     * Gets the street of the address.
     *
     * @return the street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Gets the zipcode of the address.
     *
     * @return the zipcode of the address.
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Gets the city of the address.
     *
     * @return the city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the street of the address.
     *
     * @param street the new street of the address.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Sets the zipcode of the address.
     *
     * @param zipcode the new zipcode of the address.
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Sets the city of the address.
     *
     * @param city the new city of the address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns a string representation of the address.
     *
     * @return a string representation of the address in the format "street, zipcode, city".
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s", street, zipcode, city);
    }
}

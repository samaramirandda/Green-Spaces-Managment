package pprog.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Represents a vehicle check-up.
 */
public class CheckUp implements Serializable {

    /** The vehicle associated with the check-up. */
    private Vehicle vehicle;

    /** The date of the check-up. */
    private Date date;

    /** The kilometers covered by the vehicle at the time of the check-up. */
    private int KMS;

    /**
     * Constructs a new CheckUp object.
     *
     * @param date   The date of the check-up.
     * @param vehicle The vehicle associated with the check-up.
     * @param KMS    The kilometers covered by the vehicle at the time of the check-up.
     */
    public CheckUp(Date date, Vehicle vehicle, int KMS) {
        this.date = date;
        this.vehicle = vehicle;
        this.KMS = KMS;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (! ( o instanceof CheckUp))) return false;
        CheckUp checkUp = (CheckUp) o;
        return Double.compare(KMS, checkUp.KMS) == 0 && Objects.equals(vehicle, checkUp.vehicle) && Objects.equals(date, checkUp.date);
    }

    /**
     * Gets the vehicle associated with the check-up.
     *
     * @return The vehicle associated with the check-up.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets the vehicle associated with the check-up.
     *
     * @param vehicle The vehicle associated with the check-up.
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Gets the date of the check-up.
     *
     * @return The date of the check-up.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the check-up.
     *
     * @param date The date of the check-up.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the kilometers covered by the vehicle at the time of the check-up.
     *
     * @return The kilometers covered.
     */
    public int getKMS() {
        return KMS;
    }

    /**
     * Sets the kilometers covered by the vehicle at the time of the check-up.
     *
     * @param KMS The kilometers covered.
     */
    public void setKMS(int KMS) {
        this.KMS = KMS;
    }

    /**
     * Clones the check-up.
     *
     * @return A new CheckUp object with the same attributes as this one.
     */
    public CheckUp clone() {
        return new CheckUp(this.date, this.vehicle, this.KMS);
    }

    /**
     * Returns a string representation of the CheckUp object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return date + " " + vehicle + " " + KMS;
    }
}

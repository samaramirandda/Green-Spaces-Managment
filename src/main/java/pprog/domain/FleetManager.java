package pprog.domain;

import java.io.Serializable;

/**
 * Represents a fleet manager.
 */
public class FleetManager implements Serializable {

    /**
     * The email address of the fleet manager.
     */
    private final String email;

    /**
     * Constructs a FleetManager with the specified email.
     *
     * @param email the email of the fleet manager
     */
    public FleetManager(String email) {
        this.email = email;
    }

    /**
     * Checks if this FleetManager is equal to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FleetManager fm = (FleetManager) o;
        return email.equals(fm.email);
    }

    /**
     * Gets the email of the fleet manager.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public FleetManager clone() {
        return new FleetManager(this.email);
    }

    /**
     * Returns a string representation of the fleet manager.
     *
     * @return A string representation containing the name of the fleet manager.
     */
    @Override
    public String toString() {
        return String.format("Fleet Manager: %s\n", email);
    }
}

package pprog.domain;

import java.io.Serializable;

/**
 * Represents a human resources manager.
 */
public class HumanResourcesManager implements Serializable {

    /**
     * The email address of the human resources manager.
     */
    private final String email;

    /**
     * Constructs a HumanResourcesManager object with the specified email address.
     *
     * @param email The email address of the human resources manager.
     */
    public HumanResourcesManager(String email) {
        this.email = email;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return True if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HumanResourcesManager hrm = (HumanResourcesManager) o;
        return email.equals(hrm.email);
    }

    /**
     * Retrieves the email address of the human resources manager.
     *
     * @return The email address of the human resources manager.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return A clone of the current instance.
     */
    public HumanResourcesManager clone() {
        return new HumanResourcesManager(this.email);
    }

    /**
     * Returns a string representation of the human resources manager.
     * @return A string representation containing the name of the human resources manager.
     */
    @Override
    public String toString() {
        return String.format("Human Resources Manager: %s\n", email);
    }
}

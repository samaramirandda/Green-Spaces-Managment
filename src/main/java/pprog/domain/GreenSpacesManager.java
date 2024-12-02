package pprog.domain;

import java.io.Serializable;

/**
 * Represents a green spaces manager.
 */
public class GreenSpacesManager implements Serializable {

    /**
     * The email address of the green spaces manager.
     */
    private final String email;


    /**
     * Constructs a GreenSpacesManager object with the specified email address.
     *
     * @param email The email address of the green spaces manager.
     */
    public GreenSpacesManager(String email) {
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
        GreenSpacesManager gsm = (GreenSpacesManager) o;
        return email.equals(gsm.email);
    }


    /**
     * Retrieves the email address of the green spaces manager.
     *
     * @return The email address of the green spaces manager.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a string representation of the email address of the green spaces manager.
     *
     * @return A string representation of the email address of the green spaces manager.
     */
    @Override
    public String toString() {
        return email;
    }

}

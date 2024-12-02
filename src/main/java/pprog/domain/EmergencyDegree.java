package pprog.domain;

import java.io.Serializable;

/**
 * Enum representing the degree of emergency.
 */
public enum EmergencyDegree implements Serializable {

    /** High. */
    HIGH,

    /** Medium. */
    MEDIUM,

    /** Low. */
    LOW;

    /**
     * Returns the EmergencyDegree corresponding to the given integer value.
     *
     * @param value the integer value representing the emergency degree (1 for HIGH, 2 for MEDIUM, 3 for LOW)
     * @return the corresponding EmergencyDegree, or null if the value is invalid
     */
    public static EmergencyDegree fromInt(int value) {
        switch (value) {
            case 1:
                return HIGH;
            case 2:
                return MEDIUM;
            case 3:
                return LOW;
            default:
                return null;
        }
    }

    /**
     * Returns a string representation of the EmergencyDegree.
     *
     * @return a string representing the EmergencyDegree in a human-readable format
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}

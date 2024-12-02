package pprog.domain;

import java.io.Serializable;

/**
 * Represents the type of a green space.
 */
public enum GreenSpaceType implements Serializable {

    /** Garden. */
    GARDEN,

    /** Medium Sized Park. */
    MEDIUM_SIZED_PARK,

    /** Large Sized Park. */
    LARGE_SIZED_PARK;

    /**
     * Converts an integer value to a GreenSpaceType enum.
     *
     * @param value the integer value representing the green space type
     * @return the corresponding GreenSpaceType enum
     */
    public static GreenSpaceType fromInt(int value) {
        switch (value) {
            case 1:
                return GARDEN;
            case 2:
                return MEDIUM_SIZED_PARK;
            case 3:
                return LARGE_SIZED_PARK;
        }
        return null;
    }

    /**
     * Returns a string representation of the GreenSpaceType.
     *
     * @return a string representation of the GreenSpaceType
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}

package pprog.domain;

import java.io.Serializable;

/**
 * Enum representing different types of identification documents.
 */
public enum IdDocType implements Serializable {
    /** Taxpayer number. */
    TAXPAYER_NUMBER,

    /** Citizen card. */
    CITIZEN_CARD,

    /** Passport. */
    PASSPORT;

    /**
     * Converts an integer value to its corresponding IdDocType enum value.
     *
     * @param value the integer value representing the IdDocType
     * @return the corresponding IdDocType enum value, or null if no match is found
     */
    public static IdDocType fromInt(int value) {
        switch (value) {
            case 1:
                return TAXPAYER_NUMBER;
            case 2:
                return CITIZEN_CARD;
            case 3:
                return PASSPORT;
        }
        return null;
    }

    /**
     * Returns a string representation of the identification document type.
     * The first letter is capitalized, and underscores are replaced with spaces.
     *
     * @return The string representation of the identification document type.
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}




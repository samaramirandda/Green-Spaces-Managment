package pprog.domain;

import java.io.Serializable;

/**
 * Enumeration representing the status of an agenda entry.
 */
public enum AgendaStatus implements Serializable {

    /**
     * The agenda entry is planned.
     */
    PLANNED,

    /**
     * The agenda entry is postponed.
     */
    POSTPONED,

    /**
     * The agenda entry is canceled.
     */
    CANCELED,

    /**
     * The agenda entry is done.
     */
    DONE;

    /**
     * Returns a string representation of the enum value.
     *
     * @return A string representation of the enum value with the first letter capitalized and underscores replaced by spaces.
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}

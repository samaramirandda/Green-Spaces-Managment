package pprog.domain;

import java.io.Serializable;

/**
 * Represents the type of a task.
 */
public enum TaskType implements Serializable {

    /** Regular. */
    REGULAR,

    /** Occasional. */
    OCCASIONAL;

    /**
     * Converts an integer value to the corresponding TaskType enum.
     *
     * @param value the integer value to convert
     * @return the TaskType enum corresponding to the value
     */
    public static TaskType fromInt(int value) {
        switch (value) {
            case 1:
                return REGULAR;
            case 2:
                return OCCASIONAL;
        }
        return null;
    }

    /**
     * Returns a string representation of the task type.
     *
     * @return a string representation of the task type
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}

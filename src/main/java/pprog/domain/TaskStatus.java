package pprog.domain;

import java.io.Serializable;

/**
 * Represents the status of a task.
 */
public enum TaskStatus implements Serializable {

    /**
     * The task status is pending.
     */
    PENDING,

    /**
     * The task status is processed.
     */
    PROCESSED;

    /**
     * Returns a string representation of the task status.
     *
     * @return a string representation of the task status
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}

package pprog.domain;

import java.io.Serializable;

/**
 * Represents a job with a name and description.
 */
public class Job implements Serializable {

    /** The name of the job. */
    private String name;

    /** The description of the job. */
    private String description;

    /**
     * Constructs a job with the given name and description.
     *
     * @param name The name of the job.
     * @param description The description of the job.
     */
    public Job(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Checks if this job is equal to another object.
     *
     * @param outroObjeto The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Job outroJob = (Job) outroObjeto;
        return name.equalsIgnoreCase(outroJob.name);
    }

    /**
     * Gets the name of the job.
     * @return The name of the job.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the job.
     * @return The description of the job.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the name of the job.
     * @param name The new name of the job.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the job.
     * @param description The new description of the job.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Creates a copy of this job.
     * @return A new Job object with the same name and description.
     */
    public Job clone() {
        return new Job(this.name, this.description);
    }

    /**
     * Returns a string representation of this job.
     * @return The name of the job.
     */
    @Override
    public String toString() {
        return String.format(name);
    }

}

package pprog.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a collaborator.
 */
public class Collaborator implements Serializable {

    /** The name of the collaborator. */
    private String name;

    /** The birthday of the collaborator. */
    private Date birthday;

    /** The admission date of the collaborator. */
    private Date admissionDate;

    /** The address of the collaborator. */
    private Address address;

    /** The phone number of the collaborator. */
    private int phoneNumber;

    /** The email of the collaborator. */
    private String email;

    /** The identification document type of the collaborator. */
    private IdDocType idDocType;

    /** The identification number of the collaborator. */
    private int idNumber;

    /** The job of the collaborator. */
    private Job job;

    /** The list of skills assigned to the collaborator. */
    private List<Skill> skillAssign;

    /**
     * Constructs a new Collaborator object with the specified attributes.
     *
     * @param name          The name of the collaborator.
     * @param birthday      The birthday of the collaborator.
     * @param admissionDate The admission date of the collaborator.
     * @param address       The address of the collaborator.
     * @param phoneNumber   The phone number of the collaborator.
     * @param email         The email of the collaborator.
     * @param idDocTypeInt     The identification document type of the collaborator.
     * @param idNumber      The identification number of the collaborator.
     * @param job           The job of the collaborator.
     */
    public Collaborator(String name, Date birthday, Date admissionDate, String[] address, int phoneNumber, String email, int idDocTypeInt, int idNumber, Job job) {
        this.name = name;
        this.birthday = birthday;
        this.admissionDate = admissionDate;
        this.address = new Address(address);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idDocType = IdDocType.fromInt(idDocTypeInt);
        this.idNumber = idNumber;
        this.job = job;
        this.skillAssign = new ArrayList<>();
    }

    /**
     * Validates if the collaborator's birthday is over 18 years old.
     *
     * @return true if the collaborator is over 18 years old, false otherwise.
     */
    public boolean validateBirthdayIsOver18() {
        long diffMillis = this.admissionDate.getTime() - this.birthday.getTime();
        long ageInMillis = 18L * 365 * 24 * 60 * 60 * 1000;
        return diffMillis > ageInMillis;
    }

    /**
     * Checks if this collaborator is equal to another object.
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
        Collaborator outroCollaborator = (Collaborator) outroObjeto;
        return email.equalsIgnoreCase(outroCollaborator.email);
    }

    /**
     * Gets the name of the collaborator.
     *
     * @return The name of the collaborator.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the collaborator.
     *
     * @param name The new name of the collaborator.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the birthday of the collaborator.
     *
     * @return The birthday of the collaborator.
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of the collaborator.
     *
     * @param birthday The new birthday of the collaborator.
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the admission date of the collaborator.
     *
     * @return The admission date of the collaborator.
     */
    public Date getAdmissionDate() {
        return admissionDate;
    }

    /**
     * Sets the admission date of the collaborator.
     *
     * @param admissionDate The new admission date of the collaborator.
     */
    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * Gets the address of the collaborator.
     *
     * @return The address of the collaborator.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the collaborator.
     *
     * @param address The new address of the collaborator.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    /**
     * Gets the phone number of the collaborator.
     *
     * @return The phone number of the collaborator.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the collaborator.
     *
     * @param phoneNumber The new phone number of the collaborator.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email of the collaborator.
     *
     * @return The email of the collaborator.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the collaborator.
     *
     * @param email The new email of the collaborator.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the identification document type of the collaborator.
     *
     * @return The identification document type of the collaborator.
     */
    public IdDocType getIdDocType() {
        return idDocType;
    }

    /**
     * Sets the identification document type of the collaborator.
     *
     * @param idDocType The new identification document type of the collaborator.
     */
    public void setIdDocType(IdDocType idDocType) {
        this.idDocType = idDocType;
    }

    /**
     * Gets the identification number of the collaborator.
     *
     * @return The identification number of the collaborator.
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the identification number of the collaborator.
     *
     * @param idNumber The new identification number of the collaborator.
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Gets the job of the collaborator.
     *
     * @return The job of the collaborator.
     */
    public Job getJob() {
        return job;
    }

    /**
     * Sets the job of the collaborator.
     *
     * @param job The new job of the collaborator.
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * Gets the list of skills assigned to the collaborator.
     *
     * @return The list of skills assigned to the collaborator.
     */
    public List<Skill> getSkillAssign() {
        return skillAssign;
    }

    /**
     * Sets the list of skills assigned to the collaborator.
     *
     * @param skillToAdd The new job of the collaborator.
     */
    public void assignSkills(List<Skill> skillToAdd) {
        for (Skill skill : skillToAdd) {
            if (this.skillAssign.contains(skill)) {
                throw new IllegalArgumentException("The skill you are trying to assign was already assigned!");
            }
        }
        this.skillAssign.addAll(skillToAdd);
    }

    /**
     * Returns a string representation of the Collaborator.
     *
     * @return A string representation of the Collaborator.
     */
    @Override
    public String toString() {
        return String.format("Name: %s, Email: %s", name, email);
    }

}
package pprog.repository;

import pprog.domain.CheckUp;
import pprog.domain.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Repository class to manage check-ups.
 */
public class CheckUpRepository implements Serializable {

    /**
     * List to store check-ups.
     */
    private final List<CheckUp> checkUpList;

    /**
     * Constructs a new CheckUpRepository with an empty list of check-ups.
     */
    public CheckUpRepository() {
        checkUpList = new ArrayList<>();
    }

    /**
     * Registers a new check-up.
     *
     * @param date The date of the check-up.
     * @param vehicle The vehicle being checked up.
     * @param KMS The kilometers of the vehicle at the time of the check-up.
     * @return The registered check-up object, or null if registration fails.
     */
    public CheckUp registerCheckUp(Date date, Vehicle vehicle, int KMS) {
        CheckUp newCheckUp = null;
        CheckUp checkUp = new CheckUp(date, vehicle, KMS);

        if (addCheckUp(checkUp)) {
            newCheckUp = checkUp;
        }
        return newCheckUp;
    }

    /**
     * Adds a check-up to the repository if it's not already present.
     *
     * @param checkUp The check-up to add.
     * @return true if the check-up was successfully added, false if it already exists.
     * @throws IllegalArgumentException if the check-up already exists in the repository.
     */
    private boolean addCheckUp(CheckUp checkUp) {
        if (validateCheckUp(checkUp)) {
            checkUpList.add(checkUp.clone());
            return true;
        } else {
            throw new IllegalArgumentException("Check Up already exists in the repository.");
        }
    }

    /**
     * Validates if a check-up already exists in the repository.
     *
     * @param checkUp The check-up to validate.
     * @return true if the check-up is not already present, false otherwise.
     */
    private boolean validateCheckUp(CheckUp checkUp) {
        return !checkUpList.contains(checkUp);
    }

    /**
     * Retrieves the list of check-ups stored in the repository.
     *
     * @return The list of check-ups.
     */
    public List<CheckUp> getCheckUpList() {
        return checkUpList;
    }

    /**
     * Provides a string representation of the CheckUpRepository.
     *
     * @return A string representation of the CheckUpRepository.
     */
    @Override
    public String toString() {
        return "Check-ups=" + checkUpList + '}';
    }
}
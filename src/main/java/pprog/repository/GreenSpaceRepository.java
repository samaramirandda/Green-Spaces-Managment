package pprog.repository;

import pprog.interfaces.SortingAlgorithm;
import pprog.domain.GreenSpace;
import pprog.domain.GreenSpacesManager;
import pprog.session.ApplicationSession;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a repository for green spaces.
 */
public class GreenSpaceRepository implements Serializable {

    /**
     * The list of green spaces.
     */
    private final List<GreenSpace> greenSpacesList;

    /**
     * Constructs a GreenSpaceRepository object.
     */
    public GreenSpaceRepository() {
        greenSpacesList = new ArrayList<>();
    }

    /**
     * Registers a new green space.
     *
     * @param name               the name of the green space
     * @param address            the address of the green space
     * @param type               the type of the green space
     * @param area               the area of the green space
     * @param greenSpacesManager the manager of the green space
     * @return the newly registered green space
     */
    public GreenSpace registerGreenSpace (String name, String[] address, int type, double area, GreenSpacesManager greenSpacesManager) {
        GreenSpace newGreenSpace = null;
        GreenSpace greenSpace = new GreenSpace (name, address, type, area, greenSpacesManager);
        if (addGreenSpace(greenSpace)) {
            newGreenSpace = greenSpace;
        }
        return newGreenSpace;
    }

    /**
     * Adds a green space to the repository if it doesn't already exist.
     *
     * @param greenSpace the green space to add
     * @return true if the green space was successfully added, false otherwise
     * @throws IllegalArgumentException if the green space already exists in the repository
     */
    private boolean addGreenSpace (GreenSpace greenSpace) {
        if (validateGreenSpace(greenSpace)) {
            greenSpacesList.add(greenSpace);
            return true;
        } else {
            throw new IllegalArgumentException("Green space already exists in the repository");
        }
    }

    /**
     * Validates whether a green space already exists in the repository.
     *
     * @param greenSpace the green space to validate
     * @return true if the green space doesn't already exist in the repository, false otherwise
     */
    private boolean validateGreenSpace (GreenSpace greenSpace) {
        return !greenSpacesList.contains(greenSpace);
    }

    /**
     * Retrieves the list of green spaces.
     *
     * @return the list of green spaces
     */
    public List<GreenSpace> getGreenSpacesList() {
        return greenSpacesList;
    }

    /**
     * Retrieves a green space by name.
     *
     * @param name the name of the green space
     * @return the green space with the specified name
     * @throws IllegalArgumentException if the green space with the specified name doesn't exist
     */
    public GreenSpace getGreenSpaceByName(String name) {
        for (GreenSpace gs: greenSpacesList) {
            if (gs.getName().equalsIgnoreCase(name)) {
                return gs;
            }
        }
        throw new IllegalArgumentException("Green space with the name '" + name + "' doesn't exist.");
    }

    /**
     * Retrieves the list of green spaces managed by a specific green spaces manager.
     *
     * @param gsmFromSession the green spaces manager
     * @return the list of green spaces managed by the specified green spaces manager
     */
    public List<GreenSpace> getGreenSpaceListByGSM(GreenSpacesManager gsmFromSession) {
        List<GreenSpace> greenSpacesListByGSM = new ArrayList<>();

        for (GreenSpace gs: getGreenSpacesList()) {
            if (gs.getGreenSpacesManager().equals(gsmFromSession)) {
                greenSpacesListByGSM.add(gs);
            }
        }
        return greenSpacesListByGSM;
    }

    /**
     * Sorts the list of green spaces using a specific sorting algorithm.
     *
     * @param gsmFromSession the green spaces manager
     * @return the sorted list of green spaces managed by the specified green spaces manager
     * @throws RuntimeException if an error occurs while retrieving the sorting algorithm
     */
    public List<GreenSpace> sortListByAlgorithm(GreenSpacesManager gsmFromSession) {
        SortingAlgorithm algorithm;
        try {
            algorithm = ApplicationSession.getSortingAlgorithm();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        List<GreenSpace> sortedgreenSpacesListByGSM = getGreenSpaceListByGSM(gsmFromSession);
        algorithm.sort(sortedgreenSpacesListByGSM);
        return sortedgreenSpacesListByGSM;
    }

    /**
     * Returns a string representation of the GreenSpaceRepository.
     *
     * @return a string representation of the GreenSpaceRepository
     */
    @Override
    public String toString() {
        return greenSpacesList.toString();
    }
}


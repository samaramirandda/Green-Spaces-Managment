package pprog.interfaces;

import pprog.domain.GreenSpace;

import java.util.List;

/**
 * An interface representing a sorting algorithm for green spaces.
 */
public interface SortingAlgorithm {

    /**
     * Sorts a list of managed green spaces.
     *
     * @param managedGreenSpacesList The list of managed green spaces to be sorted.
     */
    void sort(List<GreenSpace> managedGreenSpacesList);

}

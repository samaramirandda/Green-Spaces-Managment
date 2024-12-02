package pprog.domain;

import pprog.interfaces.SortingAlgorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of a sorting algorithm that sorts a list of green spaces by their area in descending order.
 */
public class Algoritmo1 implements SortingAlgorithm {

    /**
     * Sorts the given list of managed green spaces.
     *
     * @param managedGreenSpacesList the list of green spaces to be sorted
     */
    @Override
    public void sort(List<GreenSpace> managedGreenSpacesList) {
        sortList(managedGreenSpacesList);
    }

    /**
     * Sorts the list of managed green spaces by their area in descending order.
     *
     * @param managedGreenSpacesList the list of green spaces to be sorted
     */
    private void sortList(List<GreenSpace> managedGreenSpacesList) {

        Comparator<GreenSpace> comparator = new Comparator<GreenSpace>() {
            @Override
            public int compare(GreenSpace gs1, GreenSpace gs2) {
                return Double.compare(gs2.getArea(), gs1.getArea());
            }
        };

        Collections.sort(managedGreenSpacesList, comparator);
    }
}

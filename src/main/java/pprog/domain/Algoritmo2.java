package pprog.domain;

import pprog.interfaces.SortingAlgorithm;

import java.util.List;

/**
 * Implementation of a sorting algorithm that sorts a list of green spaces by their area in descending order
 * using the bubble sort algorithm.
 */
public class Algoritmo2 implements SortingAlgorithm {

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
     * Sorts the list of managed green spaces by their area in descending order using the bubble sort algorithm.
     *
     * @param managedGreenSpacesList the list of green spaces to be sorted
     */
    private void sortList(List<GreenSpace> managedGreenSpacesList) {
        boolean swapped;

        for (int i = 0; i < managedGreenSpacesList.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < managedGreenSpacesList.size() - i - 1; j++) {
                if (managedGreenSpacesList.get(j).getArea() < managedGreenSpacesList.get(j + 1).getArea()) {
                    GreenSpace temp = managedGreenSpacesList.get(j);
                    managedGreenSpacesList.set(j, managedGreenSpacesList.get(j + 1));
                    managedGreenSpacesList.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}

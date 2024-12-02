package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Algoritmo1Test {

    @Test
    void sort() {
        GreenSpacesManager greenSpacesManager = new GreenSpacesManager("email@this.app");

        List<GreenSpace> greenSpaces = new ArrayList<>();
        greenSpaces.add(new GreenSpace("Park A", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, greenSpacesManager));
        greenSpaces.add(new GreenSpace("Park B", new String[]{"123 Street", "12345", "City"}, 1, 500.0, greenSpacesManager));
        greenSpaces.add(new GreenSpace("Park C", new String[]{"123 Street", "12345", "City"}, 1, 1500.0, greenSpacesManager));

        Algoritmo1 sortingAlgorithm = new Algoritmo1();

        sortingAlgorithm.sort(greenSpaces);

        assertEquals("Park C", greenSpaces.get(0).getName());
        assertEquals("Park A", greenSpaces.get(1).getName());
        assertEquals("Park B", greenSpaces.get(2).getName());
    }
}

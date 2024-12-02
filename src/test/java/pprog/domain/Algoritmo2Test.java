package pprog.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Algoritmo2Test {

    @Test
    void sort() {
        Algoritmo2 algoritmo2 = new Algoritmo2();

        List<GreenSpace> greenSpaces = new ArrayList<>();
        greenSpaces.add(new GreenSpace("Park", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, new GreenSpacesManager("gsm@this.app")));
        greenSpaces.add(new GreenSpace("Garden", new String[]{"123 Street", "12345", "City"}, 2, 500.0, new GreenSpacesManager("gsm@this.app")));
        greenSpaces.add(new GreenSpace("Square",new String[]{"123 Street", "12345", "City"}, 3, 2000.0, new GreenSpacesManager("gsm@this.app")));

        algoritmo2.sort(greenSpaces);

        for (int i = 0; i < greenSpaces.size() - 1; i++) {
            assertTrue(greenSpaces.get(i).getArea() >= greenSpaces.get(i + 1).getArea());
        }
    }
}

package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreenSpaceTest {

    @Test
    void testEquals() {

        GreenSpace greenSpace1 = new GreenSpace("Park", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, new GreenSpacesManager("gsm@this.app"));
        GreenSpace greenSpace2 = new GreenSpace("Park", new String[]{"123 Street", "12345", "City"}, 1, 2000.0, new GreenSpacesManager("gsm@this.app"));

        assertEquals(greenSpace1, greenSpace2);
    }
}

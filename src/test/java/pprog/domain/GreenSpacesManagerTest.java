package pprog.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreenSpacesManagerTest {

    @Test
    void testEquals() {

        GreenSpacesManager gsm1 = new GreenSpacesManager("gsm@example.com");
        GreenSpacesManager gsm2 = new GreenSpacesManager("gsm@example.com");

        assertEquals(gsm1, gsm2);
    }
}

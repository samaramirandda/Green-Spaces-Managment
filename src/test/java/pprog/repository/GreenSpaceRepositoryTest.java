package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.GreenSpace;
import pprog.domain.GreenSpacesManager;

import static org.junit.jupiter.api.Assertions.*;

class GreenSpaceRepositoryTest {

    @Test
    void registerGreenSpace() {
        GreenSpaceRepository repository = new GreenSpaceRepository();

        GreenSpace greenSpace = repository.registerGreenSpace("Park", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, new GreenSpacesManager("manager@example.com"));

        assertNotNull(greenSpace);
        assertEquals("Park", greenSpace.getName());
    }

    @Test
    void getGreenSpaceByName() {

        GreenSpaceRepository repository = new GreenSpaceRepository();

        repository.registerGreenSpace("Park", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, new GreenSpacesManager("manager@example.com"));

        GreenSpace greenSpace = repository.getGreenSpaceByName("Park");

        assertNotNull(greenSpace);
        assertEquals("Park", greenSpace.getName());
    }

    @Test
    void getGreenSpaceListByGSM() {
        GreenSpaceRepository repository = new GreenSpaceRepository();

        GreenSpacesManager greenSpacesManager = new GreenSpacesManager("manager@example.com");

        repository.registerGreenSpace("Park1", new String[]{"123 Street", "12345", "City"}, 1, 1000.0, greenSpacesManager);
        repository.registerGreenSpace("Park2", new String[]{"123 Street", "12345", "City"}, 1, 1500.0, greenSpacesManager);
        repository.registerGreenSpace("Park3", new String[]{"123 Street", "12345", "City"}, 1, 2000.0, greenSpacesManager);

        var greenSpacesList = repository.getGreenSpaceListByGSM(greenSpacesManager);

        assertEquals(3, greenSpacesList.size());
    }
}

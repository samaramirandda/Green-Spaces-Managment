package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Collaborator;
import pprog.domain.IdDocType;
import pprog.domain.Job;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorRepositoryTest {

    @Test
    void registerCollaborator() {

        CollaboratorRepository repository = new CollaboratorRepository();
        String[] address = new String[]{"123 Street", "12345", "City"};

        Collaborator collaborator = new Collaborator("Daniel Silva", new Date(90,5,31),
                new Date(), address, 123456789, "daniel.silva@example.com", 3, 123456, new Job("Software Engineer", "Developing software applications"));

        Collaborator registeredCollaborator = repository.registerCollaborator(collaborator.getName(), collaborator.getBirthday(),
                collaborator.getAdmissionDate(), address, collaborator.getPhoneNumber(),
                collaborator.getEmail(), IdDocType.PASSPORT.ordinal(), collaborator.getIdNumber(), collaborator.getJob());

        assertNotNull(registeredCollaborator);
        assertEquals(collaborator, registeredCollaborator);

        List<Collaborator> collaboratorsList = repository.getCollaboratorsList();

        assertTrue(collaboratorsList.contains(registeredCollaborator));

        assertThrows(IllegalArgumentException.class, () ->
                repository.registerCollaborator(collaborator.getName(), collaborator.getBirthday(),
                        collaborator.getAdmissionDate(), address, collaborator.getPhoneNumber(),
                        collaborator.getEmail(), IdDocType.PASSPORT.ordinal(), collaborator.getIdNumber(), collaborator.getJob()));
    }


    @Test
    void getCollaboratorByName() {
        CollaboratorRepository repository = new CollaboratorRepository();
        String[] address = new String[]{"123 Street", "12345", "City"};

        Collaborator collaborator1 = new Collaborator("John Doe", new Date(90, 5, 31),
                new Date(), address, 123456789, "john.doe@example.com", IdDocType.PASSPORT.ordinal(), 123456, new Job("Engineer", "Developing"));
        Collaborator collaborator2 = new Collaborator("Jane Smith", new Date(92, 8, 15),
                new Date(), address, 987654321, "jane.smith@example.com", IdDocType.PASSPORT.ordinal(), 654321, new Job("Designer", "Designing"));

        repository.registerCollaborator(collaborator1.getName(), collaborator1.getBirthday(),
                collaborator1.getAdmissionDate(), address, collaborator1.getPhoneNumber(),
                collaborator1.getEmail(), IdDocType.PASSPORT.ordinal(), collaborator1.getIdNumber(), collaborator1.getJob());
        repository.registerCollaborator(collaborator2.getName(), collaborator2.getBirthday(),
                collaborator2.getAdmissionDate(), address, collaborator2.getPhoneNumber(),
                collaborator2.getEmail(), IdDocType.PASSPORT.ordinal(), collaborator2.getIdNumber(), collaborator2.getJob());

        Collaborator retrievedCollaborator = repository.getCollaboratorByName("John Doe");
        assertNotNull(retrievedCollaborator);
        assertEquals(collaborator1, retrievedCollaborator);

        assertThrows(IllegalArgumentException.class, () -> repository.getCollaboratorByName("Non Existing Name"));
    }

}

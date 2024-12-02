package pprog.repository;

import org.junit.jupiter.api.Test;
import pprog.domain.Agenda;
import pprog.domain.ToDoList;

import static org.junit.jupiter.api.Assertions.*;

class RepositoriesTest {

    @Test
    void getInstance() {

        Repositories repositories1 = Repositories.getInstance();
        Repositories repositories2 = Repositories.getInstance();

        assertNotNull(repositories1);
        assertNotNull(repositories2);
        assertSame(repositories1, repositories2);
    }

    @Test
    void getCollaboratorRepository() {

        Repositories repositories = Repositories.getInstance();

        CollaboratorRepository collaboratorRepository = repositories.getCollaboratorRepository();

        assertNotNull(collaboratorRepository);
    }

    @Test
    void getJobRepository() {

        Repositories repositories = Repositories.getInstance();

        JobRepository jobRepository = repositories.getJobRepository();

        assertNotNull(jobRepository);
    }

    @Test
    void getVehicleRepository() {

        Repositories repositories = Repositories.getInstance();

        VehicleRepository vehicleRepository = repositories.getVehicleRepository();

        assertNotNull(vehicleRepository);
    }

    @Test
    void getSkillRepository() {

        Repositories repositories = Repositories.getInstance();

        SkillRepository skillRepository = repositories.getSkillRepository();

        assertNotNull(skillRepository);
    }

    @Test
    void getCheckUpRepository() {

        Repositories repositories = Repositories.getInstance();

        CheckUpRepository checkUpRepository = repositories.getCheckUpRepository();

        assertNotNull(checkUpRepository);
    }

    @Test
    void getGenerateTeamRepository() {

        Repositories repositories = Repositories.getInstance();

        TeamRepository generateTeamRepository = repositories.getTeamRepository();

        assertNotNull(generateTeamRepository);
    }

    @Test
    void getVehicleNeedingMaintenanceRepository() {

        Repositories repositories = Repositories.getInstance();

        VehicleNeedingMaintenanceRepository vehicleNeedingMaintenanceRepository = repositories.getVehicleNeedingMaintenanceRepository();

        assertNotNull(vehicleNeedingMaintenanceRepository);
    }

    @Test
    void getAuthenticationRepository() {

        Repositories repositories = Repositories.getInstance();

        AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();

        assertNotNull(authenticationRepository);
    }

    @Test
    void getAgenda() {
        Repositories repositories = Repositories.getInstance();
        Agenda agenda = repositories.getAgenda();
        assertNotNull(agenda);
    }

    @Test
    void getToDoList() {
        Repositories repositories = Repositories.getInstance();
        ToDoList toDoList = repositories.getToDoList();
        assertNotNull(toDoList);
    }

    @Test
    void getGreenSpaceRepository() {
        Repositories repositories = Repositories.getInstance();
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();
        assertNotNull(greenSpaceRepository);
    }
}

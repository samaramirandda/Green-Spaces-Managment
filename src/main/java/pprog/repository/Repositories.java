package pprog.repository;

import pprog.domain.Agenda;
import pprog.domain.ToDoList;

import java.io.*;

/**
 * This class manages singleton instances of repositories.
 */
public class Repositories implements Serializable {

    /** The singleton instance of Repositories. */
    private static Repositories instance;

    /** The repository for collaborators. */
    private CollaboratorRepository collaboratorRepository;

    /** The repository for jobs. */
    private JobRepository jobRepository;

    /** The repository for vehicles. */
    private VehicleRepository vehicleRepository;

    /** The repository for skills. */
    private SkillRepository skillRepository;

    /** The repository for check-ups. */
    private CheckUpRepository checkUpRepository;

    /** The repository for teams. */
    private TeamRepository teamRepository;

    /** The repository for vehicles needing maintenance. */
    private VehicleNeedingMaintenanceRepository vehicleNeedingMaintenanceRepository;

    /** The repository for authentication. */
    private transient AuthenticationRepository authenticationRepository;

    private Agenda agenda;
    private ToDoList toDoList;
    private GreenSpaceRepository greenSpaceRepository;

    /**
     * Constructs a new Repositories object, initializing all repositories.
     */
    private Repositories() {
        collaboratorRepository = new CollaboratorRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
        skillRepository = new SkillRepository();
        checkUpRepository = new CheckUpRepository();
        teamRepository = new TeamRepository();
        vehicleNeedingMaintenanceRepository = new VehicleNeedingMaintenanceRepository();
        authenticationRepository = new AuthenticationRepository();
        agenda = new Agenda();
        toDoList = new ToDoList();
        greenSpaceRepository = new GreenSpaceRepository();
    }

    /**
     * Returns the singleton instance of Repositories, creating it if necessary.
     * @return The singleton instance of Repositories.
     */
    public static Repositories getInstance() {
        if (instance == null) {
            synchronized (Repositories.class) {
                if (instance == null) {
                    instance = new Repositories();
                }
            }
        }
        return instance;
    }

    /**
     * Gets the repository for collaborators.
     * @return The CollaboratorRepository.
     */
    public CollaboratorRepository getCollaboratorRepository() {
        return collaboratorRepository;
    }

    /**
     * Gets the repository for jobs.
     * @return The JobRepository.
     */
    public JobRepository getJobRepository() {
        return jobRepository;
    }

    /**
     * Gets the repository for vehicles.
     * @return The VehicleRepository.
     */
    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    /**
     * Gets the repository for skills.
     * @return The SkillRepository.
     */
    public SkillRepository getSkillRepository() {
        return skillRepository;
    }

    /**
     * Gets the repository for check-ups.
     * @return The CheckUpRepository.
     */
    public CheckUpRepository getCheckUpRepository(){ return checkUpRepository; }

    /**
     * Gets the repository for teams.
     * @return The GenerateTeamRepository.
     */
    public TeamRepository getTeamRepository() { return teamRepository; }

    /**
     * Gets the repository for vehicles needing maintenance.
     * @return The VehicleNeedingMaintenanceRepository.
     */
    public VehicleNeedingMaintenanceRepository getVehicleNeedingMaintenanceRepository() {
        return vehicleNeedingMaintenanceRepository;
    }

    /**
     * Gets the repository for authentication.
     * @return The AuthenticationRepository.
     */
    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public GreenSpaceRepository getGreenSpaceRepository() {
        return greenSpaceRepository;
    }

    public void saveSystemStateToBinary(File file){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(instance);
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadSystemStateFromBinary(File file){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            Repositories repObject = (Repositories) in.readObject();
            collaboratorRepository = repObject.getCollaboratorRepository();
            jobRepository = repObject.getJobRepository();
            vehicleRepository = repObject.getVehicleRepository();
            skillRepository = repObject.getSkillRepository();
            checkUpRepository = repObject.getCheckUpRepository();
            teamRepository = repObject.getTeamRepository();
            vehicleNeedingMaintenanceRepository = repObject.getVehicleNeedingMaintenanceRepository();
            greenSpaceRepository = repObject.getGreenSpaceRepository();
            toDoList = repObject.getToDoList();
            agenda = repObject.getAgenda();

            in.close();
            fileInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearData() {
        collaboratorRepository = new CollaboratorRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
        skillRepository = new SkillRepository();
        checkUpRepository = new CheckUpRepository();
        teamRepository = new TeamRepository();
        vehicleNeedingMaintenanceRepository = new VehicleNeedingMaintenanceRepository();
        authenticationRepository = new AuthenticationRepository();
        agenda = new Agenda();
        toDoList = new ToDoList();
        greenSpaceRepository = new GreenSpaceRepository();
    }

    @Override
    public String toString() {
        return "Repositories{" + skillRepository + collaboratorRepository + jobRepository + checkUpRepository + teamRepository + vehicleNeedingMaintenanceRepository + vehicleRepository + greenSpaceRepository + toDoList + agenda;
    }

}


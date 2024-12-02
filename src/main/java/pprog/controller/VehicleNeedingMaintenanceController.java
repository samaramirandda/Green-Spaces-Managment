package pprog.controller;

import pprog.repository.CheckUpRepository;
import pprog.repository.Repositories;
import pprog.repository.VehicleNeedingMaintenanceRepository;
import pprog.repository.VehicleRepository;

import java.util.List;

/**
 * Controller class responsible for managing vehicles needing maintenance.
 */
public class VehicleNeedingMaintenanceController {


    /**
     * The vehicle needing maintenance repository instance.
     */
    private VehicleNeedingMaintenanceRepository vehicleNeedingMaintenanceRepository;


    /**
     * The check-up repository instance.
     */
    private CheckUpRepository checkUpRepository;


    /**
     * The vehicle repository instance.
     */
    private VehicleRepository vehicleRepository;

    /**
     * Default constructor. Retrieves the necessary repositories.
     */
    public VehicleNeedingMaintenanceController() {
        getCheckUpRepository();
        getVehicleRepository();
        getVehicleNeedingMaintenanceRepository();
    }

    /**
     * Constructor to set specific repositories.
     * @param vehicleNeedingMaintenanceRepository The repository for vehicles needing maintenance.
     * @param checkUpRepository The check-up repository.
     * @param vehicleRepository The vehicle repository.
     */
    public VehicleNeedingMaintenanceController(VehicleNeedingMaintenanceRepository vehicleNeedingMaintenanceRepository, CheckUpRepository checkUpRepository, VehicleRepository vehicleRepository) {
        this.vehicleNeedingMaintenanceRepository = vehicleNeedingMaintenanceRepository;
        this.checkUpRepository = checkUpRepository;
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Retrieves the repository for vehicles needing maintenance.
     * If not initialized, retrieves it from Repositories.
     * @return The repository for vehicles needing maintenance.
     */
    public VehicleNeedingMaintenanceRepository getVehicleNeedingMaintenanceRepository() {
        if (vehicleNeedingMaintenanceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleNeedingMaintenanceRepository = repositories.getVehicleNeedingMaintenanceRepository();
        }
        return vehicleNeedingMaintenanceRepository;
    }

    /**
     * Retrieves the check-up repository.
     * If not initialized, retrieves it from Repositories.
     * @return The check-up repository.
     */
    private CheckUpRepository getCheckUpRepository() {
        if (checkUpRepository == null) {
            Repositories repositories = Repositories.getInstance();
            checkUpRepository = repositories.getCheckUpRepository();
        }
        return checkUpRepository;
    }

    /**
     * Retrieves the vehicle repository.
     * If not initialized, retrieves it from Repositories.
     * @return The vehicle repository.
     */
    private VehicleRepository getVehicleRepository () {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    /**
     * Retrieves the list of vehicles needing maintenance.
     * @return The list of vehicles needing maintenance.
     */
    public List<String> getVehiclesNeedingMaintenanceList() {
        return getVehicleNeedingMaintenanceRepository().getVehiclesNeedingMaintenanceList(getVehicleRepository().getVehiclesList(), getCheckUpRepository().getCheckUpList());
    }

}

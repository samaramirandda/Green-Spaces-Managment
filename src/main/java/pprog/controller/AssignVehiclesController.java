package pprog.controller;

import pprog.domain.Entry;
import pprog.domain.Vehicle;
import pprog.domain.Agenda;
import pprog.repository.Repositories;
import pprog.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for assigning vehicles to entries in the agenda.
 */
public class AssignVehiclesController {

    /**
     * The agenda instance.
     */
    private Agenda agenda;

    /**
     * The vehicle repository instance.
     */
    private VehicleRepository vehicleRepository;

    /**
     * Constructs a new AssignVehiclesController and initializes the agenda and vehicle repository.
     */
    public AssignVehiclesController () {
        getAgenda();
        getVehicleRepository();
    }

    /**
     * Constructs a new AssignVehiclesController with the specified agenda and vehicle repository.
     *
     * @param agenda           The agenda instance.
     * @param vehicleRepository The vehicle repository instance.
     */
    public AssignVehiclesController (Agenda agenda, VehicleRepository vehicleRepository) {
        this.agenda = agenda;
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Retrieves the agenda instance.
     *
     * @return The agenda instance.
     */
    private Agenda getAgenda() {
        if (agenda == null) {
            Repositories repositories = Repositories.getInstance();
            agenda = repositories.getAgenda();
        }
        return agenda;
    }

    /**
     * Retrieves the vehicle repository instance.
     *
     * @return The vehicle repository instance.
     */
    private VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    /**
     * Assigns vehicles to an entry in the agenda.
     *
     * @param agendaIndex        The index of the entry in the agenda.
     * @param vehiclesPlateNumbers The list of vehicle plate numbers to assign.
     * @return A message indicating the result of assigning the vehicles to the entry.
     */
    public String assignVehiclesToEntry(int agendaIndex, List<String> vehiclesPlateNumbers) {
        List<Vehicle> vehiclesToAdd = new ArrayList<>();
        try {
            for (String vehiclePlateNumber : vehiclesPlateNumbers) {
                vehiclesToAdd.add(getVehicleByPlateNumber(vehiclePlateNumber.trim()));
            }
            getEntryByIndex(agendaIndex).assignVehicles(vehiclesToAdd);
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Retrieves the entry from the agenda by its index.
     *
     * @param index The index of the entry.
     * @return The entry.
     */
    private Entry getEntryByIndex(int index) {
        return getAgenda().getEntryByIndex(index);
    }

    /**
     * Retrieves the vehicle from the vehicle repository by its plate number.
     *
     * @param vehiclePlateNumber The plate number of the vehicle.
     * @return The vehicle.
     */
    public Vehicle getVehicleByPlateNumber (String vehiclePlateNumber) {
        return getVehicleRepository().getVehicleByPlateNumber(vehiclePlateNumber);
    }

    /**
     * Retrieves the list of entries in the agenda.
     *
     * @return The list of entries.
     */
    public List<Entry> getEntriesList() {
        return getAgenda().getEntriesList();
    }

    /**
     * Retrieves the list of vehicles from the vehicle repository.
     *
     * @return The list of vehicles.
     */
    public List<Vehicle> getVehiclesList() {
        return getVehicleRepository().getVehiclesList();
    }

    /**
     * Retrieves the entry from the agenda with assigned vehicles by its index.
     *
     * @param index The index of the entry.
     * @return The entry with assigned vehicles.
     */
    public Entry getEntryWithVehicles(int index) {
        return getEntryByIndex(index);
    }

}

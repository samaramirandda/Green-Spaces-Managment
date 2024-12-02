package pprog.ui.console;

import pprog.controller.RegisterVehicleController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * User interface for registering a vehicle.
 */
public class RegisterVehicleUI implements Runnable {
    /**
     * The controller for registering vehicles.
     */
    private final RegisterVehicleController controller;

    /**
     * The brand of the vehicle.
     */
    private String brand;

    /**
     * The model of the vehicle.
     */
    private String model;

    /**
     * The tare weight of the vehicle.
     */
    private int tare;

    /**
     * The gross weight of the vehicle.
     */
    private int grossWeight;

    /**
     * The current kilometers of the vehicle.
     */
    private int currentKm;

    /**
     * The registration date of the vehicle.
     */
    private Date registerDate;

    /**
     * The acquisition date of the vehicle.
     */
    private Date acquisitionDate;

    /**
     * The maintenance check-up frequency of the vehicle.
     */
    private int maintenanceCheckUpFrequency;

    /**
     * The plate number of the vehicle.
     */
    private String plateNumber;

    /**
     * The type of the vehicle.
     */
    private int typeInput;

    /**
     * Constructs a RegisterVehicleUI with a new instance of RegisterVehicleController.
     */
    public RegisterVehicleUI() {
        controller = new RegisterVehicleController();
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    private RegisterVehicleController getController() {
        return controller;
    }

    /**
     * Runs the UI.
     */
    public void run() {
        System.out.println("\n\n--- Register a Vehicle ------------------------");

        requestData();
        submitData();

    }

    /**
     * Submits data to register the vehicle.
     */
    private void submitData() {

        if (getController().registerVehicle(brand, model, tare, grossWeight, currentKm, registerDate, acquisitionDate, maintenanceCheckUpFrequency, plateNumber, typeInput)) {
            System.out.println("\nVehicle successfully registed!");
        } else {
            System.out.println("Vehicle not registed!");
        }

    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        brand = requestBrand();
        model = requestModel();
        tare = requestTare();
        grossWeight = requestGrossWeight();
        currentKm = requestCurrentKm();
        registerDate = requestRegisterDate();
        acquisitionDate = requestAcquisitionDate();
        maintenanceCheckUpFrequency = requestMaintenanceCheckUpFrequency();
        plateNumber = requestPlateNumber();
        typeInput = requestVehicleType();

    }

    /**
     * Requests the brand of the vehicle from the user.
     *
     * @return the brand entered by the user
     */
    private String requestBrand() {
        Scanner input = new Scanner(System.in);
        System.out.print("Brand: ");
        return input.nextLine();
    }

    /**
     * Requests the model of the vehicle from the user.
     *
     * @return the model entered by the user
     */
    private String requestModel() {
        Scanner input = new Scanner(System.in);
        System.out.print("Model: ");
        return input.nextLine();
    }

    /**
     * Requests the tare of the vehicle from the user.
     *
     * @return the tare entered by the user
     */
    private int requestTare() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Tare: ");
                if (input.hasNextInt()) {
                    int tare = input.nextInt();
                    if (tare > 0) {
                        return tare;
                    } else {
                        throw new IllegalArgumentException("Please enter a non-negative number.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please enter numbers.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the gross weight of the vehicle from the user.
     *
     * @return the gross weight entered by the user
     */
    private int requestGrossWeight() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Gross Weight: ");
                if (input.hasNextInt()) {
                    int grossWeight = input.nextInt();
                    if (grossWeight > 0) {
                        return grossWeight;
                    } else {
                        throw new IllegalArgumentException("Please enter a non-negative number.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please enter numbers.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the current kilometers of the vehicle from the user.
     *
     * @return the current kilometers entered by the user
     */
    private int requestCurrentKm() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Current Km: ");
                if (input.hasNextInt()) {
                    int currentKm = input.nextInt();
                    if (currentKm > 0) {
                        return currentKm;
                    } else {
                        throw new IllegalArgumentException("Please enter a non-negative number.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please enter numbers.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the registration date of the vehicle from the user.
     *
     * @return the registration date entered by the user
     */
    private Date requestRegisterDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Register Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestRegisterDate();
        }
    }

    /**
     * Requests the acquisition date of the vehicle from the user.
     *
     * @return the acquisition date entered by the user
     */
    private Date requestAcquisitionDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Acquisition Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestAcquisitionDate();
        }
    }

    /**
     * Requests the maintenance check-up frequency of the vehicle from the user.
     *
     * @return the maintenance check-up frequency entered by the user
     */
    private int requestMaintenanceCheckUpFrequency() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Maintenance CheckUp Frequency: ");
                if (input.hasNextInt()) {
                    int maintenanceCheckUpFrequency = input.nextInt();
                    if (maintenanceCheckUpFrequency > 0) {
                        return maintenanceCheckUpFrequency;
                    } else {
                        throw new IllegalArgumentException("Please enter a non-negative number.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please enter numbers.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the plate number of the vehicle from the user.
     *
     * @return the plate number entered by the user
     */
    private String requestPlateNumber() {
        Scanner input = new Scanner(System.in);
        String plateNumber;
        do {
            System.out.print("Plate Number (format: XX XX XX): ");
            plateNumber = input.nextLine();
            if (!plateNumber.matches("[A-Z0-9]{2} [A-Z0-9]{2} [A-Z0-9]{2}")) {
                System.out.println("Please enter a plate number in the format XX XX XX.");
            }
        } while (!plateNumber.matches("[A-Z0-9]{2} [A-Z0-9]{2} [A-Z0-9]{2}"));
        return plateNumber;
    }

    /**
     * Requests the vehicle type from the user.
     *
     * @return the vehicle type entered by the user
     */
    private int requestVehicleType() {
        Scanner input = new Scanner(System.in);
        int typeTransportInput = 0;
        int packageWeightInput = 0;
        int transportInput = 0;

        while (true) {
            try {
                System.out.println("Vehicle Type:");
                System.out.println("- Type Transport");
                System.out.println("1. Passengers");
                System.out.println("2. Mixed");
                System.out.print("Please enter a number (1 or 2): ");
                if (input.hasNextInt()) {
                    typeTransportInput = input.nextInt();
                    if (typeTransportInput >= 1 && typeTransportInput <= 2) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("- Package Weight");
                System.out.println("1. Light");
                System.out.println("2. Heavy");
                System.out.print("Please enter a number (1 or 2): ");
                if (input.hasNextInt()) {
                    packageWeightInput = input.nextInt();
                    if (packageWeightInput >= 1 && packageWeightInput <= 2) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1 or 2).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("- Transport");
                System.out.println("1. Open Box");
                System.out.println("2. Closed Vans");
                System.out.println("3. Trucks");
                System.out.print("Please enter a number (1, 2, or 3): ");
                if (input.hasNextInt()) {
                    transportInput = input.nextInt();
                    if (transportInput >= 1 && transportInput <= 3) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2, or 3).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2, or 3).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }

        return typeTransportInput * 100 + packageWeightInput * 10 + transportInput;
    }

}

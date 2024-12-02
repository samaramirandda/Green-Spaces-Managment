package pprog.ui.console;

import pprog.controller.RegisterGreenSpaceController;

import java.util.Scanner;

/**
 * Represents the user interface for registering a green space.
 */
public class RegisterGreenSpaceUI implements Runnable {

    private final RegisterGreenSpaceController controller;
    private String name;
    private String[] address;
    private int type;
    private double area;

    /**
     * Constructs a RegisterGreenSpaceUI object.
     */
    public RegisterGreenSpaceUI() {
        controller = new RegisterGreenSpaceController();
    }

    /**
     * Gets the controller associated with this UI.
     *
     * @return the RegisterGreenSpaceController instance
     */
    private RegisterGreenSpaceController getController() {
        return controller;
    }

    /**
     * Runs the UI, allowing the user to input and register a green space.
     */
    public void run() {
        System.out.println("\n\n--- Register a Green Space ------------------------");

        requestData();
        submitData();
    }

    /**
     * Submits the collected data to the controller to register the green space.
     */
    private void submitData() {
        String result = getController().registerGreenSpace(name, address, type, area);
        if (result == null) {
            System.out.println("\nGreen Space successfully registered!");
            System.out.println(controller.getGreenSpaceRegistered());
        } else {
            System.out.println("Green Space not registered!\n" + result);
        }
    }

    /**
     * Requests data from the user for the green space registration.
     */
    private void requestData() {
        name = requestName();
        address = requestAddress();
        type = requestType();
        area = requestArea();
    }

    /**
     * Requests the name of the green space from the user.
     *
     * @return the name of the green space
     */
    private String requestName() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Name: ");
                String name = input.nextLine().trim();
                if (name.matches("[a-zA-Z0-9\\s]+")) {
                    return name;
                } else {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Requests the address of the green space from the user.
     *
     * @return the address of the green space
     */
    private String[] requestAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Address:");
        String[] address = new String[3];

        while (true) {
            try {
                System.out.println("Street: ");
                String street = input.nextLine().trim();
                if (street.matches("[a-zA-Z0-9\\sà-ÿÀ-Ÿ]+")) {
                    address[0] = street;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid street. Please enter a valid street.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Zipcode: ");
                String zipcode = input.nextLine().trim();
                if (zipcode.matches("\\d{4}-\\d{3}")) {
                    address[1] = zipcode;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid zipcode format. Please enter a valid zipcode (format: xxxx-xxx).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("City: ");
                String city = input.nextLine().trim();
                if (city.matches("[a-zA-Z0-9\\s]+")) {
                    address[2] = city;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid city. Please enter a valid city.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return address;
    }

    /**
     * Requests the type of the green space from the user.
     *
     * @return the type of the green space
     */
    private int requestType() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the type of the green space (1: Garden, 2: Medium Sized Park, 3: Large Sized Park): ");
                if (input.hasNextInt()) {
                    int type = input.nextInt();
                    if (type > 0 && type < 4) {
                        return type;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2 or 3).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please choose a valid option (1, 2 or 3).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the area of the green space from the user.
     *
     * @return the area of the green space in square meters
     */
    private Double requestArea() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the area of the green space in square meters: ");
                if (input.hasNextDouble()) {
                    double area = input.nextDouble();
                    if (area > 0) {
                        return area;
                    } else {
                        throw new IllegalArgumentException("Invalid area. Please introduce a positive area.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid area. Please enter numbers.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }
}

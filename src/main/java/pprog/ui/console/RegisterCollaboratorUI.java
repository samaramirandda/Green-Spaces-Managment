package pprog.ui.console;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import pprog.controller.RegisterCollaboratorController;

/**
 * User interface for registering a collaborator.
 */
public class RegisterCollaboratorUI implements Runnable {

    /**
     * The controller for registering collaborators.
     */
    private final RegisterCollaboratorController controller;

    /**
     * The name of the collaborator.
     */
    private String name;

    /**
     * The birthday of the collaborator.
     */
    private Date birthday;

    /**
     * The admission date of the collaborator.
     */
    private Date admissionDate;

    /**
     * The address of the collaborator.
     */
    private String[] address;

    /**
     * The phone number of the collaborator.
     */
    private int phoneNumber;

    /**
     * The email of the collaborator.
     */
    private String email;

    /**
     * The type of ID document of the collaborator.
     */
    private int idDocType;

    /**
     * The ID number of the collaborator.
     */
    private int idNumber;

    /**
     * The job of the collaborator.
     */
    private String job;

    /**
     * Constructs a RegisterCollaboratorUI with a new instance of RegisterCollaboratorController.
     */
    public RegisterCollaboratorUI() {
        controller = new RegisterCollaboratorController();
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    private RegisterCollaboratorController getController() {
        return controller;
    }

    /**
     * Runs the UI.
     */
    public void run() {
        System.out.println("\n\n--- Register a Collaborator ------------------------");

        requestData();
        displayJobs();
        job = requestJobName();
        submitData();
    }

    /**
     * Submits data to register the collaborator.
     */
    private void submitData() {

        if (getController().registerCollaborator(name, birthday, admissionDate, address, phoneNumber, email, idDocType, idNumber, job)) {
            System.out.println("\nCollaborator successfully registed!");
        } else {
            System.out.println("Collaborator not registed!");
        }

    }

    /**
     * Requests data from the user.
     */
    private void requestData() {

        name = requestName();
        birthday = requestBirthday();
        admissionDate = requestAdmissionDate();
        address = requestAddress();
        phoneNumber = requestPhoneNumber();
        email = requestEmail();
        idDocType = requestIdDocType();
        idNumber = requestIdNumber(idDocType);

    }

    /**
     * Requests the name of the collaborator from the user.
     *
     * @return the name entered by the user
     */
    private String requestName() {
        Scanner input = new Scanner(System.in);
        String name;
        do {
            System.out.print("Name: ");
            name = input.nextLine().trim();
            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Please enter a valid name.");
            }
            if (name.split("\\s+").length > 6) {
                System.out.println("Invalid name. Please enter a valid name with at most 6 words.");
            }
        } while (!name.matches("[a-zA-Z ]+") || name.split("\\s+").length > 6);
        return name;
    }

    /**
     * Requests the birthday of the collaborator from the user.
     *
     * @return the birthday entered by the user
     */
    private Date requestBirthday() {
        Scanner input = new Scanner(System.in);
        System.out.print("Birthday (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestBirthday();
        }
    }

    /**
     * Requests the admission date of the collaborator from the user.
     *
     * @return the admission date entered by the user
     */
    private Date requestAdmissionDate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Admission Date (format: dd/MM/yyyy): ");
        String dateStr = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            return requestAdmissionDate();
        }
    }

    /**
     * Requests the address of the collaborator from the user.
     *
     * @return the address entered by the user
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
     * Requests the phone number of the collaborator from the user.
     *
     * @return the phone number entered by the user
     */
    private int requestPhoneNumber() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Phone Number: ");
                if (input.hasNextInt()) {
                    int phoneNumber = input.nextInt();
                    if (String.valueOf(phoneNumber).matches("\\d{9}")) {
                        return phoneNumber;
                    } else {
                        throw new IllegalArgumentException("Invalid phone number. Please enter a 9-digit number.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid phone number. Please enter a 9-digit number.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Requests the email of the collaborator from the user.
     *
     * @return the email entered by the user
     */
    private String requestEmail() {
        Scanner input = new Scanner(System.in);
        String email;
        do {
            System.out.print("Email: ");
            email = input.nextLine().trim();
            if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                System.out.println("Invalid email. Please enter a valid email.");
            }
        } while (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
        return email;
    }

    /**
     * Requests the type of ID document of the collaborator from the user.
     *
     * @return the ID document type selected by the user
     */
    private int requestIdDocType() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Id Document Type: ");
                System.out.println("1 - Taxpayer Number");
                System.out.println("2 - Citizen Card");
                System.out.println("3 - Passport");
                if (input.hasNextInt()) {
                    int idDocTypeInput = input.nextInt();
                    if (idDocTypeInput > 0 && idDocTypeInput < 4) {
                        return idDocTypeInput;
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
     * Requests the ID number of the collaborator from the user.
     *
     * @param idDocType the type of ID document of the collaborator
     * @return the ID number entered by the user
     */
    private int requestIdNumber(int idDocType) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("ID Number: ");
                if (input.hasNextInt()) {
                    int idNumber = input.nextInt();
                    switch (idDocType) {
                        case 1:
                            if (String.valueOf(idNumber).length() == 9) {
                                return idNumber;
                            } else {
                                throw new IllegalArgumentException("Invalid taxpayer number. Please enter a 9-digit number.");
                            }
                        case 2:
                            if (String.valueOf(idNumber).length() == 8) {
                                return idNumber;
                            } else {
                                throw new IllegalArgumentException("Invalid citizen card number. Please enter an 8-digit number.");
                            }
                        case 3:
                            if (!String.valueOf(idNumber).matches("[a-zA-Z]\\d{6}")) {
                                return idNumber;
                            } else {
                                throw new IllegalArgumentException("Invalid passport number. Please enter a letter followed by 6 digits.");
                            }
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
     * Requests the job of the collaborator from the user.
     *
     * @return the job entered by the user
     */
    private String requestJobName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Job: ");
        return input.nextLine();
    }

    /**
     * Displays the list of jobs.
     */
    private void displayJobs() {

        System.out.println("List of existing jobs: ");
        System.out.println(getController().getJobsList());

    }
}

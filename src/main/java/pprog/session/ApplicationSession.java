package pprog.session;

import pprog.interfaces.SortingAlgorithm;
import pprog.interfaces.Email;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Represents the application session.
 */
public class ApplicationSession {
    private final AuthenticationRepository authenticationRepository;
    private static final String CONFIGURATION_FILENAME = "src/main/resources/config.properties";
    private static final String COMPANY_DESIGNATION = "Company.Designation";

    /**
     * Constructs a new ApplicationSession object.
     */
    private ApplicationSession() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        Properties props = getProperties();
    }

    /**
     * Retrieves the current user session.
     *
     * @return The current user session.
     */
    public pprog.session.UserSession getCurrentSession() {
        pt.isep.lei.esoft.auth.UserSession userSession = this.authenticationRepository.getCurrentUserSession();
        return new UserSession(userSession);
    }

    /**
     * Retrieves the properties from the configuration file.
     *
     * @return The properties loaded from the configuration file.
     */
    private Properties getProperties() {
        Properties props = new Properties();

        props.setProperty(COMPANY_DESIGNATION, "MusgoSublime");

        try {
            InputStream in = new FileInputStream(CONFIGURATION_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    private static pprog.session.ApplicationSession singleton = null;

    /**
     * Gets the instance of the ApplicationSession.
     *
     * @return The instance of ApplicationSession.
     */
    public static pprog.session.ApplicationSession getInstance() {
        if (singleton == null) {
            synchronized (pprog.session.ApplicationSession.class) {
                singleton = new pprog.session.ApplicationSession();
            }
        }
        return singleton;
    }

    /**
     * Retrieves the email service.
     *
     * @return The email service.
     * @throws IOException              If an I/O error occurs.
     */
    private static String getEmail() throws IOException {
        try (InputStream input = new FileInputStream(CONFIGURATION_FILENAME)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("emailService", "");
        }
    }


    public static Email getEmailService() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String emailClassPath = "pprog.domain." + getEmail();
        Class<?> className = Class.forName(emailClassPath);
        return (Email) className.getDeclaredConstructor().newInstance();
    }

    private static String getAlgorithm() throws IOException {
        try (InputStream input = new FileInputStream(CONFIGURATION_FILENAME)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("SortingAlgorithm", "");
        }
    }

    public static SortingAlgorithm getSortingAlgorithm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        String algorithm= "pprog.domain." + getAlgorithm();
        Class<?> className = Class.forName(algorithm);
        return (SortingAlgorithm) className.getDeclaredConstructor().newInstance();
    }

}

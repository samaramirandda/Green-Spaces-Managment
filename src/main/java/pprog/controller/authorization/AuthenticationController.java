package pprog.controller.authorization;

import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.List;

/**
 * The AuthenticationController class provides methods for user authentication and authorization.
 */
public class AuthenticationController {

    /**
     * Constant representing the role of Human Resources Manager.
     */
    public static final String ROLE_HRM = "Human Resources Manager";

    /**
     * Constant representing the role of Vehicle and Equipment Fleet Manager.
     */
    public static final String ROLE_VFM = "Vehicle and Equipment Fleet Manager";

    /**
     * Constant representing the role of Green Spaces Manager.
     */
    public static final String ROLE_GSM = "Green Spaces Manager";

    /**
     * Constant representing the role of Collaborator.
     */
    public static final String ROLE_COLLABORATOR = "Collaborator";

    /**
     * The repository responsible for handling authentication operations.
     */
    private final AuthenticationRepository authenticationRepository;

    /**
     * Constructs a new AuthenticationController object.
     */
    public AuthenticationController() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    }

    /**
     * Attempts to login a user with the given email and password.
     *
     * @param email The email of the user.
     * @param pwd   The password of the user.
     * @return true if the login is successful, false otherwise.
     */
    public boolean doLogin(String email, String pwd) {
        try {
            return authenticationRepository.doLogin(email, pwd);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Retrieves the roles associated with the currently logged-in user.
     *
     * @return A list of UserRoleDTO objects representing the roles of the user, or null if no user is logged in.
     */
    public List<UserRoleDTO> getUserRoles() {
        if (authenticationRepository.getCurrentUserSession().isLoggedIn()) {
            return authenticationRepository.getCurrentUserSession().getUserRoles();
        }
        return null;
    }

    /**
     * Logs out the currently logged-in user.
     */
    public void doLogout() {
        authenticationRepository.doLogout();
    }
}

package pprog.repository;

import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.Serializable;

/**
 * Repository for handling authentication operations.
 */
public class AuthenticationRepository {
    /**
     * The facade for authentication operations.
     */
    private transient AuthFacade authenticationFacade;

    /**
     * Constructs an AuthenticationRepository with a new instance of AuthFacade.
     */
    public AuthenticationRepository() {
        authenticationFacade = new AuthFacade();
    }

    /**
     * Performs a login operation.
     *
     * @param email the email of the user
     * @param pwd   the password of the user
     * @return true if the login is successful, false otherwise
     */
    public boolean doLogin(String email, String pwd) {
        return authenticationFacade.doLogin(email, pwd).isLoggedIn();
    }

    /**
     * Performs a logout operation.
     */
    public void doLogout() {
        authenticationFacade.doLogout();
    }

    /**
     * Gets the current user session.
     *
     * @return the current user session
     */
    public UserSession getCurrentUserSession() {
        return authenticationFacade.getCurrentUserSession();
    }

    /**
     * Adds a new user role.
     *
     * @param id          the ID of the role
     * @param description the description of the role
     * @return true if the role is added successfully, false otherwise
     */
    public boolean addUserRole(String id, String description) {
        return authenticationFacade.addUserRole(id, description);
    }

    /**
     * Adds a new user with a specified role.
     *
     * @param name   the name of the user
     * @param email  the email of the user
     * @param pwd    the password of the user
     * @param roleId the ID of the role
     * @return true if the user with the role is added successfully, false otherwise
     */
    public boolean addUserWithRole(String name, String email, String pwd, String roleId) {
        return authenticationFacade.addUserWithRole(name, email, pwd, roleId);
    }
}

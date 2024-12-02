package pprog.controller;

import pprog.domain.GreenSpace;
import pprog.domain.GreenSpacesManager;
import pprog.repository.AuthenticationRepository;
import pprog.repository.GreenSpaceRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * Controller class for registering a new green space.
 */
public class RegisterGreenSpaceController {

    /**
     * The green space repository instance.
     */
    private GreenSpaceRepository greenSpaceRepository;

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a new RegisterGreenSpaceController and initializes the green space repository and authentication repository.
     */
    public RegisterGreenSpaceController() {
        getGreenSpaceRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs a new RegisterGreenSpaceController with the specified green space repository and authentication repository.
     *
     * @param greenSpaceRepository    The green space repository instance.
     * @param authenticationRepository The authentication repository instance.
     */
    public RegisterGreenSpaceController(GreenSpaceRepository greenSpaceRepository, AuthenticationRepository authenticationRepository) {
        this.greenSpaceRepository = greenSpaceRepository;
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the green space repository instance.
     *
     * @return The green space repository instance.
     */
    public GreenSpaceRepository getGreenSpaceRepository() {
        if (greenSpaceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpaceRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpaceRepository;
    }

    /**
     * Retrieves the authentication repository instance.
     *
     * @return The authentication repository instance.
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }


    /**
     * Registers a new green space.
     *
     * @param name    The name of the green space.
     * @param address The address of the green space.
     * @param type    The type of the green space.
     * @param area    The area of the green space.
     * @return A message indicating the result of the registration process.
     */
    public String registerGreenSpace(String name, String[] address, int type, double area) {
        try {
            getGreenSpaceRepository().registerGreenSpace(name, address, type, area, getGSMFromSession());
            return null;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Retrieves the Green Spaces Manager (GSM) from the current session.
     *
     * @return The Green Spaces Manager.
     */
    private GreenSpacesManager getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new GreenSpacesManager(email.getEmail());
    }

    /**
     * Retrieves the last green space registered.
     *
     * @return The last green space registered.
     */
    public GreenSpace getGreenSpaceRegistered() {
        List<GreenSpace> greenSpaces = getGreenSpaceRepository().getGreenSpacesList();
        return greenSpaces.get(greenSpaces.size() - 1);
    }

}

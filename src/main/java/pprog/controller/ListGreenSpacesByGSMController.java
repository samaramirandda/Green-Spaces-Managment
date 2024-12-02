package pprog.controller;

import pprog.domain.GreenSpace;
import pprog.domain.GreenSpacesManager;
import pprog.repository.AuthenticationRepository;
import pprog.repository.GreenSpaceRepository;
import pprog.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * Controller class for listing green spaces managed by a Green Spaces Manager (GSM).
 */
public class ListGreenSpacesByGSMController {

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * The green space repository instance.
     */
    private GreenSpaceRepository greenSpaceRepository;

    /**
     * Constructs a new ListGreenSpacesByGSMController and initializes the authentication repository and green space repository.
     */
    public ListGreenSpacesByGSMController() {
        getAuthenticationRepository();
        getGreenSpaceRepository();
    }

    /**
     * Retrieves the authentication repository instance.
     *
     * @return The authentication repository instance.
     */
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
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
     * Retrieves the Green Spaces Manager (GSM) from the current session.
     *
     * @return The Green Spaces Manager.
     */
    private GreenSpacesManager getGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new GreenSpacesManager(email.getEmail());
    }

    /**
     * Sorts the list of green spaces managed by the GSM using an algorithm.
     *
     * @return The sorted list of green spaces.
     */
    public List<GreenSpace> sortListByAlgorithm() {
        return getGreenSpaceRepository().sortListByAlgorithm(getGSMFromSession());
    }
}

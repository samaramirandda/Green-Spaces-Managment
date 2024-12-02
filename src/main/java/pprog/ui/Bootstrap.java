package pprog.ui;

import pprog.controller.authorization.AuthenticationController;
import pprog.domain.Collaborator;
import pprog.repository.AuthenticationRepository;
import pprog.repository.CollaboratorRepository;
import pprog.repository.Repositories;

import java.util.List;

public class Bootstrap implements Runnable {
    public void run() {
        addUsers();
    }

    private void addUsers() {
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_HRM, AuthenticationController.ROLE_HRM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_VFM, AuthenticationController.ROLE_VFM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_GSM, AuthenticationController.ROLE_GSM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_COLLABORATOR, AuthenticationController.ROLE_COLLABORATOR);


        authenticationRepository.addUserWithRole("Human Resources Manager 1", "hrm1@this.app", "hrm1",
                AuthenticationController.ROLE_HRM);

        authenticationRepository.addUserWithRole("Human Resources Manager 2", "hrm2@this.app", "hrm2",
                AuthenticationController.ROLE_HRM);

        authenticationRepository.addUserWithRole("Vehicle and Equipment Fleet Manager 1", "vfm1@this.app", "vfm1",
                AuthenticationController.ROLE_VFM);

        authenticationRepository.addUserWithRole("Vehicle and Equipment Fleet Manager 2", "vfm2@this.app", "vfm2",
                AuthenticationController.ROLE_VFM);

        authenticationRepository.addUserWithRole("Green Spaces Manager 1", "gsm1@this.app", "gsm1",
                AuthenticationController.ROLE_GSM);

        authenticationRepository.addUserWithRole("Green Spaces Manager 2", "gsm2@this.app", "gsm2",
                AuthenticationController.ROLE_GSM);

        CollaboratorRepository collaboratorRepository = Repositories.getInstance().getCollaboratorRepository();
        List<Collaborator> collaboratorsList = collaboratorRepository.getCollaboratorsList();

        for (Collaborator c : collaboratorsList) {
            String email = c.getEmail();
            String password = email.split("@")[0];
            authenticationRepository.addUserWithRole(c.getName(), email, password, AuthenticationController.ROLE_COLLABORATOR);
        }

    }
}

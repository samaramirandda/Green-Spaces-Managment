package pprog.controller;

import pprog.domain.Collaborator;
import pprog.domain.EmailService;
import pprog.domain.Entry;
import pprog.domain.Team;
import pprog.domain.Agenda;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;
import pprog.repository.TeamRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * Controller class for assigning teams to entries in the agenda.
 */
public class AssignTeamController {

    /**
     * The agenda instance.
     */
    private Agenda agenda;

    /**
     * The team repository instance.
     */
    private TeamRepository teamRepository;

    /**
     * The authentication repository instance.
     */
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a new AssignTeamController and initializes the agenda, team repository, and authentication repository.
     */
    public AssignTeamController () {
        getAgenda();
        getTeamRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs a new AssignTeamController with the specified agenda, team repository, and authentication repository.
     *
     * @param agenda                   The agenda instance.
     * @param teamRepository           The team repository instance.
     * @param authenticationRepository The authentication repository instance.
     */
    public AssignTeamController (Agenda agenda, TeamRepository teamRepository, AuthenticationRepository authenticationRepository) {
        this.agenda = agenda;
        this.teamRepository = teamRepository;
        this.authenticationRepository = authenticationRepository;
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
     * Retrieves the team repository instance.
     *
     * @return The team repository instance.
     */
    private TeamRepository getTeamRepository() {
        if (teamRepository == null) {
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
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
     * Assigns a team to an entry in the agenda.
     *
     * @param agendaIndex The index of the entry in the agenda.
     * @param teamIndex   The index of the team to assign.
     * @return A message indicating the result of assigning the team to the entry.
     */
    public String assignTeamToEntry(int agendaIndex, int teamIndex) {
        try {
            Entry entry = getEntryByIndex(agendaIndex);
            Team team = getTeamByIndex(teamIndex);
            entry.assignTeam(team);
            for (Collaborator c : team.getTeam()) {
                sendTheEmailToTeam(getEmailGSMFromSession(), c.getEmail(), c.getName(), entry.toString());
            }
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
     * Retrieves the team from the team repository by its index.
     *
     * @param index The index of the team.
     * @return The team.
     */
    private Team getTeamByIndex(int index) {
        return getTeamRepository().getTeamByIndex(index);
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
     * Retrieves the list of teams from the team repository.
     *
     * @return The list of teams.
     */
    public List<Team> getTeamsList() {
        return getTeamRepository().getTeamList();
    }

    /**
     * Sends an email to each collaborator in the assigned team.
     *
     * @param gsmEmail          The email of the Green Spaces Manager.
     * @param collaboratorEmail The email of the collaborator.
     * @param collaboratorName  The name of the collaborator.
     * @param entry             The entry details.
     */
    private void sendTheEmailToTeam(String gsmEmail, String collaboratorEmail, String collaboratorName, String entry) {
        EmailService.sendToEmailFile(gsmEmail, collaboratorEmail, collaboratorName, entry);
    }

    /**
     * Retrieves the email of the Green Spaces Manager from the current session.
     *
     * @return The email of the Green Spaces Manager.
     */
    private String getEmailGSMFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return email.getEmail();
    }

    /**
     * Retrieves the entry from the agenda with the assigned team by its index.
     *
     * @param index The index of the entry.
     * @return The entry with the assigned team.
     */
    public Entry getEntryWithTeam(int index) {
        return getEntryByIndex(index);
    }

}

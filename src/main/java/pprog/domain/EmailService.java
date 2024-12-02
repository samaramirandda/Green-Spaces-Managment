package pprog.domain;

import pprog.interfaces.Email;
import pprog.session.ApplicationSession;

/**
 * A service that handles sending emails for task assignments.
 */
public class EmailService {

    /**
     * Sends an email to a collaborator informing them of their assignment to a task.
     *
     * @param gsmEmail         the email address of the GSM (Green Space Manager)
     * @param collaboratorEmail the email address of the collaborator
     * @param collaboratorName  the name of the collaborator
     * @param entry             the task information to be included in the email
     */
    public static void sendToEmailFile(String gsmEmail, String collaboratorEmail, String collaboratorName, String entry) {
        String subject = "Assignment to a task";
        String body = "Hello " + collaboratorName + ".\nYou have been assigned a task that is in the Agenda, so you have become responsible for carrying it out.\n" +
                "Below is the task information:\n" + entry + "\n";
        Email emailService = null;

        try {
            emailService = ApplicationSession.getEmailService();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        emailService.sendEmail(gsmEmail, collaboratorEmail, subject, body);
    }
}

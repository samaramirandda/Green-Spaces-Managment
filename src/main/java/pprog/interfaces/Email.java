package pprog.interfaces;

/**
 * An interface representing an email service.
 */
public interface Email {

    /**
     * Sends an email.
     *
     * @param from    The sender's email address.
     * @param to      The recipient's email address.
     * @param subject The subject of the email.
     * @param body    The body of the email.
     */
    void sendEmail(String from, String to, String subject, String body);

}

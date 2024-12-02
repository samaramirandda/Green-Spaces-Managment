package pprog.domain;

import pprog.interfaces.Email;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * GmailService class implements the Email interface and provides functionality to send emails using Gmail.
 */
public class GmailService implements Email {

    /**
     * Sends an email using Gmail.
     *
     * @param from    the email address of the sender
     * @param to      the email address of the recipient
     * @param subject the subject of the email
     * @param body    the body of the email
     */
    @Override
    public void sendEmail(String from, String to, String subject, String body) {

        String fileName = "email.txt";

        File f = new File(fileName);
        if (f.exists()) {
            writeToFile(f, from, to, subject, body);
        } else {
            try {
                f.createNewFile();
                writeToFile(f, from, to, subject, body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes the email details to a file.
     *
     * @param file    the file to write to
     * @param from    the email address of the sender
     * @param to      the email address of the recipient
     * @param subject the subject of the email
     * @param body    the body of the email
     */
    private static void writeToFile(File file, String from, String to, String subject, String body) {
        try {
            FileWriter send = new FileWriter(file, true);
            send.write("Email Service: Gmail\nFrom: " + from + "\nTo: " + to + "\nSubject: " + subject + "\n" + body + "\n");
            send.flush();
            send.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

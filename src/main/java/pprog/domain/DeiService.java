package pprog.domain;

import pprog.interfaces.Email;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A service that simulates sending an email by writing the email details to a text file.
 */
public class DeiService implements Email {

    /**
     * Sends an email by writing the details to a text file named "email.txt".
     *
     * @param from    the sender's email address
     * @param to      the recipient's email address
     * @param subject the subject of the email
     * @param body    the body of the email
     */
    @Override
    public void sendEmail(String from, String to, String subject, String body) {
        String fileName = "email.txt";
        File file = new File(fileName);

        if (file.exists()) {
            writeToFile(file, from, to, subject, body);
        } else {
            try {
                file.createNewFile();
                writeToFile(file, from, to, subject, body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes the email details to the specified file.
     *
     * @param file    the file to write to
     * @param from    the sender's email address
     * @param to      the recipient's email address
     * @param subject the subject of the email
     * @param body    the body of the email
     */
    private static void writeToFile(File file, String from, String to, String subject, String body) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("Email Service: Dei Service\nFrom: " + from + "\nTo: " + to + "\nSubject: " + subject + "\n" + body + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

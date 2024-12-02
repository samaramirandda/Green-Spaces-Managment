package pprog.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GmailServiceTest {

    @AfterEach
    void tearDown() {
        File file = new File("email.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void sendEmail() {
        GmailService gmailService = new GmailService();

        String from = "sender@gmail.com";
        String to = "recipient@gmail.com";
        String subject = "Test Subject";
        String body = "Test Body";

        gmailService.sendEmail(from, to, subject, body);

        File file = new File("email.txt");
        assertTrue(file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            assertTrue(content.toString().contains("Email Service: Gmail"));
            assertTrue(content.toString().contains("From: " + from));
            assertTrue(content.toString().contains("To: " + to));
            assertTrue(content.toString().contains("Subject: " + subject));
            assertTrue(content.toString().contains(body));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading file");
        }
    }
}

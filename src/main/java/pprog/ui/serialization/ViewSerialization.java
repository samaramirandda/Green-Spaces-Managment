package pprog.ui.serialization;

import pprog.repository.Repositories;

import java.io.*;

/**
 * A class to view serialized data.
 */
public class ViewSerialization {

    /**
     * Main method to view serialized data.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Input stream for reading the serialized data file
            FileInputStream fileIn = new FileInputStream("src\\main\\resources\\config.properties.xml");

            // Object input stream for deserializing the data
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Read the serialized repositories object
            Repositories repositories = (Repositories) objectIn.readObject();

            // Print the repositories object
            System.out.println(repositories);

            // Close the object input stream and file input stream
            objectIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
package pprog.ui.serialization;

import pprog.repository.Repositories;

import java.io.*;

/**
 * A class to clear serialized data.
 */
public class ClearSerializedData {

    /**
     * Main method to clear serialized data.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Path to the XML configuration file
            String filePath = "src\\main\\resources\\config.properties.xml";

            // Get the instance of the Repositories
            Repositories repositories = Repositories.getInstance();

            // Clear the data in the repositories
            repositories.clearData();

            // Save the system state to binary file
            repositories.saveSystemStateToBinary(new File(filePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package pprog.ui.console;

import org.apache.commons.lang3.StringUtils;

/**
 * User interface for displaying text.
 */
public class ShowTextUI implements Runnable {

    /**
     * The text to be displayed.
     */
    private String text;

    /**
     * Constructs a ShowTextUI with the specified text.
     *
     * @param text the text to be displayed
     * @throws IllegalArgumentException if the text is null or empty
     */
    public ShowTextUI(String text) {
        if (StringUtils.isBlank(text))
            throw new IllegalArgumentException("ShowTextUI does not support null or empty text");

        this.text = text;
    }

    /**
     * Displays the text.
     */
    public void run() {
        System.out.println("\n");
        System.out.println(this.text);
        System.out.println("\n");
    }
}

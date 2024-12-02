package pprog.ui;

import pprog.repository.Repositories;
import pprog.ui.console.menu.MainMenuUI;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("src\\main\\resources\\config.properties.xml");
        Repositories.getInstance().loadSystemStateFromBinary(f);
        pprog.ui.Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Repositories.getInstance().saveSystemStateToBinary(f);

    }
}

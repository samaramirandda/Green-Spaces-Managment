module pprog.ui.gui {
    requires AuthLib;
    requires java.logging;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires org.apache.commons.lang3;

    opens pprog.ui.gui to javafx.fxml;
    exports pprog.ui.gui to javafx.graphics;
    opens pprog.domain to javafx.base;
    opens pprog.interfaces to javafx.base;
    exports pprog.ui to javafx.graphics;
    opens pprog.ui to javafx.fxml;

}
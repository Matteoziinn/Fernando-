module org.app.gerparque {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jdk.compiler;

    opens org.app.gerparque to javafx.fxml;
    exports org.app.gerparque;
    exports org.app.gerparque.controllers;
    opens org.app.gerparque.models to javafx.base;
    opens org.app.gerparque.controllers to javafx.fxml;
}
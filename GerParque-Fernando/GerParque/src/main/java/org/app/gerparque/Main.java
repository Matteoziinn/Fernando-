package org.app.gerparque;

import javafx.application.Application;
import javafx.stage.Stage;
import org.app.gerparque.utils.ScreenManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenManager screenManager = new ScreenManager(primaryStage);
        screenManager.changeScene("/org/app/gerparque/login.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}

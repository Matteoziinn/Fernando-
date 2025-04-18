package org.app.gerparque.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.app.gerparque.controllers.*;

import java.io.IOException;

public class ScreenManager {

    private Stage primaryStage;

    public ScreenManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void changeScene(String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = fxmlLoader.load();

        Object controller = fxmlLoader.getController();
        if (controller instanceof LoginController loginController) {
            loginController.setScreenManager(this);
        } else if (controller instanceof RegisterController registerController) {
            registerController.setScreenManager(this);
        } else if (controller instanceof BoxOfficeController bilheteriaController) {
            bilheteriaController.setScreenManager(this);
        } else if (controller instanceof BuyController buyController) {
            buyController.setScreenManager(this);
        } else if (controller instanceof AtracaoController atracaoController) {
            atracaoController.setScreenManager(this);
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

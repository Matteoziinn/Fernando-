package org.app.gerparque.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.app.gerparque.services.UserService;
import org.app.gerparque.utils.ScreenManager;

import java.io.IOException;

public class LoginController {

    private UserService usrService =  new UserService();

    private ScreenManager screenManager;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordTextFiled;

    @FXML
    private Button registerBtn;

    @FXML
    private Label labelAlert;

    @FXML
    void loginBtn(ActionEvent event) throws InterruptedException, IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (userNameTextField.getText().isBlank() && passwordTextFiled.getText().isBlank()) {
            //labelAlert.setText("Entre com o username e senha");
            alert.setTitle("Aviso");
            alert.setHeaderText("Atenção!");
            alert.setContentText("Preencha todos o campos ou verifique os dados.");
            alert.showAndWait();
        } else if (usrService.checkLogin(userNameTextField.getText(), passwordTextFiled.getText())) {
            Thread.sleep(2222);
            labelAlert.setText("Entrando...");
            screenManager.changeScene("/org/app/gerparque/bilheteria.fxml");
        } else if (! usrService.checkLogin(userNameTextField.getText(), passwordTextFiled.getText())) {
            alert.setTitle("Aviso");
            alert.setHeaderText("Atenção!");
            alert.setContentText("Senha ou username invalidos");
            alert.showAndWait();
        }
    }

    @FXML
    void registerBtn(ActionEvent event)throws IOException {
        screenManager.changeScene("/org/app/gerparque/register.fxml");
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }


}

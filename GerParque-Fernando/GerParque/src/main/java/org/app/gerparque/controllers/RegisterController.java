package org.app.gerparque.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.app.gerparque.services.UserService;
import org.app.gerparque.utils.ScreenManager;

import java.io.IOException;

public class RegisterController {

    private UserService userServ = new UserService();

    private ScreenManager screenManager;

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @FXML
    private TextField userNameId;

    @FXML
    private TextField emailCampText;

    @FXML
    private TextField cpfId;

    @FXML
    private PasswordField passwordCamp;

    @FXML
    private TextField nomeCampText;

    @FXML
    private TextField telefoneCampText;

    @FXML
    void cadastroDeRegistro(ActionEvent event) {
        String name = nomeCampText.getText();
        String email = emailCampText.getText();
        String phoneNumber = telefoneCampText.getText();
        String cpf = cpfId.getText();
        String userName = userNameId.getText();
        String password = passwordCamp.getText();

        System.out.println("senha capturada a baixo" + password);


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alertError = new Alert(Alert.AlertType.ERROR);

        try {

            if (userServ.CreateUser(name, email, phoneNumber, cpf, userName, password)) {
                System.out.println("senha capturada" + password);
                alert.setTitle("Information");
                alert.setHeaderText("user registered successfully");
                alert.setContentText("Este é um exemplo de alerta de informação.");
                alert.showAndWait();

            } else {
                alertError.setTitle("Erro");
                alertError.setHeaderText("Registration error");
                alertError.setContentText("Unable to register user. Please try again.");
                alertError.showAndWait();
            }

        } catch (Exception e) {
            alertError.setTitle("Erro");
            alertError.setHeaderText("Registration error");
            alertError.setContentText("An unexpected error occurred: " + e.getMessage());
            alertError.showAndWait();
        }


    }

    @FXML
    void vltLogin(ActionEvent event) throws IOException {
        screenManager.changeScene("/org/app/gerparque/login.fxml");
    }
}

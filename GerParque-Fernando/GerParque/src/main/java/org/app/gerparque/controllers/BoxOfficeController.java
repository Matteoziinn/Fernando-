package org.app.gerparque.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;

import org.app.gerparque.DAO.BoxOfficeDAO;
import org.app.gerparque.models.BoxOffice;
import org.app.gerparque.utils.ScreenManager;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class BoxOfficeController implements Initializable{

    private ScreenManager screenManager;

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @FXML
    private TableView<BoxOffice> tableBoxOffice;

    @FXML
    private TableColumn<BoxOfficeController, Integer> amountBoxOffice;

    @FXML
    private TableColumn<BoxOfficeController, LocalTime> closingBoxOffice;

    @FXML
    private TableColumn<BoxOfficeController, LocalDate> openingBoxOffice;

    @FXML
    private TableColumn<BoxOfficeController, BigDecimal> priceBoxOffice;

    @FXML
    private TableColumn<BoxOfficeController, LocalTime> opeingid;

    @FXML
    void goAtracoes(ActionEvent event) {

    }

    @FXML
    void goBuy(ActionEvent event) throws IOException {
        screenManager.changeScene("/org/app/gerparque/buy.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        priceBoxOffice.setCellValueFactory(new PropertyValueFactory<>("preco"));
        closingBoxOffice.setCellValueFactory(new PropertyValueFactory<>("fechamento"));
        openingBoxOffice.setCellValueFactory(new PropertyValueFactory<>("operation"));
        amountBoxOffice.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        opeingid.setCellValueFactory(new PropertyValueFactory<>("abertura"));

        BoxOfficeDAO dao = new BoxOfficeDAO();
        ObservableList<BoxOffice> lista = dao.carregarBilheteria();
        tableBoxOffice.setItems(lista);

    }
}

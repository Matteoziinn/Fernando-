package org.app.gerparque.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.app.gerparque.services.TicketService;
import org.app.gerparque.utils.ScreenManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BuyController implements Initializable {

    private ScreenManager screenManager;
    private TicketService tkService = new TicketService();

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @FXML
    private ComboBox<String> boxAtracao;

    @FXML
    private ComboBox<String> buyPagamento;

    @FXML
    private TextField cpfClienteID;


    @FXML
    private Label labelStatus;

    private List<String> listAtracoes = new ArrayList<>();
    private ObservableList<String> obsAtracoes;

    private List<String> listPagamentos = new ArrayList<>();
    private ObservableList<String> obsPagamentos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarAtracoes();
        carregarFormasPagamento();
    }

    private void carregarAtracoes() {
        listAtracoes.add("Roda Gigante");
        listAtracoes.add("Montanha Russa");
        listAtracoes.add("Barco Viking");
        listAtracoes.add("Casa do Terror");

        obsAtracoes = FXCollections.observableArrayList(listAtracoes);
        boxAtracao.setItems(obsAtracoes);
    }

    private void carregarFormasPagamento() {
        listPagamentos.add("pix");
        listPagamentos.add("credito");
        listPagamentos.add("debito");
        listPagamentos.add("dinheiro");

        obsPagamentos = FXCollections.observableArrayList(listPagamentos);
        buyPagamento.setItems(obsPagamentos);
    }

    @FXML
    void BuyBtnId(ActionEvent event) {
        String cpf = cpfClienteID.getText().trim();
        if (cpf.isEmpty()) {
            labelStatus.setText("O campo 'CPF' não pode estar vazio.");
            return;
        }

        String atracao = boxAtracao.getSelectionModel().getSelectedItem();
        if (atracao == null) {
            labelStatus.setText("Por favor, selecione uma atração.");
            return;
        }

        String pagamento = buyPagamento.getSelectionModel().getSelectedItem();
        if (pagamento == null) {
            labelStatus.setText("Por favor, selecione uma forma de pagamento.");
            return;
        }

        tkService.ticketCreate(cpf, pagamento, atracao);

        System.out.println("Cliente: " + cpf);
        System.out.println("Atração: " + atracao);
        System.out.println("Pagamento: " + pagamento);

        labelStatus.setText("Compra registrada com sucesso!");


    }

    @FXML
    void limparCampos(ActionEvent event) {
        cpfClienteID.clear();
        boxAtracao.setValue(null);
        buyPagamento.setValue(null);
        labelStatus.setText("");
    }


    @FXML
    void vltBilheteriaBtn(ActionEvent event) throws IOException {
        screenManager.changeScene("/org/app/gerparque/bilheteria.fxml");
    }

    @FXML
    void IrAtracoes(ActionEvent event) throws IOException {
        screenManager.changeScene("/org/app/gerparque/atracao.fxml");
    }

    @FXML
    void sairDoApp(ActionEvent event) {
        Platform.exit();
    }
}

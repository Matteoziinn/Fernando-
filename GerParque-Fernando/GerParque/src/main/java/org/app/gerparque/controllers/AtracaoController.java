package org.app.gerparque.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.app.gerparque.DAO.AtracaoClienteDAO;
import org.app.gerparque.DAO.AtracaoDAO;
import org.app.gerparque.DAO.TicketDAO;
import org.app.gerparque.models.Atracao;
import org.app.gerparque.services.AtrcaoClienteService;
import org.app.gerparque.utils.ScreenManager;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AtracaoController implements Initializable {

    private AtrcaoClienteService atrService = new AtrcaoClienteService();

    @FXML
    private ComboBox<Atracao> boxAtracao;

    @FXML
    private TableColumn<Atracao, String> columAtracao;

    @FXML
    private TableColumn<Atracao, String> columnAbertura;

    @FXML
    private TableColumn<Atracao, String> columnCapacidade;

    @FXML
    private TableColumn<Atracao, String> columnFechamento;

    @FXML
    private TableView<Atracao> tableViewAtracao;

    @FXML
    private TextField campoCPF;

    private ScreenManager screenManager;

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @FXML
    void participarAtracao(ActionEvent event) {
        Atracao atracaoSelecionada = boxAtracao.getValue();
        String cpf = campoCPF.getText();

        if (cpf.isEmpty() || atracaoSelecionada == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, insira um CPF válido e selecione uma atração.");
            alert.showAndWait();
            return;
        }

        AtracaoClienteDAO atracaoClienteDAO = new AtracaoClienteDAO();
        TicketDAO ticketDAO = new TicketDAO();

        System.out.println("Verificando se cliente já participou da atração...");
        boolean jaParticipou = atracaoClienteDAO.verificarIngressoPorAtracao(cpf, atracaoSelecionada.getNome());


        if (jaParticipou) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Você já está registrado nesta atração.");
            alert.showAndWait();
            return;
        }

        System.out.println("Verificando ingresso mais antigo...");
        Integer idIngresso = ticketDAO.getIngressoMaisAntigoPorCpfEAtracao(cpf, atracaoSelecionada.getNome());

        AtracaoDAO atracaoDAO = new AtracaoDAO();
        Integer idAtracao = atracaoDAO.buscarIdPorNome(atracaoSelecionada.getNome());

        System.out.println("esse é o id da atracao (banco): " + idAtracao);

        if (idIngresso != null && idAtracao != null) {
            atracaoClienteDAO.insertAtracaoCliente(idIngresso, idAtracao);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Participação registrada com sucesso!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Você não tem ingresso válido para participar ou ocorreu erro ao identificar atração.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columAtracao.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnAbertura.setCellValueFactory(new PropertyValueFactory<>("abertura"));
        columnCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
        columnFechamento.setCellValueFactory(new PropertyValueFactory<>("fechamento"));

        AtracaoDAO atracaoDAO = new AtracaoDAO();
        ObservableList<Atracao> listaAtracoes = atracaoDAO.carregarAtracoes();

        tableViewAtracao.setItems(listaAtracoes);
        boxAtracao.setItems(listaAtracoes);
    }

}

package org.app.gerparque.DAO;

import org.app.gerparque.models.Atracao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.app.gerparque.repositorys.IAtracaoDAO;

public class AtracaoDAO extends GerencDAO implements IAtracaoDAO {

    public ObservableList<Atracao> carregarAtracoes() {
        ObservableList<Atracao> listaAtracoes = FXCollections.observableArrayList();

        String sql = "SELECT nome, horario_inicio, horario_fim, capacidade FROM atracao";

        try (Connection connection = getConnectionGerc();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                LocalTime abertura = resultSet.getTime("horario_inicio").toLocalTime();
                LocalTime fechamento = resultSet.getTime("horario_fim").toLocalTime();
                int capacidade = resultSet.getInt("capacidade");

                Atracao atracao = new Atracao(nome, abertura, fechamento, capacidade);
                listaAtracoes.add(atracao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaAtracoes;
    }

    @Override
    public Integer buscarIdPorNome(String nomeAtracao) {
        String sql = "SELECT id FROM atracao WHERE nome = ?";
        try (Connection conn = getConnectionGerc();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeAtracao);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

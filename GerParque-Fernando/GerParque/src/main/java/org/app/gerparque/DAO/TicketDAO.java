package org.app.gerparque.DAO;

import org.app.gerparque.repositorys.ITicketDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO extends GerencDAO implements ITicketDAO {

    @Override
    public boolean insertIngresso(String cpf, String frmPg, String nomeAtracao) {
        String sql = "INSERT INTO ingresso (cpf_cliente, id_bilheteria, pagamento, nome_atracao_ingresso) " +
                "VALUES (?, ?, ?::forma_pagamento, ?)";

        try (Connection connection = getConnectionGerc();
             PreparedStatement prstamt = connection.prepareStatement(sql)) {

            prstamt.setString(1, cpf);
            prstamt.setInt(2, 1);
            prstamt.setString(3, frmPg);
            prstamt.setString(4, nomeAtracao);

            int rs = prstamt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer getIngressoMaisAntigoPorCpfEAtracao(String cpfCliente, String nomeAtracao) {
        String sql = "SELECT id FROM ingresso " +
                "WHERE cpf_cliente = ? AND nome_atracao_ingresso = ? " +
                "ORDER BY timestamp_venda DESC LIMIT 1";

        try (Connection connection = getConnectionGerc();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cpfCliente);
            preparedStatement.setString(2, nomeAtracao);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}

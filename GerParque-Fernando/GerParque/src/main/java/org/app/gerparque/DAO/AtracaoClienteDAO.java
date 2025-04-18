package org.app.gerparque.DAO;

import org.app.gerparque.repositorys.IAtracao_clienteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtracaoClienteDAO extends GerencDAO implements IAtracao_clienteDAO {

    @Override
    public void insertAtracaoCliente(Integer idIngresso, Integer idAtracao) {
        String sql = "INSERT INTO atracao_cliente(id_atracao, id_ingresso) VALUES (?, ?)";

        try (Connection conn = getConnectionGerc();
             PreparedStatement prpStmt = conn.prepareStatement(sql)) {

            prpStmt.setInt(1, idAtracao);
            prpStmt.setInt(2, idIngresso);

            int rs = prpStmt.executeUpdate();
            if (rs > 0)
                System.out.println("Registro de participação deu bom");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean verificarIngressoPorAtracao(String cpfCliente, String nomeAtracao) {
        String sql = "SELECT ac.id_atracao " +
                "FROM atracao_cliente ac " +
                "JOIN ingresso i ON ac.id_ingresso = i.id " +
                "JOIN atracao a ON ac.id_atracao = a.id " +
                "WHERE i.cpf_cliente = ? AND a.nome = ?";

        try (Connection connection = getConnectionGerc();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cpfCliente);
            preparedStatement.setString(2, nomeAtracao);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // retorna true se encontrar
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

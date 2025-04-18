package org.app.gerparque.DAO;

import org.app.gerparque.models.User;
import org.app.gerparque.repositorys.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends GerencDAO implements IUserDAO {
    private boolean checkRegister;


    @Override
    public boolean register(User user) {
        String sql = "INSERT INTO cliente (nome, email, telefone, cpf, username, password) VALUES (?,?,?,?,?,?)";
        try (Connection connection = getConnectionGerc(); PreparedStatement prstamt = connection.prepareStatement(sql)) {
            prstamt.setString(1, user.getName());
            prstamt.setString(2, user.getEmail());
            prstamt.setString(3, user.getPhoneNumber());
            prstamt.setString(4, user.getCpf());
            prstamt.setString(5, user.getUserName());
            prstamt.setString(6, user.getPassword());

            System.out.println("senha do DAO: " + user.getPassword());

            int r = prstamt.executeUpdate();
            return r > 0;

        } catch (SQLException e) {
            throw new RuntimeException("error registering user: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean checkRegister(String userName, String password) {
        String sql = "SELECT password, username FROM CLIENTE WHERE password = ? AND username = ?";

        try (Connection connection = getConnectionGerc();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, password);
            preparedStatement.setString(2, userName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar registro de usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public Integer idUser(String userName) {
        String sql = "SELECT id FROM cliente WHERE username = ?";
        Integer id = null;

        try (Connection connection = getConnectionGerc();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, userName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return id;
    }

    public void inserticket() {
        String sql = "INSERT INTO ingresos";
        try (Connection connection = getConnectionGerc();
             PreparedStatement prstamt = connection.prepareStatement(sql)) {
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

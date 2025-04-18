package org.app.gerparque.repositorys;

import org.app.gerparque.models.User;

public interface IUserDAO {
    boolean register(User user);
    boolean checkRegister(String userName, String password);
    Integer idUser (String userName);
}
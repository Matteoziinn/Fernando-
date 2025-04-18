package org.app.gerparque.services;

import org.app.gerparque.DAO.UserDAO;
import org.app.gerparque.models.User;

public class UserService {
    private UserDAO usd = new UserDAO();


    public boolean CreateUser(String name, String email, String phoneNumber, String cpf, String userName,String password) {
        if (name == null || name.isEmpty() || email == null || email.isEmpty() ||
                phoneNumber == null || phoneNumber.isEmpty() || cpf == null || cpf.isEmpty() ||
                userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
        User usr = new User();
        usr.setName(name);
        usr.setEmail(email);
        usr.setCpf(cpf);
        usr.setPhoneNumber(phoneNumber);
        usr.setUserName(userName);
        usr.setPassword(password);

        boolean isRegistered = usd.register(usr);

        System.out.println("senha do service: " + password + "senha do getUser no service: " + usr.getPassword());

        if (isRegistered && usd.checkRegister(userName, password)) {
            return true;
        }

        return false;
    }

    public boolean checkLogin (String userName, String password) {
        return usd.checkRegister(userName,password);
    }


}

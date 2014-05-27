package com.testproject.services;

import com.testproject.interfaces.LoginService;
import com.testproject.models.Login;

public class LoginServiceImpl implements LoginService {

    public void checkLogin(Login login) {
        System.out.println("Username: "+login.getUsername());
        System.out.println("Password: "+login.getPassword());
    }
}

package com.testproject.controllers;

import com.testproject.interfaces.LoginService;
import com.testproject.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@Component
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    private ModelAndView serveLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(value="/account", method=RequestMethod.GET)
    private ModelAndView serveAccount() {
        return new ModelAndView("account");
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    private ModelAndView serveAccount(@Valid Login login, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("login");
        } else {
            loginService.checkLogin(login);
            return new ModelAndView("redirect:/account");
        }
    }
}
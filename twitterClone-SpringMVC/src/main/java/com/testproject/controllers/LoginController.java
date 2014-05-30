package com.testproject.controllers;

import com.testproject.interfaces.LoginService;
import com.testproject.models.Login;
import com.testproject.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@Component
@RequestMapping("/")
public class LoginController {
    private LoginServiceImpl loginServiceImpl;

    @Autowired
    public LoginController(LoginServiceImpl loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }

    @RequestMapping(method=RequestMethod.GET)
    private ModelAndView serveLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(method=RequestMethod.POST)
    private ModelAndView checkLogin(@Valid Login login, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("login");
        } else {
            loginServiceImpl.checkLogin(login);
            return new ModelAndView("redirect:account");
        }
    }
}
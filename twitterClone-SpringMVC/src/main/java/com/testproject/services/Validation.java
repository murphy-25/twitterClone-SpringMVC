package com.testproject.services;

import com.testproject.models.Login;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends AbstractAuthenticationProcessingFilter {

    protected Validation(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
        Login login = new Login();
        login.setUsername(req.getParameter("username"));
        login.setPassword(req.getParameter("password"));

        Errors errors = new BeanPropertyBindingResult(login, "login");
        if(errors.hasErrors()) {
            System.out.println("1st: SHIT");
        }
        System.out.println("2nd: FUCK");

        Authentication authResult = this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        return authResult;
    }


}

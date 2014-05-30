package com.testproject.services;

import com.testproject.interfaces.LoginService;
import com.testproject.models.Login;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class LoginServiceImpl extends NamedParameterJdbcDaoSupport implements LoginService {

    public void checkLogin(Login login) {
        String sql = "INSERT INTO login (username, password) VALUES (:username, :password)";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(login);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }
}


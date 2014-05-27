package com.testproject.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class Login {
    @NotNull
    @Size(min=3, max=10, message="Username must be at least 3 characters and no more than 10 characters long.")
    @Pattern(regexp="^[a-z0-9A-Z]*+$", message="Username must contain only letters and numbers")
    private String username;
    @NotNull
    @Size(min=3, max=10, message="Password must be at least 3 characters and no more than 10 characters long.")
    @Pattern(regexp="^[a-z0-9A-Z]*+$", message="Password must contain only letters and numbers")
    private String password;

    public Login() {}
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}




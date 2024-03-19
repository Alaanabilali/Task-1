package com.example.myapplication.model;

public class SignupModel {
    private String username;
    private String email;
    private String password;

    public SignupModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

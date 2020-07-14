package com.example.quizerev.Model;

public class User {
    String name;
    String email;
    String login;
    String pswd;

    public User(String name, String email, String login, String pswd) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}

package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotEmpty(message = "Username is a required field")
    @Size(min = 5, max = 15)
    private String username;

    @Email(message = "Email is optional, but must be valid")
    @Size(min = 0, max = 30)
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Must be at least 6 characters")
    private String password;

    @NotNull(message = "Password must match")
    private String verifyPassword;

    public User(){

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(){
        if(this.password != null && this.password.equals(verifyPassword)){
            verifyPassword = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public String getPassword() {
        return password;
    }
}

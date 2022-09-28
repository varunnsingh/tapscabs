package com.tapsCabs.DTO;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote DTO for Users pojo
 */
public class Customer {
    private int userId;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String number;
    @NotBlank
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

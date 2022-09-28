package com.tapsCabs.pojos;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote pojo representing the registered user
 */
@Entity
@Table
public class Users {
    @Id
    private int userId;
    private String name;

    private String email;

    private String number;

    private String role;


    private String password;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



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

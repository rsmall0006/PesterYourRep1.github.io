package com.pester.entities;

import javax.persistence.*;

/**
 * Created by octavio on 4/25/17.
 */

@Entity
@Table
public class LogInUser {

    @Id
    @GeneratedValue
    int id;

    @Column(unique = true)
    String emailAddress;

    @Column(nullable = false)
    String password;

    public LogInUser(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.ssy.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "login", schema = "ssy")
@Data
public class Login {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "account")
    private String account;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "user_name")
    private String userName;

    @Basic
    @Column(name = "user_tel")
    private String userTel;

    @Basic
    @Column(name = "state")
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

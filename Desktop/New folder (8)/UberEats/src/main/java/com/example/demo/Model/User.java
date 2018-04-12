/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "User")
public class User implements Serializable{
    
    @Id
    private long id;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="status")
    private String status;
    
    @Column(name="type")
    private String type;
    
    @Column(name="username")
    private String userName;

    protected User(){
        
    }

    public User(long id, String email, String password, String phone, String status, String type, String userName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.type = type;
        this.userName = userName;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", phone=" + phone + ", status=" + status + ", type=" + type + ", userName=" + userName + '}';
    }
 
    
}

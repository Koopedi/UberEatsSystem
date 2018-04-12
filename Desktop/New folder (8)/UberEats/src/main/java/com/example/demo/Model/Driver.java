/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Driver")
public class Driver implements Serializable{
    
    @Id
    private int id;
    
    @Column(name = "drivername")
    private String driverName;
    
    @Column(name = "streetname")
    private String streetName;
    
    @Column(name = "areaname")
    private String areaName;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "province")
    private String province;
    
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

    protected Driver(){
        
    }
    public Driver(int id,String driverName, String streetName, String areaName, String city, String province, String email, String password, String phone, String status, String type) {
       this.id = id;
        this.driverName = driverName;
        this.streetName = streetName;
        this.areaName = areaName;
        this.city = city;
        this.province = province;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + ", driverName=" + driverName + ", streetName=" + streetName + ", areaName=" + areaName + ", city=" + city + ", province=" + province + ", email=" + email + ", password=" + password + ", phone=" + phone + ", status=" + status + ", type=" + type + '}';
    }
    
    
}

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
@Table(name = "restuarants")
public class Restuarant implements Serializable {
        
    @Id
    @Column(name = "restuarantID")
    private String id ;
    
    @Column(name = "imagefile")
    private String imageFile;
    
    @Column(name = "restuarantname")
    private String restuarantName;
    
    @Column(name = "streetname")
    private String streetName;
    
    
    @Column(name = "areaname")
    private String areaName;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "province")
    private String province;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    public Restuarant() {
    }

    public Restuarant(String id, String imageFile, String restuarantName, String streetName, String areaName, String city, String province, String email, String phone) {
        this.id = id;
        this.imageFile = imageFile;
        this.restuarantName = restuarantName;
        this.streetName = streetName;
        this.areaName = areaName;
        this.city = city;
        this.province = province;
        this.email = email;
        this.phone = phone;
    }

  

    public Restuarant(String id) {
        this.id = id;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestuarantName() {
        return restuarantName;
    }

    public void setRestuarantName(String restuarantName) {
        this.restuarantName = restuarantName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Restuarant{" + "id=" + id + ", imageFile=" + imageFile + ", restuarantName=" + restuarantName + ", streetName=" + streetName + ", areaName=" + areaName + ", city=" + city + ", province=" + province + ", email=" + email + ", phone=" + phone + '}';
    }

  
   

      
}

package com.example.demo.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "DeliveryRegister")
public class DeliveryRegister implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name= "deliverydate")
    private String deliveryDate;
    
    @Column(name="recipientname")
    private String recipientName;
    
    @Column(name = "recipientsurname")
    private String recipientSurname;
    
    @Column(name = "recipientphone")
    private String recipientPhone;
    
    @Column(name = "streetname")
    private String streetName;
    
    @Column(name = "areaname")
    private String areaName;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "province")
    private String province;
    
    @Column(name = "additionalinformation")
    private String additionalInformation;
    
    @Column(name = "status")
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "driverid")
    private Driver driver;
    
    @Column(name = "orderstatus")
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    protected DeliveryRegister(){
        
    }

    public DeliveryRegister(int id, String deliveryDate, String recipientName, String recipientSurname, String recipientPhone, String streetName, String areaName, String city, String province, String additionalInformation, String status, Driver driver, String orderStatus, Customer customer) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.recipientPhone = recipientPhone;
        this.streetName = streetName;
        this.areaName = areaName;
        this.city = city;
        this.province = province;
        this.additionalInformation = additionalInformation;
        this.status = status;
        this.driver = driver;
        this.orderStatus = orderStatus;
        this.customer = customer;
    }
    
   

    public DeliveryRegister(int id, String deliveryDate, String recipientName, String recipientSurname, String recipientPhone, String streetName, String areaName, String city, String province, String additionalInformation, String status, String orderStatus, Customer customer) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.recipientPhone = recipientPhone;
        this.streetName = streetName;
        this.areaName = areaName;
        this.city = city;
        this.province = province;
        this.additionalInformation = additionalInformation;
        this.status = status;
        this.orderStatus = orderStatus;
        this.customer = customer;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int deliveryRegisterNumber) {
        this.id = deliveryRegisterNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public void setRecipientSurname(String recipientSurname) {
        this.recipientSurname = recipientSurname;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
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

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "DeliveryRegister{" + "id=" + id + ", deliveryDate=" + deliveryDate + ", recipientName=" + recipientName + ", recipientSurname=" + recipientSurname + ", recipientPhone=" + recipientPhone + ", streetName=" + streetName + ", areaName=" + areaName + ", city=" + city + ", province=" + province + ", additionalInformation=" + additionalInformation + ", status=" + status + ", driver=" + driver + '}';
    }

    
}

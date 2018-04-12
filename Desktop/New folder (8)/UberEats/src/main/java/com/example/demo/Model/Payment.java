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
@Table(name = "Payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cardnumber")
    private String cardNumber;

    @Column(name = "cardholdername")
    private String cardHolderName;

    @Column(name = "expirydate")
    private String expiryDate;

    @Column(name = "cvvnumber")
    private int cvvNumber;

    @Column(name = "orderstatus")
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    protected Payment() {

    }

    public Payment(int id, String cardNumber, String cardHolderName, String expiryDate, int cvvNumber, String orderStatus, Customer customer) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvvNumber = cvvNumber;
        this.orderStatus = orderStatus;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int paymentNumber) {
        this.id = paymentNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
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
        return "Payment{" + "id=" + id + ", cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", expiryDate=" + expiryDate + ", cvvNumber=" + cvvNumber + ", orderStatus=" + orderStatus + ", customer=" + customer + '}';
    }

}

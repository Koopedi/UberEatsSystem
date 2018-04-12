package com.example.demo.Model;

import com.example.demo.Model.Customer;
import com.example.demo.Model.DeliveryRegister;
import com.example.demo.Model.Payment;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="ProductOrder")
public class ProductOrder {
    
    @Id
    private int id;
    
    @Column(name="orderdate")
    private String orderDate;
    
    @Column(name="totalprice")
    private double totalPrice;
    
    @Column(name = "totalquantity")
    private int totalQuantity;
    
    @Column(name = "status")
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "deliveryregisterid")
    private DeliveryRegister deliveryRegister;
    
    @ManyToOne
    @JoinColumn(name = "paymentid")
    private Payment payment;
    
    public ProductOrder(){
        
    }

    public ProductOrder(String orderDate, double totalPrice, int totalQuantity, Customer customer, DeliveryRegister deliveryRegister, Payment payment) {
       
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.customer = customer;
        this.deliveryRegister = deliveryRegister;
        this.payment = payment;
    }

    public ProductOrder(String orderDate, double totalPrice, int totalQuantity, String status, Customer customer) {
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.status = status;
        this.customer = customer;
    }

    public ProductOrder(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DeliveryRegister getDeliveryRegister() {
        return deliveryRegister;
    }

    public void setDeliveryRegister(DeliveryRegister deliveryRegister) {
        this.deliveryRegister = deliveryRegister;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
//    @Override
//    public String toString() {
//        return "Order{" + "id=" + id + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", totalQuantity=" + totalQuantity + ", customer=" + customer + ", deliveryRegister=" + deliveryRegister + ", payment=" + payment + '}';
//    }

    @Override
    public String toString() {
        return "ProductOrder{" + "id=" + id + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", totalQuantity=" + totalQuantity + ", status=" + status + ", customer=" + customer + ", deliveryRegister=" + deliveryRegister + ", payment=" + payment + '}';
    }
    
    
}

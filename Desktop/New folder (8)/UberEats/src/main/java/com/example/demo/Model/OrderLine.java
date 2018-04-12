package com.example.demo.Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="OrderLine")
public class OrderLine implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "subtotal")
    private double subTotal;
    
    @Column(name="quantity")
    private int quantity;
    
    @ManyToOne()
    @JoinColumn(name = "orderid")
    private ProductOrder order;
    
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
    
    protected OrderLine(){
        
    }

    public OrderLine(int id, double subTotal, int quantity, ProductOrder order, Product product) {
        this.id = id;
        this.subTotal = subTotal;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductOrder getOrder() {
        return order;
    }

    public void setOrder(ProductOrder order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderLine{" + "id=" + id + ", subTotal=" + subTotal + ", quantity=" + quantity + ", order=" + order + ", product=" + product + '}';
    }

    
    
    
}

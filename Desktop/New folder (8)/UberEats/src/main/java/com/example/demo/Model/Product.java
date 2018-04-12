package com.example.demo.Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "productname")
    private String productName;

    @Column(name = "productquantity")
    private int productQuantity;

    @Column(name = "unitprice")
    private double unitPrice;

    @Column(name = "category")
    private String category;

    @Column(name = "imagefile")
    private String imageFile;

    @ManyToOne
    @JoinColumn(name = "administratorid")
    private Administrator administrator;

    @ManyToOne
    @JoinColumn(name = "restuarantid")
    private Restuarant restuarant;

    protected Product() {

    }

    public Product( String productName, int productQuantity, double unitPrice, String category, String imageFile, Administrator administrator, Restuarant restuarant) {
       
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.unitPrice = unitPrice;
        this.category = category;
        this.imageFile = imageFile;
        this.administrator = administrator;
        this.restuarant = restuarant;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Restuarant getRestuarant() {
        return restuarant;
    }

    public void setRestuarant(Restuarant restuarant) {
        this.restuarant =  restuarant;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productName=" + productName + ", productQuantity=" + productQuantity + ", unitPrice=" + unitPrice + ", category=" + category + ", imageFile=" + imageFile + ", administrator=" + administrator + ", restuarant=" + restuarant + '}';
    }

   
}

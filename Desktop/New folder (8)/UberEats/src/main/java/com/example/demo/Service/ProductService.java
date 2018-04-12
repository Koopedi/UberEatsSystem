/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.Response;
import com.example.demo.Model.Restuarant;
import com.example.demo.Model.User;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.RestuarantRepository;
import com.example.demo.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

     @Autowired
    RestuarantRepository restuarantRepository;
     
    public void postProduct(Product product) {
 
       
          productRepository.save(new Product(product.getProductName(), product.getProductQuantity(),
                product.getUnitPrice(), product.getCategory(), product.getImageFile(), product.getAdministrator(), product.getRestuarant()));
    }

    
    public Response findByCategory(String category) {

        List<Product> products = productRepository.findByCategory(category);

        if (products.size() > 0) {
            return new Response("Done", products);
        } else {
            return new Response("Nope", products);
        }
    }
    
    
       public Response findByRestuarnt(String restuarant) {

           List<Restuarant> restuarants =  restuarantRepository.findById(restuarant);
           
          Restuarant res = new Restuarant();
           
          for(int i=0;i<restuarants.size();i++){
              res.setId(restuarants.get(i).getId());
              res.setAreaName(restuarants.get(i).getAreaName());
              res.setCity(restuarants.get(i).getCity());
              res.setEmail(restuarants.get(i).getEmail());
              res.setImageFile(restuarants.get(i).getImageFile());
              res.setPhone(restuarants.get(i).getPhone());
              res.setProvince(restuarants.get(i).getProvince());
              res.setRestuarantName(restuarants.get(i).getRestuarantName());
              res.setStreetName(restuarants.get(i).getStreetName());
          }
           
           
        List<Product> products = productRepository.findByRestuarant(res);

        if (products.size() >= 0) {
            return new Response("Done", products);
        } else {
            return new Response("Nope", products);
        }
    }
    

    
    public Response findByProductName(String productName) {

        List<Product> products = productRepository.findByProductName(productName);

        if (products.size() > 0) {
            return new Response("Done", products);
        } else {
            return new Response("Nope", products);
        }
    }

    
    public void deleteByProductId(int id) {

        productRepository.delete(id);

    }

    public Product updateById(int id) {

        List<Product> prod = productRepository.findById(id);
        Product product = null;

        for (int i = 0; i < prod.size(); i++) {
            product = prod.get(i);
        }
        return product;
    }

    
    public void updateProduct(int id, int productQuantity, double unitPrice, String productName) {

        Product product = updateById(id);

        product.setProductName(productName);
        product.setProductQuantity(productQuantity);
        product.setUnitPrice(unitPrice);

        productRepository.save(product);
    }

    
    public Response getAllProducts() {

        Iterable<Product> customers = productRepository.findAll();

        return new Response("Done", customers);
    }

    
  
 
}

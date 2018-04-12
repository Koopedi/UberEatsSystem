package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Product;
import com.example.demo.Model.Restuarant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findByCategory(String category);
    List<Product> findByProductName(String productName);
    List<Product> findById(int id);
    List<Product> findByRestuarant(Restuarant restuarant);
 
}

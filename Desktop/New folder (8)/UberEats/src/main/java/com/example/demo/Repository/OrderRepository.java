package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.ProductOrder;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<ProductOrder, Integer> {

   List<ProductOrder> findByStatusAndCustomer(String status,Customer customer);
   List<ProductOrder> findById(int id);
}

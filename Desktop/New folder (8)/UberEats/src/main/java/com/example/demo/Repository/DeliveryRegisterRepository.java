package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.DeliveryRegister;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface DeliveryRegisterRepository extends CrudRepository<DeliveryRegister, Integer> {

    List<DeliveryRegister> findByCityAndStatus(String city,String status);
    List<DeliveryRegister> findById(int id);
    List<DeliveryRegister> findByOrderStatusAndCustomer(String orderStatus, Customer customer);
}

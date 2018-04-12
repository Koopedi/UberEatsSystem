package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Payment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    List<Payment> findByOrderStatusAndCustomer(String orderStatus, Customer customer);
    List<Payment> findById(int id);
}

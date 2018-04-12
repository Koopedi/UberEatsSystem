/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Response;
import com.example.demo.Repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void postCustomer(Customer customer) {

        customerRepository.save(new Customer(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getGender(), customer.getEmail(),
                customer.getPassword(), customer.getPhone(), customer.getStatus(), customer.getType()));
    }

    public Response findByEmail(String email) {

        List<Customer> customers = customerRepository.findByEmail(email);

        return new Response("Done", customers);

    }
}

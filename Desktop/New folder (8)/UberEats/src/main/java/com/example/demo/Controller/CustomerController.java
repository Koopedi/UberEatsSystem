package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Response;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
    public void postCustomer(@RequestBody Customer customer) {

        customerService.postCustomer(customer);
    }

    @RequestMapping("/findbycustomeremail")
    public Response findByEmail(@RequestParam("email") String email) {

        Response response = customerService.findByEmail(email);

        return response;
    }
}

package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Payment;
import com.example.demo.Model.Response;
import com.example.demo.Service.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;
    
    @RequestMapping(value = "/postpayment", method = RequestMethod.POST)
    public void postPayment(@RequestBody Payment payment) {
        
        paymentService.postPayment(payment);
    }
    
    @RequestMapping(value = "/findbyorderstatuscustomerpayment", method = RequestMethod.GET)
    public Response findByOrderStatusAndCustomer(@RequestParam("orderstatus") String orderStatus, @RequestParam("customer") Customer customer) {
        
        Response response = paymentService.findByOrderStatusAndCustomer(orderStatus, customer);
        
        return response;
        
    }
    
    public Payment updateById(int id) {
        
        Payment payment = paymentService.updateById(id);
        
        return payment;
    }
    
    @RequestMapping(value = "/updatepaymentorder/{id}/{orderstatus}", method = RequestMethod.POST)
    public void updateOrderStaus(@PathVariable int id, @PathVariable String orderstatus) {
        
        paymentService.updateOrderStaus(id, orderstatus);
    }
    
}

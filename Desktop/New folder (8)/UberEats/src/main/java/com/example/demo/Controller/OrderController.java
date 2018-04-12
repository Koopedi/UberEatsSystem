package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.DeliveryRegister;
import com.example.demo.Model.Payment;
import com.example.demo.Model.ProductOrder;
import com.example.demo.Model.Response;
import com.example.demo.Repository.DeliveryRegisterRepository;
import com.example.demo.Service.OrderService;
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
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @Autowired
    PaymentService paymentService;
    
    @Autowired
    DeliveryRegisterRepository deliveryRegisterRepository;
    
    @RequestMapping(value = "/postorder", method = RequestMethod.POST)
    public void postOrder(@RequestBody ProductOrder order) {
        orderService.postOrder(order);
    }
    
    @RequestMapping(value = "/postorders", method = RequestMethod.POST)
    public void postOrders(@RequestBody ProductOrder order) {
        orderService.postOrders(order);
        
    }
    
    @RequestMapping(value = "/findbystatuscustomer", method = RequestMethod.GET)
    public Response findByStatusAndCustomer(@RequestParam("status") String status, @RequestParam("customer") Customer customer) {
        
        Response response = orderService.findByStatusAndCustomer(status, customer);
        
        return response;
    }
    
    public ProductOrder updateById(int id) {
        
        ProductOrder productOrder = orderService.updateById(id);
        
        return productOrder;
    }
    
    public Payment findById(int id) {
        
        Payment payment = paymentService.findById(id);
        
        return payment;
    }
    
    public DeliveryRegister findById1(int id) {
        
        DeliveryRegister deliveryRegister = orderService.findById1(id);
        
        return deliveryRegister;
        
    }
    
    @RequestMapping(value = "/updateorder/{id}/{paymentid}/{deliveryid}/{totalprice}/{totalquantity}", method = RequestMethod.POST)
    public void updateOrder(@PathVariable int id, @PathVariable int paymentid, @PathVariable int deliveryid,
            @PathVariable double totalprice, @PathVariable int totalquantity) {
        
        orderService.updateOrder(id, paymentid, deliveryid, totalprice, totalquantity);
        
    }
    
    @RequestMapping(value = "/updateorderstatus/{id}/{status}", method = RequestMethod.POST)
    public void updateOrderStatus(@PathVariable int id, @PathVariable String status) {
        
        orderService.updateOrderStatus(id, status);
        
    }

    
      @RequestMapping(value = "getallorders",method = RequestMethod.GET)
    public Response getAllRestuarant()
    {
        Response response = orderService.getAllOrders();
        return response;
    }
}

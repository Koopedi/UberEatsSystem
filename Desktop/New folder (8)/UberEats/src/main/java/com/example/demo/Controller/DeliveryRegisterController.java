package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.DeliveryRegister;
import com.example.demo.Model.Driver;
import com.example.demo.Model.Response;
import com.example.demo.Service.DeliveryRegisterService;
import com.example.demo.Service.DriverService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeliveryRegisterController {

    @Autowired
    DeliveryRegisterService deliveryRegisterService;

    @Autowired
    DriverService driverService;

    @RequestMapping(value = "/postdeliveryregister", method = RequestMethod.POST)
    public void postDeliveryRegister(@RequestBody DeliveryRegister deliveryRegister) {

        deliveryRegisterService.postDeliveryRegister(deliveryRegister);

    }

    @RequestMapping(value = "/postdeliveryregisters", method = RequestMethod.POST)
    public void postDeliveryRegisters(@RequestBody DeliveryRegister deliveryRegister) {

        deliveryRegisterService.postDeliveryRegisters(deliveryRegister);
    }

    @RequestMapping(value = "/findbydrivercity", method = RequestMethod.GET)
    public Response findByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {

        Response response = deliveryRegisterService.findByEmailAndPassword(email, password);

        return response;
    }

    public DeliveryRegister updateById(int id) {

        DeliveryRegister deliveryRegister = deliveryRegisterService.updateById(id);

        return deliveryRegister;
    }

    public Driver findByEmailAndPasswordDetails(String email, String password) {

        Driver driver = driverService.findByEmailAndPasswordDetails(email, password);

        return driver;
    }

    @RequestMapping(value = "/updatedeliveryregister/{id}/{status}/{email}/{password}", method = RequestMethod.POST)
    public void updateDeliveryRegister(@PathVariable int id, @PathVariable String status, @PathVariable String email, @PathVariable String password) {

        deliveryRegisterService.updateDeliveryRegister(id, status, email, password);

    }

    @RequestMapping(value = "/updatedeliverystatus", method = RequestMethod.GET)
    public Response findByEmailAndPasswords(@RequestParam("email") String email, @RequestParam("password") String password) {

        Response response = deliveryRegisterService.findByEmailAndPasswords(email, password);

        return response;
    }

    @RequestMapping(value = "/findbyorderstatuscustomerdelivery", method = RequestMethod.GET)
    public Response findByOrderStatusAndCustomer(@RequestParam("orderstatus") String orderStatus, @RequestParam("customer") Customer customer) {

        Response response = deliveryRegisterService.findByOrderStatusAndCustomer(orderStatus, customer);

        return response;

    }

    @RequestMapping(value = "/updatedeliveryregisterorder/{id}/{orderstatus}", method = RequestMethod.POST)
    public void updateOrderStaus(@PathVariable int id, @PathVariable String orderstatus) {

        deliveryRegisterService.updateOrderStaus(id, orderstatus);

    }

}



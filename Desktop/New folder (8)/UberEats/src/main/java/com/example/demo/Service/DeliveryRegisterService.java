package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.DeliveryRegister;
import com.example.demo.Model.Driver;
import com.example.demo.Model.Response;
import com.example.demo.Repository.DeliveryRegisterRepository;
import com.example.demo.Repository.DriverRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeliveryRegisterService {

    @Autowired
    DeliveryRegisterRepository deliveryRegisterRepository;

    @Autowired
    DriverRepository driverRepository;

    public void postDeliveryRegister(DeliveryRegister deliveryRegister) {

        deliveryRegisterRepository.save(new DeliveryRegister(deliveryRegister.getId(), deliveryRegister.getDeliveryDate(),
                deliveryRegister.getRecipientName(), deliveryRegister.getRecipientSurname(), deliveryRegister.getRecipientPhone(),
                deliveryRegister.getStreetName(), deliveryRegister.getAreaName(), deliveryRegister.getCity(), deliveryRegister.getProvince(),
                deliveryRegister.getAdditionalInformation(), deliveryRegister.getStatus(), deliveryRegister.getDriver(), deliveryRegister.getOrderStatus(), deliveryRegister.getCustomer()));
    }

    public void postDeliveryRegisters(DeliveryRegister deliveryRegister) {

        deliveryRegisterRepository.save(new DeliveryRegister(deliveryRegister.getId(), deliveryRegister.getDeliveryDate(),
                deliveryRegister.getRecipientName(), deliveryRegister.getRecipientSurname(), deliveryRegister.getRecipientPhone(),
                deliveryRegister.getStreetName(), deliveryRegister.getAreaName(), deliveryRegister.getCity(), deliveryRegister.getProvince(),
                deliveryRegister.getAdditionalInformation(), deliveryRegister.getStatus(), deliveryRegister.getOrderStatus(), deliveryRegister.getCustomer()));
    }

    public Response findByEmailAndPassword(String email, String password) {

        String city;
        String status = "pending";

        List<Driver> drivers = driverRepository.findByEmailAndPassword(email, password);

        Driver driver = null;

        for (int i = 0; i < drivers.size(); i++) {
            driver = drivers.get(i);

        }

        city = driver.getCity();

        List<DeliveryRegister> deliveryRegister = deliveryRegisterRepository.findByCityAndStatus(city, status);

        if (deliveryRegister.size() > 0) {
            return (new Response("Done", deliveryRegister));
        } else {
            return (new Response("Not Found", deliveryRegister));
        }

    }

    public DeliveryRegister updateById(int id) {

        List<DeliveryRegister> deli = deliveryRegisterRepository.findById(id);
        DeliveryRegister deliveryRegister = null;

        for (int i = 0; i < deli.size(); i++) {
            deliveryRegister = deli.get(i);
        }
        return deliveryRegister;
    }

    public Driver findByEmailAndPasswordDetails(String email, String password) {

        List<Driver> drivers = driverRepository.findByEmailAndPassword(email, password);

        Driver driver = null;

        for (int i = 0; i < drivers.size(); i++) {
            driver = drivers.get(i);

        }
        return driver;
    }

    public void updateDeliveryRegister(int id, String status, String email, String password) {

        DeliveryRegister deliveryRegister = updateById(id);

        Driver driver = findByEmailAndPasswordDetails(email, password);

        deliveryRegister.setStatus(status);
        deliveryRegister.setDriver(driver);

        deliveryRegisterRepository.save(deliveryRegister);
    }

    public Response findByEmailAndPasswords(String email, String password) {

        String city;
        String status = "delivering";

        List<Driver> drivers = driverRepository.findByEmailAndPassword(email, password);

        Driver driver = null;

        for (int i = 0; i < drivers.size(); i++) {
            driver = drivers.get(i);

        }

        city = driver.getCity();

        List<DeliveryRegister> deliveryRegister = deliveryRegisterRepository.findByCityAndStatus(city, status);

        if (deliveryRegister.size() > 0) {
            return (new Response("Done", deliveryRegister));
        } else {
            return (new Response("Nope", deliveryRegister));
        }

    }

    public Response findByOrderStatusAndCustomer(String orderStatus, Customer customer) {

        List<DeliveryRegister> deliveryRegister = deliveryRegisterRepository.findByOrderStatusAndCustomer(orderStatus, customer);

        return new Response("Done", deliveryRegister);

    }

    public void updateOrderStaus(int id, String orderstatus) {

        DeliveryRegister deliveryRegister = updateById(id);

        deliveryRegister.setOrderStatus(orderstatus);

        deliveryRegisterRepository.save(deliveryRegister);
    }

}

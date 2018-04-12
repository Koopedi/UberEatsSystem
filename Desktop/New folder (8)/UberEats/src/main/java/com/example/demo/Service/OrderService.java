package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.DeliveryRegister;
import com.example.demo.Model.Payment;
import com.example.demo.Model.ProductOrder;
import com.example.demo.Model.Response;
import com.example.demo.Repository.DeliveryRegisterRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    DeliveryRegisterRepository deliveryRegisterRepository;

    public void postOrder(ProductOrder order) {
        orderRepository.save(new ProductOrder(order.getOrderDate(), order.getTotalPrice(),
                order.getTotalQuantity(), order.getCustomer(), order.getDeliveryRegister(), order.getPayment()));
    }

    public void postOrders(ProductOrder order) {
        orderRepository.save(new ProductOrder(order.getOrderDate(), order.getTotalPrice(),
                order.getTotalQuantity(), order.getStatus(), order.getCustomer()));

    }

    public Response findByStatusAndCustomer(String status, Customer customer) {

        List<ProductOrder> products = orderRepository.findByStatusAndCustomer(status, customer);

        if (products.size() > 0) {
            return new Response("Done", products);
        } else {
            return new Response("Nope", products);
        }
    }

    public ProductOrder updateById(int id) {

        List<ProductOrder> po = orderRepository.findById(id);
        ProductOrder productOrder = null;

        for (int i = 0; i < po.size(); i++) {
            productOrder = po.get(i);
        }
        return productOrder;
    }

    public Payment findById(int id) {

        List<Payment> payments = paymentRepository.findById(id);

        Payment payment = null;

        for (int i = 0; i < payments.size(); i++) {
            payment = payments.get(i);

        }
        return payment;
    }

    public DeliveryRegister findById1(int id) {

        List<DeliveryRegister> deliveryRegisters = deliveryRegisterRepository.findById(id);

        DeliveryRegister deliveryRegister = null;

        for (int i = 0; i < deliveryRegisters.size(); i++) {
            deliveryRegister = deliveryRegisters.get(i);

        }
        return deliveryRegister;
    }

    public void updateOrder(int id, int paymentid, int deliveryid, double totalprice, int totalquantity) {

        ProductOrder productOrder = updateById(id);

        Payment payment = findById(paymentid);
        DeliveryRegister deliveryRegister = findById1(deliveryid);

        productOrder.setPayment(payment);
        productOrder.setDeliveryRegister(deliveryRegister);
        productOrder.setTotalPrice(totalprice);
        productOrder.setTotalQuantity(totalquantity);

        orderRepository.save(productOrder);
    }

    public void updateOrderStatus(int id, String status) {

        ProductOrder productOrder = updateById(id);

        productOrder.setStatus(status);

        orderRepository.save(productOrder);
    }
    
    public Response getAllOrders()
    {
        Iterable<ProductOrder> order =orderRepository.findAll();
        return  new Response("Done",order);
    }

}

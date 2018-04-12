package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Payment;
import com.example.demo.Model.Response;
import com.example.demo.Repository.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public void postPayment(Payment payment) {

        paymentRepository.save(new Payment(payment.getId(), payment.getCardNumber(),
                payment.getCardHolderName(), payment.getExpiryDate(), payment.getCvvNumber(),
                payment.getOrderStatus(), payment.getCustomer()));
    }

    public Response findByOrderStatusAndCustomer(String orderStatus, Customer customer) {

        List<Payment> payment = paymentRepository.findByOrderStatusAndCustomer(orderStatus, customer);

        return new Response("Done", payment);

    }

    public Payment updateById(int id) {

        List<Payment> payments = paymentRepository.findById(id);
        Payment payment = null;

        for (int i = 0; i < payments.size(); i++) {
            payment = payments.get(i);
        }
        return payment;
    }

    public void updateOrderStaus(int id, String orderstatus) {

        Payment payment = updateById(id);

        payment.setOrderStatus(orderstatus);

        paymentRepository.save(payment);
    }
    
    public Payment findById(int id) {

        List<Payment> payments = paymentRepository.findById(id);

        Payment payment = null;

        for (int i = 0; i < payments.size(); i++) {
            payment = payments.get(i);

        }
        return payment;
    }

}

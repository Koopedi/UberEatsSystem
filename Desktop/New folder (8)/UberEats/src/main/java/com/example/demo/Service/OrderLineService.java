package com.example.demo.Service;

import com.example.demo.Model.OrderLine;
import com.example.demo.Repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    public void postOrderLine(OrderLine orderLine) {

        orderLineRepository.save(new OrderLine(orderLine.getId(), orderLine.getSubTotal(), orderLine.getQuantity(),
                orderLine.getOrder(), orderLine.getProduct()));
    }
}

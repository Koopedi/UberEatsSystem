package com.example.demo.Controller;

import com.example.demo.Model.OrderLine;
import com.example.demo.Service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderLineController {
    
    @Autowired
    OrderLineService orderLineService;
    
    
    @RequestMapping(value="/postorderline",method=RequestMethod.POST)
    public void postOrderLine(@RequestBody OrderLine orderLine){

        orderLineService.postOrderLine(orderLine);
        
    }
}

package com.example.demo.Repository;

import com.example.demo.Model.OrderLine;
import org.springframework.data.repository.CrudRepository;


public interface OrderLineRepository extends CrudRepository<OrderLine, Integer>{
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repository;

import com.example.demo.Model.Restuarant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RestuarantRepository  extends CrudRepository<Restuarant, Integer>{
    
 List<Restuarant> findByRestuarantName(String restuarantName);
 List<Restuarant> findById(String id);
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repository;

import com.example.demo.Model.Driver;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface DriverRepository extends CrudRepository<Driver, Integer>{
    List<Driver> findByEmailAndPassword(String email,String password);
}

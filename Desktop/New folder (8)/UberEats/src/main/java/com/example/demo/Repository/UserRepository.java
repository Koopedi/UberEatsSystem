/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repository;


import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.User;
import java.util.List;



public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByEmailAndPassword(String email, String password);
    List<User> findByStatus(String status);
    List<User> findById(Long id);
}

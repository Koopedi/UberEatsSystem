/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Service;

import com.example.demo.Model.Response;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private String email;
    private String password;
    
   
    @Autowired
    UserRepository userRepository;

    public UserService() {

    }

    public UserService(String email, String password) {
        this.email = email;
        this.password = password;
    }

    
    public void postUser(User user) {

        userRepository.save(new User(user.getId(), user.getEmail(), user.getPassword(), user.getPhone(),
                user.getStatus(), user.getType(), user.getUserName()));
    }

    
   
    public Response findByEmailAndPassword(String email, String password) {

        List<User> users = userRepository.findByEmailAndPassword(email, password);

        if (users.size() > 0) {
            return new Response("Done", users);
        } else {
            return new Response("Not", users);
        }

    }

    
    public Response findByStatus() {

        String status = "pending";
        List<User> users = userRepository.findByStatus(status);

        if (users.size() > 0) {
            return new Response("Done", users);
        } else {
            return new Response("Not", users);
        }

    }

    public User updateById(Long id) {

        List<User> prod = userRepository.findById(id);
        User user = null;

        for (int i = 0; i < prod.size(); i++) {
            user = prod.get(i);
        }
        return user;
    }

    
    public void updateUser(Long id) {

        String status = "approved";
        User user = updateById(id);

        user.setStatus(status);

        userRepository.save(user);
    }

}

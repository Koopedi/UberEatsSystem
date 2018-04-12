/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Service;

import com.example.demo.Model.Administrator;
import com.example.demo.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Repository.AdministratorRepository;
import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    public void postAdministrator(Administrator administrator) {

        administratorRepository.save(new Administrator(administrator.getId(), administrator.getFirstName(), administrator.getLastName(), administrator.getEmail(),
                administrator.getPassword(), administrator.getPhone(), administrator.getStatus(), administrator.getType()));
    }

    public Response findByEmail(String email) {

        List<Administrator> admin = administratorRepository.findByEmail(email);

        if (admin.size() > 0) {
            return new Response("Done", admin);
        } else {
            return new Response("Nope", admin);
        }
    }
}

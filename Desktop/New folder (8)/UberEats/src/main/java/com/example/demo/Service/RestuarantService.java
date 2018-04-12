/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Service;

import com.example.demo.Model.Response;
import com.example.demo.Model.Restuarant;
import com.example.demo.Repository.RestuarantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestuarantService {
   
    @Autowired
    RestuarantRepository restuarantRepository;
     public void postRestuarant(Restuarant restuarant) {

        restuarantRepository.save(new Restuarant(restuarant.getId(),restuarant.getImageFile(),restuarant.getRestuarantName(),
        restuarant.getStreetName(),restuarant.getAreaName(),restuarant.getCity()
                ,restuarant.getProvince(),restuarant.getEmail(),restuarant.getPhone()));
    }
     
      public Response findByRestuarantName(String restuarantName) {

        List<Restuarant> restuarants =  restuarantRepository.findByRestuarantName(restuarantName);
            

        if (restuarants.size() > 0) {
            return new Response("Done", restuarants);
        } else {
            return new Response("Nope", restuarants);
        }
    }
   public Restuarant updateById(String id) {

        List<Restuarant> restu = restuarantRepository.findById(id);
        Restuarant restuarant = null;

        for (int i = 0; i <restu.size(); i++) {
            restuarant = restu.get(i);
        }
        return restuarant;
    }

    
    public void updateRestuarant(String id, String restuarantName, String streetName, String areaName, String city, String province, String email, String phone) {

        Restuarant restuarant = updateById(id);

       
      restuarant.setStreetName(streetName);
      restuarant.setAreaName(areaName);
      restuarant.setCity(city);
      restuarant.setProvince(province);
      restuarant.setEmail(email);
      restuarant.setPhone(phone);      
        restuarantRepository.save(restuarant);
    }
    public Response getAllRestuarant(){
        Iterable<Restuarant> rest = restuarantRepository.findAll();
        return  new Response("Done", rest);
    }
    
    
}

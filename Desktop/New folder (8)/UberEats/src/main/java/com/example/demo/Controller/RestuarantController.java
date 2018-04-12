/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.Model.Response;
import com.example.demo.Model.Restuarant;
import com.example.demo.Service.RestuarantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestuarantController {
 @Autowired
 RestuarantService resturantService;
 
 
 @RequestMapping(value = "/postrestuarant",method = RequestMethod.POST)
 public void postRestuarant(@RequestBody Restuarant restuarant) {

       resturantService.postRestuarant(restuarant);

    }

  @RequestMapping(value = "/findbyrestuarantname", method = RequestMethod.GET)
 public Response findbyrestuarantname(@RequestParam("restuarantname")String restuarantName)
 {
    Response response = resturantService.findByRestuarantName(restuarantName);
return response;
 }

    
    
    
   public Restuarant updateById(String id) {
  Restuarant restuarant = resturantService.updateById(id);
  return restuarant;
    }

    @RequestMapping(value = "/updaterestuarant/{id}/{restuarantname}/{streetname}/{areaname}/{city}/{province}/{email}/{phone}", method = RequestMethod.POST)
    public void updateRestuarant(@PathVariable String id,@PathVariable String restuarantName,@PathVariable String streetName,@PathVariable String areaName,@PathVariable String city,@PathVariable String province,@PathVariable String email,@PathVariable String phone) {

       resturantService.updateRestuarant(id, restuarantName, streetName, areaName, city, province, email, phone);
    }
    @RequestMapping(value = "getallrestuarant",method = RequestMethod.GET)
    public Response getAllRestuarant()
    {
        Response response = resturantService.getAllRestuarant();
        return response;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Service;

import com.example.demo.Model.Driver;
import com.example.demo.Repository.DriverRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class DriverService {
    
    @Autowired
    DriverRepository driverRepository;
    
	public void postDriver(Driver driver) {
 
		driverRepository.save(new Driver(driver.getId(),driver.getDriverName(),driver.getStreetName(),driver.getAreaName(),
                driver.getCity(),driver.getProvince(),driver.getEmail(),driver.getPassword(),driver.getPhone(),driver.getStatus(),driver.getType()));
	}
        
        public Driver findByEmailAndPasswordDetails(String email, String password) {

        List<Driver> drivers = driverRepository.findByEmailAndPassword(email, password);

        Driver driver = null;

        for (int i = 0; i < drivers.size(); i++) {
            driver = drivers.get(i);

        }
        return driver;
    }
}

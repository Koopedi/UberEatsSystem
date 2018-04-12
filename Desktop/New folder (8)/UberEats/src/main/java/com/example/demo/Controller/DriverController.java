package com.example.demo.Controller;

import com.example.demo.Service.DriverService;
import com.example.demo.Model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @RequestMapping(value = "/postdriver", method = RequestMethod.POST)
    public void postDriver(@RequestBody Driver driver) {

        driverService.postDriver(driver);

    }

    @RequestMapping(value = "/findbyemailandpassworddriver", method = RequestMethod.GET)
    public Driver findByEmailAndPasswordDetails(@RequestParam("email") String email, @RequestParam("password") String password) {

        Driver driver = driverService.findByEmailAndPasswordDetails(email, password);

        return driver;
    }
}

package com.example.demo.Controller;

import com.example.demo.Model.Administrator;
import com.example.demo.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.AdministratorService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @RequestMapping(value = "/postadministrator", method = RequestMethod.POST)
    public void postAdministrator(@RequestBody Administrator administrator) {

        administratorService.postAdministrator(administrator);
    }

    @RequestMapping("/findbyadministratoremail")
    public Response findByEmail(@RequestParam("email") String email) {

        Response response = administratorService.findByEmail(email);

        return response;
    }
}
